package org.ligson.classloader;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

import javax.crypto.Cipher;

public class LoaderTest {
	static KeyPair keyPair;

	static {
		try {
			keyPair = KeyPairGenerator.getInstance("RSA").generateKeyPair();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
	}

	public static void encodeClzz() {
		File file = new File("./target/classes/org/ligson/classloader/EncodeCodec.class");
		try {
			System.out.println(file.exists());
			byte[] buffer = new byte[(int) file.length()];
			FileInputStream inputStream = new FileInputStream(file);
			inputStream.read(buffer);
			inputStream.close();
			byte[] encode = RSACryptoUtils.encrypt(keyPair.getPublic(), buffer);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(encode);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	public static void decodeClzz(){
		File file = new File("./target/classes/org/ligson/classloader/EncodeCodec.class");
		try {
			System.out.println(file.exists());
			byte[] buffer = new byte[(int) file.length()];
			FileInputStream inputStream = new FileInputStream(file);
			inputStream.read(buffer);
			inputStream.close();
			byte[] encode = RSACryptoUtils.decrypt(keyPair.getPrivate(),buffer);
			FileOutputStream fos = new FileOutputStream(file);
			fos.write(encode);
			fos.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) throws Exception {
		//encodeClzz();
		MyClassLoader loader = new MyClassLoader("password");
		Thread.currentThread().setContextClassLoader(loader);
		loader.loadClass("org.ligson.classloader.EncodeCodec");
		EncodeCodec codec = new EncodeCodec();
		codec.startup();
		//decodeClzz();
		
	}
}
