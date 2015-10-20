package com.is3;

import java.security.MessageDigest;

/** Clase encriptadora. */
public class Encrypt 
{
 
/** Recibe un string y retorna el string encriptado con SHA512.
 * @param cadena que se quiera encriptar
 * @return el string encriptado
 */
public byte[] crypt(String cadena) throws Exception {
	byte[] encryptedPassword = null;
	try 
	{
		MessageDigest md = MessageDigest.getInstance("SHA-512");
		encryptedPassword = md.digest(cadena.getBytes()); 
	} 
	catch (Exception e) 
	{
		e.printStackTrace();
		throw e;
	}
	return encryptedPassword; 
	}
}