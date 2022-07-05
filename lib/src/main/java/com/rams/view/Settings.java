package com.rams.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JTextField;

public class Settings extends JFrame {

	private JPanel contentPane;
	private JTextField inpPass;
	private JTextField inpNewPass;
	private JTextField inpConfirmPass;
	private JTextField noInpUsername;
	private JTextField inpNewUsername;

	/**
	 * Create the frame.
	 */
	public Settings() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setLocationRelativeTo(null);
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblPage = new JLabel("Settings");
		lblPage.setBounds(10, 11, 135, 14);
		getContentPane().add(lblPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Dashboard frame = new Dashboard();
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
		
		inpPass = new JTextField();
		inpPass.setBounds(10, 201, 188, 20);
		contentPane.add(inpPass);
		inpPass.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 176, 188, 14);
		contentPane.add(lblPassword);
		
		JLabel lblNewPass = new JLabel("New Password");
		lblNewPass.setBounds(10, 232, 188, 14);
		contentPane.add(lblNewPass);
		
		inpNewPass = new JTextField();
		inpNewPass.setColumns(10);
		inpNewPass.setBounds(10, 257, 188, 20);
		contentPane.add(inpNewPass);
		
		JLabel lblConfirmPass = new JLabel("Password");
		lblConfirmPass.setBounds(10, 288, 188, 14);
		contentPane.add(lblConfirmPass);
		
		inpConfirmPass = new JTextField();
		inpConfirmPass.setColumns(10);
		inpConfirmPass.setBounds(10, 313, 188, 20);
		contentPane.add(inpConfirmPass);
		
		JLabel lblUsername = new JLabel("Username");
		lblUsername.setBounds(10, 52, 188, 14);
		contentPane.add(lblUsername);
		
		noInpUsername = new JTextField();
		noInpUsername.setText("Username Here");
		noInpUsername.setColumns(10);
		noInpUsername.setBounds(10, 77, 188, 20);
		contentPane.add(noInpUsername);
		
		JLabel lblNewUsername = new JLabel("New Username");
		lblNewUsername.setBounds(10, 108, 188, 14);
		contentPane.add(lblNewUsername);
		
		inpNewUsername = new JTextField();
		inpNewUsername.setColumns(10);
		inpNewUsername.setBounds(10, 133, 188, 20);
		contentPane.add(inpNewUsername);
		
		JButton btnLogout = new JButton("Logout");
		btnLogout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Login frame = new Login();
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnLogout.setBounds(10, 359, 114, 23);
		contentPane.add(btnLogout);
	}

}
