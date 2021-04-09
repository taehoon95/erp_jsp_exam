package erp_jsp_exam.dao.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


import erp_jsp_exam.dao.EmployeeDao;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;

public class EmployeeDaoImpl implements EmployeeDao {

	private static final EmployeeDaoImpl instance = new EmployeeDaoImpl();
	
	private EmployeeDaoImpl() {}

	public static EmployeeDaoImpl getInstance() {
		return instance;
	}

	private Connection con;
	
	public void setCon(Connection con) {
		this.con = con;
	}

	private Employee getEmployee(ResultSet rs) throws SQLException {
		int empNo = rs.getInt("emp_no");
		String empName = rs.getString("emp_name");
		Title title = new Title(rs.getInt("title_No"));
		Employee manager = new Employee(rs.getInt("managerNo"));
		int salary = rs.getInt("salary");
		Department dept = new Department(rs.getInt("dept_No"));
		Date hiredate = null;
		
		try{
			title.setTitleName(rs.getString("title_Name"));
		}catch (Exception e) {}
		try{
			manager.setEmpName(rs.getString("managerName"));
		}catch (Exception e) {}
		try{
			dept.setDeptName(rs.getString("dept_Name"));
		}catch (Exception e) {}
		try{
			dept.setFloor(rs.getInt("floor"));
		}catch (Exception e) {}
		try {
			hiredate = new Timestamp(rs.getDate("hiredate").getTime());
		}catch (Exception e) {}
		
		
		return new Employee(empNo, empName, title, manager, salary, dept, hiredate);
	}
	
	@Override
	public List<Employee> selectEmployeeAll() {
		String sql = "select e.emp_no, e.emp_name,\r\n" + 
				"		t.title_No , t.title_Name,\r\n" + 
				"		m.emp_no as managerNo, m.emp_name  as managerName,\r\n" + 
				"		e.salary ,\r\n" + 
				"		d.dept_no ,d.dept_name ,d.floor ,\r\n" + 
				"		e.hiredate \r\n" + 
				"  from employee e join title t on e.TNO = t.TITLE_NO \r\n" + 
				"  left join  employee m on e.manager = m.emp_no \r\n" + 
				"  join department d on e.DNO = d.DEPT_NO ;";
		try(PreparedStatement pstmt = con.prepareStatement(sql);
				ResultSet rs = pstmt.executeQuery()){
			if(rs.next()) {
				List<Employee> list = new ArrayList<>();
				do {
					list.add(getEmployee(rs));
				}while(rs.next());
				return list;
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	

	@Override
	public Employee selectEmployeeByNo(Employee employee) {
		String sql = "select EMP_NO,EMP_NAME,TNO as title_No,"
				+ "MANAGER as managerNo ,SALARY,DNO as dept_No,"
				+ "HIREDATE from employee where EMP_NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					return getEmployee(rs);
				}
			}
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

	@Override
	public int insertEmployee(Employee employee) {
		String sql = "INSERT INTO EMPLOYEE VALUES(?, ?, ?,?, ?, ?, ?)";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			pstmt.setString(2, employee.getEmpName());
			pstmt.setInt(3, employee.getTitle().getTitleNo());
			pstmt.setInt(4, employee.getManager().getEmpNo());
			pstmt.setInt(5, employee.getSalary());
			pstmt.setInt(6, employee.getDept().getDeptNo());
			pstmt.setTimestamp(7, new Timestamp(employee.getHiredate().getTime()));
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int deleteEmoloyee(Employee employee) {
		String sql = "delete from employee where EMP_NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setInt(1, employee.getEmpNo());
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public int updateEmployee(Employee employee) {
		String sql = "update employee set EMP_NAME = ?, TNO = ?, MANAGER = ?, SALARY = ?, DNO = ?, HIREDATE = ? where  EMP_NO = ?";
		try(PreparedStatement pstmt = con.prepareStatement(sql)){
			pstmt.setString(1, employee.getEmpName());
			pstmt.setInt(2, employee.getTitle().getTitleNo());
			pstmt.setInt(3, employee.getManager().getEmpNo());
			pstmt.setInt(4, employee.getSalary());
			pstmt.setInt(5, employee.getDept().getDeptNo());
			pstmt.setTimestamp(6, new Timestamp(employee.getHiredate().getTime()));
			pstmt.setInt(7, employee.getEmpNo());
			System.out.println(pstmt);
			return pstmt.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}

}
