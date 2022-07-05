package com.rams.controller;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rams.model.TestObject;

public class TestCRUD {
	public static void Create(TestObject to) {
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref;
		ref = db.getReference("test").child(to.getUsername().toString()).child("Password");
		ref.setValue(to.getPassword().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
	}
}