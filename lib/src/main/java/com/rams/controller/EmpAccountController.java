package com.rams.controller;

import java.util.ArrayList;

import com.google.api.services.storage.Storage.BucketAccessControls.List;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.rams.model.EmployeeObject;

public class EmpAccountController {
	public static void addAccount(EmployeeObject eo) {
		String defLoc = "JX8X+RF Manila, Metro Manila"; // Default Site - Main Office - Plus Code (Unique)
		
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref;
		
		ref = db.getReference("Employee").child(eo.getEmployeeId().toString());
		ref.child("FirstName").setValue(eo.getFirstName().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
		ref.child("MiddleName").setValue(eo.getMiddleName().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
		ref.child("LastName").setValue(eo.getLastName().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
		ref.child("Username").setValue(eo.getUsername().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
		ref.child("Password").setValue(eo.getPassword().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
		ref.child("DefaultLocation").setValue(eo.getDefaultLocation().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
		ref.child("AssignedLocation").setValue(eo.getAssignedLocation().toString(), new DatabaseReference.CompletionListener() {
			@Override
			public void onComplete(DatabaseError error, DatabaseReference ref) {
				// TODO Auto-generated method stub
			}
		});
	}
	
	public static ArrayList<String> retrieveAccountList() {
		ArrayList<String> empAcc = new ArrayList<String>();
		
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref = db.getReference();
		
		ref.child("Employee").addValueEventListener(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for(DataSnapshot snapshot: dataSnapshot.getChildren()) {					
					empAcc.add(snapshot.getKey().toString()); // Employee ID
					empAcc.add(snapshot.child("Username").getValue().toString());
					empAcc.add(snapshot.child("FirstName").getValue().toString());
					empAcc.add(snapshot.child("MiddleName").getValue().toString());
					empAcc.add(snapshot.child("LastName").getValue().toString());
					empAcc.add(snapshot.child("DefaultLocation").getValue().toString());
					empAcc.add(snapshot.child("AssignedLocation").getValue().toString());
				}
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
				
			}
		});
		
		// Delay
		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return empAcc;
	}
}