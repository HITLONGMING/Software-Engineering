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

import com.Control.EmployeeControl;
import com.Model.Employee;

public class query_employee extends JFrame {

	private JPanel contentPane;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					query_employee frame = new query_employee();
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
	public query_employee() {
		setTitle("��ѯְԱ��Ϣ");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 389, 250);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		final JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(205, 30, 106, 21);
		contentPane.add(editorPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] {
				{ "ְԱID", "email", "�绰��", "��������", "���ź�" },
				{ null, null, null, null, null }, }, new String[] { "ְԱID",
				"email", "�绰��", "��������", "���ź�" }) {
			Class[] columnTypes = new Class[] { int.class, String.class,
					String.class, String.class, int.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
		table.setBounds(21, 81, 331, 32);
		contentPane.add(table);

		JButton button = new JButton("ȡ��");
		button.setBounds(205, 145, 93, 35);
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
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int flag = 1;
				int ID = 0;
				if (editorPane.getText().isEmpty()) {
					JOptionPane.showConfirmDialog(null, "�������ԃԱ����ID��", "��Ϣ����",
							JOptionPane.DEFAULT_OPTION);
					flag = 0;
					return;
				}

				if (1 == flag) {
					ID = Integer.parseInt(editorPane.getText());
					Employee emp = EmployeeControl.getEmployeeControl().select(
							ID);
					if (null == emp)
						JOptionPane.showConfirmDialog(null, "��Ա�������ڣ�", "��Ϣ����",
								JOptionPane.DEFAULT_OPTION);
					else {
						table.setModel(new DefaultTableModel(
								new Object[][] {
										{ "ְԱID", "email", "�绰��", "��������", "���ź�" },
										{
												emp.getEmployeeId(),
												emp.getEmail(),
												emp.getPhoneNumber(),
												emp.getHireDate(),
												emp.getDepartment()
														.getDepartmentId() }, },
								new String[] { "ְԱID", "email", "�绰��", "��������",
										"���ź�" }) {
							Class[] columnTypes = new Class[] { int.class,
									String.class, String.class, String.class,
									int.class };

							public Class getColumnClass(int columnIndex) {
								return columnTypes[columnIndex];
							}
						});
					}
				}
			}
		});
		button_1.setBounds(61, 145, 93, 35);
		contentPane.add(button_1);

		JLabel label = new JLabel("������Ҫ��ѯְԱ��ID");
		label.setBounds(67, 36, 128, 15);
		contentPane.add(label);

	}
}
