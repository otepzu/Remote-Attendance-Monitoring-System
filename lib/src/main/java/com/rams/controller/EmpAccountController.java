package com.rams.controller;

import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rams.model.EmployeeObject;

public class EmpAccountController {	
	public static void addAccount(EmployeeObject eo) {
		String defLoc = "2156-D D. Florentino St, Sampaloc, Manila, 1008 Metro Manila"; // Default Site - Main Office
		
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
}