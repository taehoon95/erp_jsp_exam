package erp_jsp_exam.util;

import java.sql.Connection;

import javax.naming.InitialContext;
import javax.sql.DataSource;

public class JdbcUtil {
	private static DataSource ds;
	
	private JdbcUtil() {}
	
	static {
		try {
			InitialContext ic = new  InitialContext(); 
			ds = (DataSource) ic.lookup("java:comp/env/jdbc/erp_jsp_exam");
			System.out.println("ds : " + ds);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static Connection getConnection() {
		try {
			return ds.getConnection();
		}catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
}
