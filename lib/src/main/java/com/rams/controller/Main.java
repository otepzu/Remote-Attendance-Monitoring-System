package com.rams.controller;

import java.awt.EventQueue;

import com.rams.view.Login;

public class Main {
	// Upon startup, the user will be redirected to "adminLogin"
	
	public static void main(String []args) {
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