package CoffeeShopTester;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Root;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.Client;
import model.Device;
import model.UsageUGH;



public class ClientTester {
	
	// TODO specify this with generics
	List<Object> removeThese = new ArrayList<Object>();
	
	EntityManagerFactory emfactory;
	EntityManager entityManager;
	
	@Before
	public void setup() {
		emfactory = Persistence.createEntityManagerFactory("InternetCoffeeShop_PU");
		entityManager = emfactory.createEntityManager();
	}
	
	@Test
	public void plsMakeDataAppearinSQL() {
		Client client = newClient().setName("plsmakeDataAppear");;
		begin();
		entityManager.persist(client);
		commit();
	}
	
	@Test
	public void insertNewDevice() {
		Device device = new Device("hp", "windows");
		begin();
		entityManager.persist(device);
		commit();
		removeThese.add(device);
	}

	@Test
	public void modifyAndDelete() {
		Device device = new Device("asus", "windows");
		begin();
		entityManager.persist(device);
		commit();
		begin();
		Device updateThis = entityManager.find(Device.class, device.getId());
		updateThis.setBrandName("delete");
		entityManager.merge(updateThis);
		commit();
		Device newDevice = entityManager.find(Device.class, device.getId());
		assertEquals("delete", newDevice.getBrandName());
		begin();
		entityManager.remove(newDevice);
		commit();
		assertEquals(null, entityManager.find(Device.class, device.getId()));
		removeThese.add(device);
	}
	
	//TODO three things fail in this test wtf
	@Test
	public void listAndDeleteDevices() {
		Client cl = insertNewClient().setName("testname");
		begin();
		Device d = new Device("hp", "windows xp");	
		//entityManager.persist(d);
		Device d2 = new Device("hp", "windows 10");	
		//entityManager.persist(d2);
		UsageUGH u = new UsageUGH(cl,d);
		entityManager.persist(u);
		UsageUGH u2 = new UsageUGH(cl, d2);
		entityManager.persist(u2);
		commit();
		Client anotherClient = entityManager.find(Client.class, cl.getId());
		assertEquals("testname", anotherClient.getName());
		Set<UsageUGH> usages = anotherClient.getUsages();
		usages.forEach(x -> {
			 int s = x.getDevice().getId();
			 assertTrue(s == d.getId() || s == d2.getId());
		 }
		);
		removeThese.add(d);
		removeThese.add(d2);
		removeThese.add(u);
		removeThese.add(u2);
	}
	
	@Test
	public void usageTest() {
		Client testClient = insertNewClient().setName("logIntestblabla");
		begin();
		Device testDevice = new Device("testBrand", "ops");
		UsageUGH usage = new UsageUGH(testClient, testDevice);
		usage.setLogOutTime(Date.from(ZonedDateTime.now().toInstant()));
		entityManager.persist(usage);
		commit();
		assertEquals(testDevice.getId(), entityManager.find(UsageUGH.class, usage.getId()).getDevice().getId());
		assertEquals(testClient.getId(), entityManager.find(UsageUGH.class, usage.getId()).getClient().getId());
		removeThese.add(testDevice);
		removeThese.add(usage);
	}
	
	@Test
	public void busyDeviceUsage() {
		Client testClient = insertNewClient();
		begin();
		Device testDevice = new Device("testBrand", "ops");
		testDevice.setFree(false);
		//TODO create client device pair
		commit();
		begin();
		UsageUGH usage = new UsageUGH(testClient, testDevice);
		if (usage.getDevice().isFree()) entityManager.persist(usage);
		commit();
		assertEquals(null, entityManager.find(UsageUGH.class, usage.getId()));
		begin();
		testDevice.setFree(true);
		commit();
		begin();
		usage = new UsageUGH(testClient, testDevice);
		if (usage.getDevice().isFree()) entityManager.persist(usage);
		commit();
		assertEquals(usage, entityManager.find(UsageUGH.class, usage.getId()));
		removeThese.add(testDevice);
		removeThese.add(usage);
	}
	
	@Test
	public void listAllUsages() {
		emptyAllUsages();
		Client client = newClient().setName("listAllUsages");
		Device device = new Device("whatever", "whatever");
		// TODO make random numbers
		UsageUGH firstUsage = new UsageUGH(client, device).setBill(3);
		UsageUGH secondUsage = new UsageUGH(client, device).setBill(5);
		begin();
		entityManager.persist(client);
		entityManager.persist(firstUsage);
		entityManager.persist(secondUsage);
		commit();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsageUGH> allUsagesQuery = cb.createQuery(UsageUGH.class);
        Root<UsageUGH> allUsage = allUsagesQuery.from(UsageUGH.class);
        allUsagesQuery.select(allUsage);
        List<UsageUGH> allUsages = entityManager.createQuery(allUsagesQuery).getResultList();
        int sum = 0;
        for (UsageUGH usage: allUsages) {
        	sum += usage.getBill();
        }
        assertEquals(8, sum);
        removeThese.add(device);
        removeThese.add(firstUsage);
        removeThese.add(secondUsage);
	}
	
	
	
	//TODO method including begin, persist, commit -_-
	
	//TODO create one empty which takes generic type (prespecified to be device, usage or client)
	private void emptyAllUsages() {
		begin();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<UsageUGH> allUsagesQuery = cb.createQuery(UsageUGH.class);
        Root<UsageUGH> allUsage = allUsagesQuery.from(UsageUGH.class);
        allUsagesQuery.select(allUsage);
        List<UsageUGH> allUsages = entityManager.createQuery(allUsagesQuery).getResultList();
        for (UsageUGH usage: allUsages) {
        	entityManager.remove(usage);
        }
        commit();
	}
	

	private Client newClient() {
		Client sth = new Client("random", "someaddress", "231AHS2");
		removeThese.add(sth);
		return sth;
	}
	
	private Client insertNewClient() {
		Client client = newClient();
		begin();
		entityManager.persist(client);
		commit();
		return client;
	}
	
	private void begin() {
		entityManager.getTransaction().begin();
	}
	
	private void commit() {
		entityManager.getTransaction().commit();
	}
	
	@After
	public void cleanup() {
		cleanTestCases();
		entityManager.close();
		emfactory.close();
	}
	
	private void cleanTestCases() {
		begin();
		for ( Object remove : removeThese ) {
			entityManager.remove(remove);	
		}
		commit();
	}
}
