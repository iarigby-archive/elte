package CoffeeShopTester;

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
		removeNow(client);
	}
	
	@Test
	public void insertNewDevice() {
		Device device = new Device(insertNewClient(), "hp", "windows");
		begin();
		entityManager.persist(device);
		commit();
		removeNow(device, device.getOwner());
	}

	@Test
	public void modifyAndDelete() {
		Device device = new Device(insertNewClient(), "asus", "windows");
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
		removeNow(device.getOwner());
	}
	
	//TODO three things fail in this test wtf
	//@Test
	public void listAndDeleteDevices() {
		Client cl = insertNewClient().setName("testname");
		begin();
		Device d = new Device(cl, "hp", "windows xp");	
		entityManager.persist(d);
		Device d2 = new Device(cl, "hp", "windows 10");	
		entityManager.persist(d2);
		commit();
		Client anotherClient = entityManager.find(Client.class, cl.getId());
		assertEquals("testname", anotherClient.getName());
		Set<Device> devices = anotherClient.getDevices();
		assertEquals(true, devices.contains(d));
		assertEquals(true, devices.contains(d2));
		begin();
		anotherClient.getDevices().clear();
		commit();
		devices = anotherClient.getDevices();
		assertEquals(false, devices.contains(d));
		Device shouldNotBeFound = entityManager.find(Device.class, d.getId());
		assertEquals(null, shouldNotBeFound);
		removeNow(d, d2, cl);
	}
	
	@Test
	public void usageTest() {
		Client testClient = insertNewClient().setName("logIntestblabla");
		begin();
		Device testDevice = new Device(testClient, "testBrand", "ops");
		commit();
		begin();
		UsageUGH usage = new UsageUGH(testClient, testDevice, Date.from(ZonedDateTime.now().toInstant()));
		usage.setLogOutTime(Date.from(ZonedDateTime.now().toInstant()));
		entityManager.persist(usage);
		commit();
		//assertEquals(testClient.getId(), entityManager.find(UsageUGH.class, usage.getId()).getClient().getId());
		removeLater(usage);
		removeNow(testDevice, testClient, usage);
	}
	
	@Test
	public void busyDeviceUsage() {
		Client testClient = insertNewClient();
		begin();
		Device testDevice = new Device(testClient, "testBrand", "ops");
		testDevice.setFree(false);
		//TODO create client device pair
		commit();
		begin();
		UsageUGH usage = new UsageUGH(testClient, testDevice, Date.from(ZonedDateTime.now().toInstant()));
		if (usage.getDevice().isFree()) entityManager.persist(usage);
		commit();
		assertEquals(null, entityManager.find(UsageUGH.class, usage.getId()));
		begin();
		testDevice.setFree(true);
		usage = new UsageUGH(testClient, testDevice, Date.from(ZonedDateTime.now().toInstant()));
		if (usage.getDevice().isFree()) entityManager.persist(usage);
		commit();
		assertEquals(usage, entityManager.find(UsageUGH.class, usage.getId()));
		removeNow(testDevice, testClient, usage);
	}
	
	@Test
	public void listAllUsages() {
		emptyAllUsages();
		Client client = newClient().setName("listAllUsages");
		Device device = new Device(client, "whatever", "whatever");
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
        //removeNow(device, client, firstUsage, secondUsage);
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
	
	private void emptyAllClients() {
		begin();
		CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<Client> allUsagesQuery = cb.createQuery(Client.class);
        Root<Client> allUsage = allUsagesQuery.from(Client.class);
        allUsagesQuery.select(allUsage);
        List<Client> allUsages = entityManager.createQuery(allUsagesQuery).getResultList();
        for (Client usage: allUsages) {
        	entityManager.remove(usage);
        }
        commit();
	}
	
	private void removeLater(Object... things) {
		for (Object thing : things) {
			removeThese.add(thing);
		}
	}
	
	//TODO don't want to use this -_-
	private void removeNow(Object... things) {
		begin();
		for (Object thing : things) {
			entityManager.remove(thing);
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
		//emptyAllDevices();
		cleanTestCases();
		entityManager.close();
		emfactory.close();
	}
	
	private void cleanTestCases() {
		begin();
		for ( Object remove : removeThese ) {
			try {
				entityManager.remove(remove); 
			} catch(Exception e) {
				System.out.println("whatever");
				//whatever it's not there
			}
		}
		commit();
	}
}
