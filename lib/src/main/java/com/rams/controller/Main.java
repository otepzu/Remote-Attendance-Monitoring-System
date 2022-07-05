package com.rams.controller;

import java.awt.EventQueue;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.rams.view.Login;

public class Main {
	// Upon startup, the user will be redirected to "adminLogin"
	
	public static void main(String []args) {
		FirebaseConfig.initFirebase();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}