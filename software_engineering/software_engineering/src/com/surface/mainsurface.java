package com.surface;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;

public class mainsurface extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainsurface frame = new mainsurface();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public mainsurface() {
		setTitle("企业管理系统");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 561, 378);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel();
		lblNewLabel_1.setIcon(new ImageIcon("123.jpg"));
		lblNewLabel_1.setBounds(35, 66, 357, 247);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("雇佣职员");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_hire_employee i = new input_hire_employee();
				i.setVisible(true);
			}
		});
		btnNewButton.setBounds(418, 66, 117, 40);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("开除职员");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dismiss_employee i = new dismiss_employee();
				i.setVisible(true);
			}
		});
		btnNewButton_1.setBounds(418, 166, 117, 40);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("查询职员信息");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query_employee i = new query_employee();
				i.setVisible(true);
			}
		});
		btnNewButton_2.setBounds(418, 216, 117, 40);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("增设部门");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				input_department i = new input_department();
				i.setVisible(true);
			}
		});
		btnNewButton_3.setBounds(418, 116, 117, 40);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("查询部门信息");
		button.addActionListener(new ActionListener(){
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				query_department i = new query_department();
				i.setVisible(true);
			}
		});
		button.setBounds(418, 266, 117, 40);
		contentPane.add(button);
		
		JLabel lblNewLabel = new JLabel("企业管理系统");
		lblNewLabel.setFont(new Font("楷体", Font.PLAIN, 22));
		lblNewLabel.setBounds(140, 10, 145, 40);
		contentPane.add(lblNewLabel);
	}
}
