package com.rams.view;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableCellRenderer;
import javax.swing.table.TableModel;
import javax.swing.table.TableRowSorter;

import com.rams.model.AdminObject;
import com.rams.model.EmployeeObject;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.ListSelectionModel;
import javax.swing.JScrollPane;

public class AccountManager extends JFrame {

	private JPanel contentPane;
	private JTable tblEmp;
	int position = -1;
	
	/**
	 * Create the frame.
	 */
	public AccountManager(AdminObject dbAO, ArrayList<String> empList) {
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
							Dashboard frame = new Dashboard(dbAO, empList);
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
		
		JButton btnEditAccount = new JButton("Edit");
		btnEditAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				int column = 0;
				int row  = tblEmp.getSelectedRow();
				
				if(row != -1) {
					String selected = tblEmp.getModel().getValueAt(row, column).toString();
					
					String empID = "", userName = "",
							firstName = "", middleName = "", lastName = "",
							defaultLocation = "", assignedLocation = "";
					for(int i = 0; i < empList.size(); i++) {
						if(empList.get(i).equals(selected)) {
							position = i;
							empID = empList.get(i);
							userName = empList.get(i + 1);
							firstName = empList.get(i + 2);
							middleName = empList.get(i + 3);
							lastName = empList.get(i + 4);
							defaultLocation = empList.get(i + 5);
							assignedLocation = empList.get(i + 6);
						}
						i = i + 6;
					}
					
					EmployeeObject dbEO = new EmployeeObject(
							empID, firstName, middleName, lastName, userName,
							null, defaultLocation, assignedLocation);
					
					EventQueue.invokeLater(new Runnable() {
						public void run() {
							try {
								EditAccount frame = new EditAccount(dbAO, dbEO, empList, position);
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
		btnEditAccount.setBounds(10, 355, 89, 23);
		getContentPane().add(btnEditAccount);
		
		JButton btnAddAccount = new JButton("Add");
		btnAddAccount.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							AddAccount frame = new AddAccount(dbAO, empList);
							frame.setVisible(true);
							dispose();
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});
			}
		});
		btnAddAccount.setBounds(10, 389, 89, 23);
		getContentPane().add(btnAddAccount);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 36, 277, 302);
		getContentPane().add(scrollPane);
		
		int length = empList.size();
		int row = length / 7;
		int counter = 0;
		Object data[][] = new Object[row][4];
		for(int i = 0; i < row; i++) {
			String name = "";
			for(int j = 0; j < 7; j++) {
				if(j < 2) {
					data[i][j] = empList.get(counter++);
				} else if(j < 4) {
					name += empList.get(counter++);
				} else if(j == 4) {
					name += empList.get(counter++);
					data[i][2] = name;
				} else if(j == 6){
					data[i][3] = empList.get(counter++);
				} else {
					counter++;
				}
			}
		}
		
		Object header[] = {"Employe ID", "Username", "Name", "Assigned Location"};
		DefaultTableModel model = new DefaultTableModel(data, header) {
			@Override
			public Class getColumnClass(int column) {
				switch(column) {
				case 0:
					return String.class;
				case 1:
					return String.class;
				case 2:
					return String.class;
				case 3:
					return String.class;
				default:
					return String.class;
				}
			}
		};
		tblEmp = new JTable(model);
		tblEmp.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
		tblEmp.getTableHeader().setReorderingAllowed(false);
		scrollPane.setViewportView(tblEmp);
		contentPane.setLayout(null);
	}
}
