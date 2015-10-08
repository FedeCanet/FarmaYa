package com.is3;

import java.security.MessageDigest;

public class Encrypt {
 
	public byte[] crypt (String cadena) throws Exception{
		
		byte[] encryptedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-512");
			encryptedPassword = md.digest(cadena.getBytes());
		} catch (Exception e) {
			e.printStackTrace();
			throw e;
		}
		return encryptedPassword;
	}
	
}