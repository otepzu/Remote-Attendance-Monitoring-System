package com.rams.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class GenericController {
	public static String encryption(String str) {
		MessageDigest m;
		try {
			m = MessageDigest.getInstance("MD5");
			m.update(str.getBytes());
			byte[] bytes = m.digest();
			StringBuilder s = new StringBuilder();
			for(int i = 0; i < bytes.length; i++) {
				s.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			}
			str = s.toString();
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}		
		
		return str;
	}
}
