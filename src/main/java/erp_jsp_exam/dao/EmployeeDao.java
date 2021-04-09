package erp_jsp_exam.dao;

import java.util.List;

import erp_jsp_exam.dto.Employee;

public interface EmployeeDao {
	List<Employee> selectEmployeeAll();
	Employee selectEmployeeByNo(Employee employee);
	
	int insertEmployee(Employee employee);
	int deleteEmoloyee(Employee employee);
	int updateEmployee(Employee employee);
}
