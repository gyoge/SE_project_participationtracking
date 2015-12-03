package utils;

public class PasswordHandler{

	private String password;
	private String passwordDigest;
	private byte[] salt;
	private String saltDigest;
	
	public String getPasswordDigest(){
		return passwordDigest;
	}
	
	public String getSaltDigest(){
		return saltDigest;
	}
	
	private byte[] generateSalt() {
		return null;
	}

	private byte[] createPassword() {
		return null;
	}
	
	public PasswordHandler(String password){
		this.password = password;
	}
}
