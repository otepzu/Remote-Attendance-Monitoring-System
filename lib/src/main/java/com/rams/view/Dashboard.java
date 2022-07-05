package com.rams.view;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rams.model.AdminObject;

import javax.swing.JButton;
import javax.swing.JLabel;

import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Dashboard extends JFrame {

	private JPanel contentPane;
	
	/**
	 * Create the frame.
	 */
	public Dashboard(AdminObject dbAO) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		setLocationRelativeTo(null);
		contentPane.setLayout(null);
		
		JButton btnExport = new JButton("Export Timesheet");
		btnExport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Export frame = new Export(dbAO);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnExport.setBounds(10, 66, 159, 23);
		contentPane.add(btnExport);
		
		JButton btnAccountManager = new JButton("Employee's Account Manager");
		btnAccountManager.addMouseListener(new MouseAdapter() {
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
		btnAccountManager.setBounds(10, 100, 159, 23);
		contentPane.add(btnAccountManager);
		
		JButton btnAccountSettings = new JButton("Settings");
		btnAccountSettings.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Settings frame = new Settings(dbAO);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAccountSettings.setBounds(10, 134, 159, 23);
		contentPane.add(btnAccountSettings);
		
		JLabel DeleteMeLater = new JLabel("Table Here");
		DeleteMeLater.setBounds(10, 168, 159, 14);
		contentPane.add(DeleteMeLater);
		
		JLabel lblPage = new JLabel("Dashboard");
		lblPage.setBounds(10, 11, 159, 14);
		contentPane.add(lblPage);
	}	
}