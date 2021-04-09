package erp_jsp_exam.service;

import java.util.List;

import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.util.JdbcUtil;

public class EmployeeService {
	

	private EmployeeDaoImpl dao;
	
	public EmployeeService() {
		dao = EmployeeDaoImpl.getInstance();
		dao.setCon(JdbcUtil.getConnection());		
	}
	
	public List<Employee> showEmployees(){
		return dao.selectEmployeeAll();
	}
}
