package com.Control;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.Dao.DepartmentDAO;
import com.Dao.EmployeeDAO;
import com.Factory.HibernateSessionFactory;
import com.Model.Department;
import com.Model.Employee;

public class DepartmentControl {
	private static DepartmentControl control = null; 
	public static DepartmentControl getDepartmentControl(){
		if(null==control){
			control = new DepartmentControl();
		}
		return control;
	}
	
	/* AdminDAO
	 * AdminlevelDAO
	 * HibernateSession
	 */
	private DepartmentDAO DepartmentDao = null;
	private Session session = null;
	private DepartmentControl(){
		DepartmentDao = new DepartmentDAO();
		session = HibernateSessionFactory.getSession();
	}
	
	/* �෽��
	 *
	 */
	public void saveDepartment(Integer departmentId, String departmentTitle,
			String location/*, Set employees*/){/*
		Transaction transaction = session.beginTransaction();
		DepartmentDAO dao = new DepartmentDAO();
		Department admin = dao.findById(department_id);
		transaction.commit();*/
		
		Department emp = new Department(departmentId,departmentTitle,location);
		Transaction transaction = session.beginTransaction();
		DepartmentDao.save(emp);
		transaction.commit();
		//Hibernate�л����û���ԭ�����޸����ݿ�Ĳ�����������ִ�У�����ÿ��X���ӻ�ÿ����X����ִ�в���ʱִ��һ��
		//��������Ҫ�����鿴���ݿ����У�ԣ��������õ������ݿ�������ʵ������ʹ��flush���ˢ��
		session.flush();
	}
	
	public Department select(Integer i){
		Transaction transaction = session.beginTransaction();
		Department admin = DepartmentDao.findById(i);
		transaction.commit();
		return admin;
	}
}
