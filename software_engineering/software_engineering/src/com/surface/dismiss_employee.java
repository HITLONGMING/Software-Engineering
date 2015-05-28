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

public class dismiss_employee extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					dismiss_employee frame = new dismiss_employee();
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
	public dismiss_employee() {
		setTitle("开除职员");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 397, 168);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(215, 24, 106, 21);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel = new JLabel("请输入被开除员工的ID");
		lblNewLabel.setBounds(77, 30, 128, 15);
		contentPane.add(lblNewLabel);
		
		JButton button = new JButton("取消");
		button.setBounds(239, 70, 93, 35);
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
		button_1.setBounds(68, 70, 93, 35);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag = 1;
				int ID = 0;
				if(editorPane.getText().isEmpty()){
					
					JOptionPane.showConfirmDialog(null, "请输入被开除员工的ID！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				
				
				if(1 == flag){
					ID = Integer.parseInt(editorPane.getText());
					try {
						EmployeeControl.getEmployeeControl().delete(ID);
					} catch (Exception e1) {
						// TODO Auto-generated catch block
						JOptionPane.showMessageDialog(contentPane,"不存在该用户");
					}
					setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
					setVisible(false);
				}
			}
		});
	}
}
