package com.surface;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import com.Control.EmployeeControl;

public class input_hire_employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					input_hire_employee frame = new input_hire_employee();
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
	public input_hire_employee() {
		setTitle("雇佣职员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 430, 350);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(184, 46, 106, 21);
		contentPane.add(editorPane);
		
		final JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(184, 77, 106, 21);
		contentPane.add(editorPane_1);
		
		final JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(184, 108, 106, 21);
		contentPane.add(editorPane_2);
		
		final JEditorPane editorPane_3 = new JEditorPane();
		editorPane_3.setBounds(184, 139, 106, 21);
		contentPane.add(editorPane_3);
		
		final JEditorPane editorPane_4 = new JEditorPane();
		editorPane_4.setBounds(184, 170, 106, 21);
		contentPane.add(editorPane_4);
		
		JButton btnNewButton = new JButton("确定");
		btnNewButton.setBounds(65, 243, 93, 35);
		contentPane.add(btnNewButton);
		btnNewButton.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag = 1;
				int employee_id = 0;
				String email = editorPane_1.getText();
				String phone_number = editorPane_2.getText();
				String hire_date = editorPane_3.getText();
				int department_id = 0;
				if(editorPane.getText().isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入员工ID！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(email.isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入e-mail！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(phone_number.isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入电话号！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(hire_date.isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入雇用日期！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(editorPane_4.getText().isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入所在部门ID！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				
				if(1 == flag){
					employee_id = Integer.parseInt(editorPane.getText());
					department_id = Integer.parseInt(editorPane_4.getText());
					EmployeeControl.getEmployeeControl().saveEmployee(employee_id,department_id,email,phone_number,hire_date);
				}
			}
		});
		JButton btnNewButton_1 = new JButton("取消");
		btnNewButton_1.setBounds(236, 243, 93, 35);
		contentPane.add(btnNewButton_1);
		btnNewButton_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		
		JLabel lblNewLabel = new JLabel("职员ID");
		lblNewLabel.setBounds(129, 52, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("email");
		lblNewLabel_1.setBounds(141, 83, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("电话号码");
		lblNewLabel_2.setBounds(120, 114, 54, 15);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("雇用日期");
		lblNewLabel_3.setBounds(120, 145, 54, 15);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("所在部门号");
		lblNewLabel_4.setBounds(106, 176, 68, 15);
		contentPane.add(lblNewLabel_4);
	}
}
