package com.Control;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.DepartmentDAO;
import com.Dao.EmployeeDAO;
import com.Factory.HibernateSessionFactory;
import com.Model.Department;
import com.Model.Employee;

public class EmployeeControl {
	private static EmployeeControl control = null; 
	public static EmployeeControl getEmployeeControl(){
		if(null==control){
			control = new EmployeeControl();
		}
		return control;
	}
	
	/* AdminDAO
	 * AdminlevelDAO
	 * HibernateSession
	 */
	private EmployeeDAO EmployeeDao = null;
	private Session session = null;
	private EmployeeControl(){
		EmployeeDao = new EmployeeDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* �෽��
	 *
	 */
	public void saveEmployee(Integer employeeId, int department_id, String email,
			String phoneNumber, String hireDate){
		Transaction transaction = session.beginTransaction();
		DepartmentDAO dao = new DepartmentDAO();
		Department admin = dao.findById(department_id);
		transaction.commit();
		
		Employee emp = new Employee(employeeId,admin,email,phoneNumber,hireDate);
		transaction = session.beginTransaction();
		EmployeeDao.save(emp);
		transaction.commit();
		//Hibernate�л����û���ԭ�����޸����ݿ�Ĳ�����������ִ�У�����ÿ��X���ӻ�ÿ����X����ִ�в���ʱִ��һ��
		//��������Ҫ�����鿴���ݿ����У�ԣ��������õ������ݿ�������ʵ������ʹ��flush���ˢ��
		session.flush();
	}
	
	public Employee select(Integer i){
		Transaction transaction = session.beginTransaction();
		Employee admin = EmployeeDao.findById(i);
		transaction.commit();
		return admin;
	}
	
	public void delete(Integer i){
		Transaction transaction = session.beginTransaction();
		Employee admin = EmployeeDao.findById(i);
		EmployeeDao.delete(admin);
		transaction.commit();
	}
}
