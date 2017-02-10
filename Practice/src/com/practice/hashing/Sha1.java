package com.practice.hashing;

public class Sha1 {

	public static void main(String[] args) throws Exception { 
		String s = "devinder";
		System.out.println(s.hashCode());
		System.out.println(s.hashCode());
		System.out.println(s.hashCode());
	}

	public static byte[] encrypt(String x) throws Exception {
		java.security.MessageDigest d = null;
		d = java.security.MessageDigest.getInstance("SHA-1");
		d.reset();
		d.update(x.getBytes());
		return d.digest();
	}

}
