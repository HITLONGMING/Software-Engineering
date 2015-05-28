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
		setTitle("查询部门信息");
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
					{"部门号", "部门名称", "部门位置"},
					{null, null, null},
				},
				new String[] {
						"部门号", "部门名称", "部门位置"
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
		
		JButton button = new JButton("取消");
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
		
		JButton button_1 = new JButton("确定");
		button_1.setBounds(58, 144, 93, 35);
		contentPane.add(button_1);
		button_1.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int flag = 1;
				int ID = 0;
				if(editorPane.getText().isEmpty()){
					
					JOptionPane.showConfirmDialog(null, "请输入查询部门ID！", "信息错误",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}
				if(1 == flag){
					ID = Integer.parseInt(editorPane.getText());
					Department department = DepartmentControl.getDepartmentControl().select(ID);
					if(null == department)
						JOptionPane.showConfirmDialog(null, "该部门不存在！", "信息错误",
								JOptionPane.DEFAULT_OPTION);
					else{
						table.setModel(new DefaultTableModel(
						new Object[][] {
							{"部门号", "部门名称", "部门位置"},
							{department.getDepartmentId(), department.getDepartmentTitle(), department.getLocation()},
						},
						new String[] {
								"部门号", "部门名称", "部门位置"
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

		
		JLabel label = new JLabel("请输入要查询部门的ID");
		label.setBounds(58, 43, 128, 15);
		contentPane.add(label);
	}
}
