package com.rams.view;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.rams.model.AdminObject;

public class Export extends JFrame {

	private JPanel contentPane;

	/**
	 * Create the frame.
	 */
	public Export(AdminObject dbAO) {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 800, 500);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setLocationRelativeTo(null);
		getContentPane().setLayout(null);
		contentPane.setLayout(null);
		
		JLabel lblPage = new JLabel("Export");
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
		contentPane.setLayout(null);
	}

}
