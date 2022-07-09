package com.rams.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import com.rams.controller.EmpAccountController;
import com.rams.controller.GenericController;
import com.rams.model.AdminObject;
import com.rams.model.EmployeeObject;

import javax.swing.JLabel;
import javax.swing.JButton;

public class EditAccount extends JFrame {

	private JPanel contentPane;
	private JTextField inpEmployeeID;
	private JTextField inpFirstName;
	private JTextField inpMiddleName;
	private JTextField inpLastName;
	private JTextField inpUsername;
	private JPasswordField inpPassword;
	private JTextField noInpDefaultLocation;
	private JTextField noInpAssignedLocation;

	/**
	 * Create the frame.
	 */
	public EditAccount(AdminObject dbAO, EmployeeObject dbEO, int position) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPage = new JLabel("Edit Account");
		lblPage.setBounds(10, 11, 135, 14);
		getContentPane().add(lblPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AccountManager frame = new AccountManager(dbAO);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnBack.setBounds(155, 7, 89, 23);
		getContentPane().add(btnBack);
		contentPane.setLayout(null);
		
		JLabel lblEmployeeID = new JLabel("Employee ID");
		lblEmployeeID.setBounds(10, 56, 135, 14);
		contentPane.add(lblEmployeeID);
		
		inpEmployeeID = new JTextField();
		inpEmployeeID.setText("Employee ID Here");
		inpEmployeeID.setBounds(10, 81, 135, 20);
		contentPane.add(inpEmployeeID);
		inpEmployeeID.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name");
		lblFirstName.setBounds(10, 112, 135, 14);
		contentPane.add(lblFirstName);
		
		inpFirstName = new JTextField();
		inpFirstName.setText("First Name Here");
		inpFirstName.setColumns(10);
		inpFirstName.setBounds(10, 137, 135, 20);
		contentPane.add(inpFirstName);
		
		JLabel lblMiddleName = new JLabel("Middle Name");
		lblMiddleName.setBounds(10, 168, 135, 14);
		contentPane.add(lblMiddleName);
		
		inpMiddleName = new JTextField();
		inpMiddleName.setText("Middle Name Here");
		inpMiddleName.setColumns(10);
		inpMiddleName.setBounds(10, 193, 135, 20);
		contentPane.add(inpMiddleName);
		
		JLabel lblLastName = new JLabel("Last Name");
		lblLastName.setBounds(10, 224, 135, 14);
		contentPane.add(lblLastName);
		
		inpLastName = new JTextField();
		inpLastName.setText("Last Here");
		inpLastName.setColumns(10);
		inpLastName.setBounds(10, 249, 135, 20);
		contentPane.add(inpLastName);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 280, 135, 14);
		contentPane.add(lblUsername);
		
		inpUsername = new JTextField();
		inpUsername.setText("Username Here");
		inpUsername.setColumns(10);
		inpUsername.setBounds(10, 305, 135, 20);
		contentPane.add(inpUsername);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 336, 135, 14);
		contentPane.add(lblPassword);
		
		inpPassword = new JPasswordField();
		inpPassword.setToolTipText("");
		inpPassword.setBounds(10, 361, 135, 20);
		contentPane.add(inpPassword);
		
		JLabel lblDefaultLocation = new JLabel("Main Office Location");
		lblDefaultLocation.setBounds(194, 56, 135, 14);
		contentPane.add(lblDefaultLocation);
		
		noInpDefaultLocation = new JTextField();
		noInpDefaultLocation.setText("Main Office Location Here");
		noInpDefaultLocation.setColumns(10);
		noInpDefaultLocation.setBounds(194, 81, 315, 20);
		contentPane.add(noInpDefaultLocation);
		
		JLabel lblAssignedLocation = new JLabel("Assigned Location");
		lblAssignedLocation.setBounds(194, 140, 135, 14);
		contentPane.add(lblAssignedLocation);
		
		noInpAssignedLocation = new JTextField();
		noInpAssignedLocation.setText("Assigned Location Here");
		noInpAssignedLocation.setColumns(10);
		noInpAssignedLocation.setBounds(194, 193, 315, 20);
		contentPane.add(noInpAssignedLocation);
		
		JLabel DeleteMeLater = new JLabel("Location Picker");
		DeleteMeLater.setBounds(194, 168, 135, 14);
		contentPane.add(DeleteMeLater);
		
		JButton btnDeleteAccount = new JButton("Delete Account");
		btnDeleteAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String key = inpEmployeeID.getText().toString();
				EmpAccountController.deleteAccount(key, position);
				
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {AccountManager frame = new AccountManager(dbAO);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnDeleteAccount.setBounds(194, 293, 156, 23);
		contentPane.add(btnDeleteAccount);
		
		JButton btnSaveEdit = new JButton("Save Edit");
		btnSaveEdit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				// Assign to EmployeeObject				
				String pass = "";
				char cPass[] = inpPassword.getPassword();
				for(int i = 0; i < cPass.length; i++) {
					pass += cPass[i];
				}
				EmployeeObject eo = new EmployeeObject(
						inpEmployeeID.getText().toString(),
						inpFirstName.getText().toString(),
						inpMiddleName.getText().toString(),
						inpLastName.getText().toString(),
						inpUsername.getText().toString(),
						pass,
						noInpDefaultLocation.getText().toString(),
						noInpAssignedLocation.getText().toString());
				
				if(!eo.getEmployeeId().toString().isEmpty() && !eo.getFirstName().toString().isEmpty() &&
						!eo.getMiddleName().toString().isEmpty() && !eo.getLastName().toString().isEmpty() &&
						!eo.getUsername().toString().isEmpty() && !eo.getDefaultLocation().toString().isEmpty()
						&& !eo.getAssignedLocation().toString().isEmpty()) {
					EmpAccountController.editAccount(eo, position);
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {AccountManager frame = new AccountManager(dbAO);
								frame.setVisible(true);
								dispose();
							} catch (Exception e) {
								e.printStackTrace();
							}
						}
					});
				}
			}
		});
		btnSaveEdit.setBounds(194, 248, 156, 23);
		contentPane.add(btnSaveEdit);
		
		// Set Selected Employee
		inpEmployeeID.setText(dbEO.getEmployeeId());
		inpUsername.setText(dbEO.getUsername());
		inpFirstName.setText(dbEO.getFirstName());
		inpMiddleName.setText(dbEO.getMiddleName());
		inpLastName.setText(dbEO.getLastName());
		noInpDefaultLocation.setText(dbEO.getDefaultLocation());
		noInpAssignedLocation.setText(dbEO.getAssignedLocation());
	}

}
