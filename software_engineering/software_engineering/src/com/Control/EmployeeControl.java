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
	
	/* 类方法
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
		//Hibernate中会启用缓存原理，即修改数据库的操作不会立即执行，而是每过X分钟或每存在X条待执行操作时执行一次
		//所以若需要立即查看数据库进行校对，或下文用到了数据库操作后的实例，则使用flush语句刷新
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
