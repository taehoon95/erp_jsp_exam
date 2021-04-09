package erp_jsp_exam.dao;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import erp_jsp_exam.database;
import erp_jsp_exam.dao.impl.EmployeeDaoImpl;
import erp_jsp_exam.dto.Department;
import erp_jsp_exam.dto.Employee;
import erp_jsp_exam.dto.Title;
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class EmployeeDaoTest {
	
	private static Connection con;
	private static EmployeeDaoImpl dao = EmployeeDaoImpl.getInstance();

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		con = database.getConnection();
		dao.setCon(con);
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		con.close();
	}

	@After
	public void tearDown() throws Exception {
		System.out.println();
	}

	@Test
	public void test01SelectEmployeeAll() {
		System.out.println("test01SelectEmployeeAll");
		List<Employee> list = dao.selectEmployeeAll();

		Assert.assertNotNull(list);
		list.parallelStream().forEach(System.out::println);
	}

	@Test
	public void test05SelectEmployeeByNo() {
		System.out.println("test05SelectEmployeeByNo");
		Employee emp = new Employee(4377);
		Employee serEmp = dao.selectEmployeeByNo(emp);
		
		Assert.assertNotNull(serEmp);
		System.out.println(serEmp);
	}

	@Test
	public void test02InsertEmployee() {
		System.out.println("test02InsertEmployee");
		
		Employee emp = new Employee(1004, "이태",new Title(2),new Employee(4377), 6000000,new Department(2), new Date());
		int res = dao.insertEmployee(emp);
		
		Assert.assertEquals(1, res);
		System.out.println(emp);
	}

	@Test
	public void test04DeleteEmoloyee() {
		System.out.println("test04DeleteEmoloyee");
		Employee emp = new Employee(1004);
		int res = dao.deleteEmoloyee(emp);
		
		Assert.assertEquals(1, res);
	}

	@Test
	public void test03UpdateEmployee() {
		System.out.println("test03UpdateEmployee");
		Employee emp = new Employee(1004, "이태훈",new Title(4), new Employee(4377), 2000000, new Department(2), new Date(2021, 3, 5));
		
		int res = dao.updateEmployee(emp);
		Assert.assertEquals(1, res);
		System.out.println(emp);
	}

}
