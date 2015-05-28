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

import com.Control.DepartmentControl;

public class input_department extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					input_department frame = new input_department();
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
	public input_department() {
		setTitle("增设部门");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 429, 276);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(204, 47, 106, 21);
		contentPane.add(editorPane);
		
		final JEditorPane editorPane_1 = new JEditorPane();
		editorPane_1.setBounds(204, 78, 106, 21);
		contentPane.add(editorPane_1);
		
		final JEditorPane editorPane_2 = new JEditorPane();
		editorPane_2.setBounds(204, 109, 106, 21);
		contentPane.add(editorPane_2);
		
		JButton button = new JButton("取消");
		button.setBounds(248, 165, 93, 35);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		
		JButton button_1 = new JButton("确定");
		button_1.setBounds(86, 165, 93, 35);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag = 1;
				int ID = 0;
				String name = editorPane_1.getText();
				String location = editorPane_2.getText();
				
				if(editorPane.getText().isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入部门ID！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(name.isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入部门名称！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(location.isEmpty()){
					JOptionPane.showConfirmDialog(null, "请输入部门地址！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				
				if(1 == flag){
					ID = Integer.parseInt(editorPane.getText());
					DepartmentControl.getDepartmentControl().saveDepartment(ID,name,location);
					
				}
			}
		});
		
		
		JLabel lblNewLabel = new JLabel("部门编号");
		lblNewLabel.setBounds(123, 53, 54, 15);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("部门名称");
		lblNewLabel_1.setBounds(123, 84, 54, 15);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("部门位置");
		lblNewLabel_2.setBounds(123, 115, 54, 15);
		contentPane.add(lblNewLabel_2);
	}
}
