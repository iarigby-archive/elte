package model;


public class PasswordPair {

	private byte[] hashPassword;
	private byte[] salt;
	
	public PasswordPair() {
		
	}
	
	public PasswordPair(byte[] hashPassword, byte[] salt) {
		this.hashPassword = hashPassword;
		this.salt = salt;
	}
	
	public byte[] getPassword() {
		return hashPassword;
	}
	
	public byte[] getSalt() {
		return salt;
	}
}
