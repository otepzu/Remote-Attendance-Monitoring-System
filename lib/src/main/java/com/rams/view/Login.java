package com.rams.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import com.rams.controller.AdminAccount;
import com.rams.controller.TestCRUD;
import com.rams.model.AdminObject;
import com.rams.model.TestObject;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import javax.swing.JLabel;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Login extends JFrame {
	/* Required every startup
	 * Login without registration
	 * Pre-created Admin Account
	 */

	private JPanel contentPane;
	private JTextField inpAdminUsername;
	private JPasswordField inpAdminPassword;
	private JLabel lblPage;

	/**
	 * Create the frame.
	 */
	public Login() {
		// Initialize Database
		AdminObject dbAO = AdminAccount.retrieveAdminUser();		
		
		// Layout
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 66, 86, 14);
		contentPane.add(lblUsername);
		
		inpAdminUsername = new JTextField();
		inpAdminUsername.setBounds(10, 91, 86, 20);
		contentPane.add(inpAdminUsername);
		inpAdminUsername.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 122, 86, 14);
		contentPane.add(lblPassword);
		
		inpAdminPassword = new JPasswordField();
		inpAdminPassword.setText("");
		inpAdminPassword.setBounds(10, 147, 86, 20);
		contentPane.add(inpAdminPassword);
		
		JButton btnAdminLogin = new JButton("Login");
		btnAdminLogin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Assign User Input to AdminObject
				String pass = "";
				char cPass[] = inpAdminPassword.getPassword();
				for(int i = 0; i < cPass.length; i++) {
					pass += cPass[i];
				}
				AdminObject ao = new AdminObject(
						inpAdminUsername.getText().toString(),
						AdminAccount.encryption(pass));
				
				// Verify Username and Password
				if(dbAO.getUsername().equals(AdminAccount.encryption(ao.getUsername()))) {
					if(dbAO.getPassword().equals(ao.getPassword())) {
						// Navigate to Admin Dashboard
						EventQueue.invokeLater(new Runnable() {
							public void run() {
								try {
									Dashboard frame = new Dashboard(ao);
									frame.setVisible(true);
									dispose();
								} catch (Exception e) {
									e.printStackTrace();
								}
							}
						});
					}
				}
			}
		});
		btnAdminLogin.setBounds(10, 196, 86, 23);
		contentPane.add(btnAdminLogin);
		
		lblPage = new JLabel("Login Page");
		lblPage.setBounds(10, 11, 86, 14);
		contentPane.add(lblPage);
	}
}
