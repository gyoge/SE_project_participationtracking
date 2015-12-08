package utils;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.util.Random;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHandler{

	private final static int ITERATION = 1000;
	private final static int KEYLENGTH = 64;
	private final int SALTLENGTH = 8;
	
	private String password;
	private byte[] salt;
	
	public byte[] getSalt(){
		return salt;
	}

	public byte[] getPassword() throws NoSuchAlgorithmException { // a basic password encryption algorithm. In real life it needs to be better
		PBEKeySpec keyspec = new PBEKeySpec(password.toCharArray(), salt, ITERATION, KEYLENGTH);
		return null;
	}
	
	public static boolean compare(byte[] encrpytedPw, String enteredPw, byte[] salt){
		PBEKeySpec keyspec = new PBEKeySpec(enteredPw.toCharArray(), salt, ITERATION, KEYLENGTH);
		return keyspec.getPassword().equals(encrpytedPw);
	}
	
	public PasswordHandler(String password){
		this.password = password;

		Random saltget = new SecureRandom();
		salt = new byte[SALTLENGTH];
		saltget.nextBytes(salt);
	}
}
