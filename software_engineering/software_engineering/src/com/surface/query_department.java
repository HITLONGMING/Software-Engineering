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
import javax.swing.JTable;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.Control.DepartmentControl;
import com.Model.Department;

public class query_department extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					query_department frame = new query_department();
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
	public query_department() {
		setTitle("��ѯ������Ϣ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 371, 237);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(196, 37, 106, 21);
		contentPane.add(editorPane);
		
		table = new JTable();
		table.setModel(new DefaultTableModel(
				new Object[][] {
					{"���ź�", "��������", "����λ��"},
					{null, null, null},
				},
				new String[] {
						"���ź�", "��������", "����λ��"
				}
			) {
				Class[] columnTypes = new Class[] {
					int.class, String.class, String.class
				};
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		table.setBounds(58, 82, 248, 32);
		contentPane.add(table);
		
		JButton button = new JButton("ȡ��");
		button.setBounds(196, 144, 93, 35);
		contentPane.add(button);
		button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
				setVisible(false);
			}
		});
		
		JButton button_1 = new JButton("ȷ��");
		button_1.setBounds(58, 144, 93, 35);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag = 1;
				int ID = 0;
				if(editorPane.getText().isEmpty()){
					
					JOptionPane.showConfirmDialog(null, "�������ѯ����ID��", "��Ϣ����",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(1 == flag){
					ID = Integer.parseInt(editorPane.getText());
					Department department = DepartmentControl.getDepartmentControl().select(ID);
					if(null == department)
						JOptionPane.showConfirmDialog(null, "�ò��Ų����ڣ�", "��Ϣ����",
								JOptionPane.DEFAULT_OPTION);
					else{
						table.setModel(new DefaultTableModel(
						new Object[][] {
							{"���ź�", "��������", "����λ��"},
							{department.getDepartmentId(), department.getDepartmentTitle(), department.getLocation()},
						},
						new String[] {
								"���ź�", "��������", "����λ��"
						}
					) {
						Class[] columnTypes = new Class[] {
							int.class, String.class, String.class
						};
						public Class getColumnClass(int columnIndex) {
							return columnTypes[columnIndex];
						}
					});
				}
			}
		}
	});

		
		JLabel label = new JLabel("������Ҫ��ѯ���ŵ�ID");
		label.setBounds(58, 43, 128, 15);
		contentPane.add(label);
	}
}
