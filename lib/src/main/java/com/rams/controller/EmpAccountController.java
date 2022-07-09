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
		ref.child("FirstName").setValue(eo.getFirstName().toString(), null);
		ref.child("MiddleName").setValue(eo.getMiddleName().toString(), null);
		ref.child("LastName").setValue(eo.getLastName().toString(), null);
		ref.child("Username").setValue(eo.getUsername().toString(), null);
		ref.child("Password").setValue(eo.getPassword().toString(), null);
		ref.child("DefaultLocation").setValue(eo.getDefaultLocation().toString(), null);
		ref.child("AssignedLocation").setValue(eo.getAssignedLocation().toString(), null);
	}
	
	public static void editAccount(EmployeeObject eo, int position) {		
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref;
			
		ref = db.getReference("Employee").child(eo.getEmployeeId().toString());
		ref.child("FirstName").setValue(eo.getFirstName().toString(), null);
		ref.child("MiddleName").setValue(eo.getMiddleName().toString(), null);
		ref.child("LastName").setValue(eo.getLastName().toString(), null);
		ref.child("Username").setValue(eo.getUsername().toString(), null);
		if(!eo.getPassword().toString().isEmpty()) {
			ref.child("Password").setValue(GenericController.encryption(eo.getPassword().toString()), null);
		}
		ref.child("DefaultLocation").setValue(eo.getDefaultLocation().toString(), null);
		ref.child("AssignedLocation").setValue(eo.getAssignedLocation().toString(), null);
		
		EmployeeObject.setEmp(position, eo.getEmployeeId().toString());
		EmployeeObject.setEmp(position + 1, eo.getUsername().toString());
		EmployeeObject.setEmp(position + 2, eo.getFirstName().toString());
		EmployeeObject.setEmp(position + 3, eo.getMiddleName().toString());
		EmployeeObject.setEmp(position + 4, eo.getLastName().toString());
		EmployeeObject.setEmp(position + 5, eo.getDefaultLocation().toString());
		EmployeeObject.setEmp(position + 6, eo.getAssignedLocation().toString());
	}
	
	public static void deleteAccount(String key, int position) {
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref = db.getReference();
		
		ref.child("Employee").child(key).removeValue(null);
		EmployeeObject.deleteEmp(position);
	}
	
	public static void retrieveAccountList() {
		ArrayList<String> empAcc = new ArrayList<String>();
		
		FirebaseDatabase db = FirebaseDatabase.getInstance();
		DatabaseReference ref = db.getReference();
		
		ref.child("Employee").addListenerForSingleValueEvent(new ValueEventListener() {
			@Override
			public void onDataChange(DataSnapshot dataSnapshot) {
				for(DataSnapshot snapshot: dataSnapshot.getChildren()) {
					if(snapshot.exists()) {
						EmployeeObject.addEmp(snapshot.getKey().toString()); // Employee ID
						EmployeeObject.addEmp(snapshot.child("Username").getValue().toString());
						EmployeeObject.addEmp(snapshot.child("FirstName").getValue().toString());
						EmployeeObject.addEmp(snapshot.child("MiddleName").getValue().toString());
						EmployeeObject.addEmp(snapshot.child("LastName").getValue().toString());
						EmployeeObject.addEmp(snapshot.child("DefaultLocation").getValue().toString());
						EmployeeObject.addEmp(snapshot.child("AssignedLocation").getValue().toString());
					} else {
						ref.removeEventListener(this);
					}
				}
			}
			
			@Override
			public void onCancelled(DatabaseError error) {
				
			}
		});
	}
}