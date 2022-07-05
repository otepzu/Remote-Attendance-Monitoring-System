 package com.rams.controller;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import com.google.auth.oauth2.GoogleCredentials;
import com.google.firebase.FirebaseApp;
import com.google.firebase.FirebaseOptions;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

public class FirebaseConfig {
	public static void initFirebase() {
		FileInputStream serviceAccount = null;
	    try {
	        serviceAccount = new FileInputStream("serviceAccountKey.json");
	    } catch (FileNotFoundException e1) {
	        // TODO Auto-generated catch block
	        e1.printStackTrace();
	    }
	
	    FirebaseOptions options = null;
	    try {
	        options = new FirebaseOptions.Builder()
	          .setCredentials(GoogleCredentials.fromStream(serviceAccount))
	          .setDatabaseUrl("https://soft-eng-2-rams-default-rtdb.firebaseio.com/")
	          .build();
	    } catch (IOException e2) {
	        // TODO Auto-generated catch block
	        e2.printStackTrace();
	    }
	
	    FirebaseApp.initializeApp(options);
	
	    FirebaseDatabase db = FirebaseDatabase.getInstance();
	    DatabaseReference ref = db.getReference();
	}
}