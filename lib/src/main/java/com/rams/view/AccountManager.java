package com.rams.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rams.model.AdminObject;

import javax.swing.JLabel;
import javax.swing.JButton;

public class AccountManager extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public AccountManager(AdminObject dbAO) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		
		JLabel lblPage = new JLabel("Account Manager");
		lblPage.setBounds(10, 11, 135, 14);
		getContentPane().add(lblPage);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Dashboard frame = new Dashboard(dbAO);
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
		
		JLabel DeleteMeLater = new JLabel("Table Here");
		DeleteMeLater.setBounds(10, 36, 135, 14);
		getContentPane().add(DeleteMeLater);
		
		JButton btnEditAccount = new JButton("Edit");
		btnEditAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							EditAccount frame = new EditAccount(dbAO);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnEditAccount.setBounds(10, 61, 89, 23);
		getContentPane().add(btnEditAccount);
		
		JButton btnAddAccount = new JButton("Add");
		btnAddAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddAccount frame = new AddAccount(dbAO);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAddAccount.setBounds(10, 95, 89, 23);
		getContentPane().add(btnAddAccount);
		contentPane.setLayout(null);
	}

}
