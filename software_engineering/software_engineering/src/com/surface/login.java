package com.surface;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

public class login extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
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
	public login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 255);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("用户登录");
		lblNewLabel.setFont(new Font("仿宋", Font.PLAIN, 26));
		lblNewLabel.setBounds(164, 10, 115, 56);
		contentPane.add(lblNewLabel);
		
		JLabel label = new JLabel("用户名");
		label.setBounds(134, 82, 54, 15);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("密码");
		label_1.setBounds(146, 123, 54, 15);
		contentPane.add(label_1);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(189, 117, 106, 21);
		contentPane.add(editorPane);
		
		final JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(189, 76, 106, 21);
		contentPane.add(editorPane_1);
		
		JButton button = new JButton("确定");
		button.setBounds(91, 158, 93, 35);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String usr = editorPane_1.getText();
				String psw = editorPane.getText();
				if(usr.equals("Admin") && psw.equals("123456")){
					mainsurface i = new mainsurface();
					i.setVisible(true);
					contentPane.setVisible(false);
				}
				else{
					if(usr.isEmpty())
						JOptionPane.showConfirmDialog(null, "请输入用户名！", "信息错误",
								JOptionPane.DEFAULT_OPTION);
					else if(psw.isEmpty())
						JOptionPane.showConfirmDialog(null, "请输入密码！", "信息错误",
								JOptionPane.DEFAULT_OPTION);
					else if(!usr.equals("Admin"))
						JOptionPane.showConfirmDialog(null, "该用户不存在！", "信息错误",
								JOptionPane.DEFAULT_OPTION);
					else if(!psw.equals("123456"))
						JOptionPane.showConfirmDialog(null, "密码错误！", "信息错误",
								JOptionPane.DEFAULT_OPTION);
				}
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		
		JButton button_1 = new JButton("取消");
		button_1.setBounds(262, 158, 93, 35);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
	}
}
