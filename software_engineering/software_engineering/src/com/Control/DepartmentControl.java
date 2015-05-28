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
	
	/* 类方法
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
		//Hibernate中会启用缓存原理，即修改数据库的操作不会立即执行，而是每过X分钟或每存在X条待执行操作时执行一次
		//所以若需要立即查看数据库进行校对，或下文用到了数据库操作后的实例，则使用flush语句刷新
		session.flush();
	}
	
	public Department select(Integer i){
		Transaction transaction = session.beginTransaction();
		Department admin = DepartmentDao.findById(i);
		transaction.commit();
		return admin;
	}
}
