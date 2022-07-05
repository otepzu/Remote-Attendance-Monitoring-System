package com.rams.controller;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rams.model.AdminObject;

public class AdminAccount {
	public static AdminObject retrieveAdminUser() {
		AdminObject dbAO = new AdminObject(null, null);
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref = db.getReference("Admin");
		
		ref.addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot snapshot) {				
				for(DataSnapshot snap : snapshot.getChildren()) {
					if(snap.getKey().equals("Username")) {
						dbAO.setUsername(snap.getValue().toString());
					}
					if(snap.getKey().equals("Password"))
						dbAO.setPassword(snap.getValue().toString());
				}		
			}

			@Override
			public void onCancelled(DatabaseError error) {
				// TODO Auto-generated method stub
			}
		});
		
		return dbAO;
	}
	
	public static void editAdminUser(AdminObject ao) {
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref1, ref2;
		
		if(!ao.getUsername().isEmpty()) {
			ref1 = db.getReference("Admin").child("Username");
			ref1.setValue(encryption(ao.getUsername().toString()), new DatabaseReference.CompletionListener() {
				@Override
				public void onComplete(DatabaseError error, DatabaseReference ref) {
					// TODO Auto-generated method stub
				}
			});
		}
		
		if(!ao.getUsername().isEmpty()) {
			ref2 = db.getReference("Admin").child("Password");
			ref2.setValue(ao.getPassword().toString(), new DatabaseReference.CompletionListener() {
				@Override
				public void onComplete(DatabaseError error, DatabaseReference ref) {
					// TODO Auto-generated method stub
				}
			});
		}
	}
	
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
