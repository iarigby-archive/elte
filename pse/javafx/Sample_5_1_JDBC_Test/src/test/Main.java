package test;

import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.KeySpec;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Arrays;
import java.util.Random;

import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class Main {

    public static void main(String[] args) throws ClassNotFoundException {
        try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost/sqltest?user=tanulo&password=asd123&useSSL=false")) {
            char[] password = new char[] {'1','2','3'};
            insertUser(conn, "124", password);
            selectAllUsers(conn);
            System.out.println(exists(conn, "124", password));
            forgetPassword(password);
        } catch (SQLException | NoSuchAlgorithmException | InvalidKeySpecException ex) {
            ex.printStackTrace();
        }

    }

    private static void insertUser(Connection conn, String username, char[] password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        try (PreparedStatement stmt = conn.prepareStatement("INSERT INTO user(Username, Password, Salt) " + "VALUES(?, ?, ?)")) {
            byte[] salt = new byte[16];
            new Random().nextBytes(salt);
            
            stmt.setString(1, username);
            stmt.setBytes(2, hash(password, salt));
            stmt.setBytes(3, salt);
            stmt.execute();
        }
    }
    
    private static void selectAllUsers(Connection conn) throws SQLException {
        try (Statement stmt = conn.createStatement()) {
            ResultSet rs = stmt.executeQuery("SELECT * FROM user");
            while (rs.next()) {
                int id = rs.getInt("Id");
                String username = rs.getString("Username");
                byte[] salt = rs.getBytes("Salt");
                System.out.println(id + " " + username + " " + new String(salt));
            }
        }
    }

    private static boolean exists(Connection conn, String username, char[] password) throws SQLException, NoSuchAlgorithmException, InvalidKeySpecException {
        try (PreparedStatement stmt = conn.prepareStatement("SELECT Salt FROM user WHERE Username = ?")) {
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            rs.next();
            byte[] salt = rs.getBytes(1);
            try (PreparedStatement stmt2 = conn.prepareStatement("SELECT Id FROM user WHERE Username = ? AND Password = ?")) {
                stmt2.setString(1, username);
                stmt2.setBytes(2, hash(password, salt));
                return stmt2.executeQuery().next();
            }
        }
    }

    private static byte[] hash(char[] password, byte[] salt) throws InvalidKeySpecException, NoSuchAlgorithmException {
        KeySpec spec = new PBEKeySpec(password, salt, 65536, 128);
        SecretKeyFactory f = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
        return f.generateSecret(spec).getEncoded();
    }
    
    private static void forgetPassword(char[] password) {
        Arrays.fill(password, '0'); // we won't store the password in the memory, let's mess it up
    }

}
