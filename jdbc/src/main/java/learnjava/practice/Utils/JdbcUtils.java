package learnjava.practice.Utils;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class JdbcUtils {

	private final static String DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";
	private final static String DB_CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/orcl";
	private static final String DB_USER = "StockTrading";
	private static final String DB_PASSWORD = "vponnam70";
	
	/*
	private final static String DRIVER_CLASS_NAME = "oracle.jdbc.OracleDriver";
	private final static String DB_CONNECTION_URL = "jdbc:oracle:thin:@localhost:1521/xe";
	private static final String DB_USER = "vponnam";
	private static final String DB_PASSWORD = "vponnam";
	*/
	public static Connection getConnection() throws ClassNotFoundException, SQLException {
		Class.forName(DRIVER_CLASS_NAME);
		Connection con = DriverManager.getConnection(DB_CONNECTION_URL, DB_USER, DB_PASSWORD);
		return con;
	}

	public static void closeConnection(Connection conn) {
		if (conn != null)
			try {
				conn.close();
			} catch (SQLException e) {

			}

	}
	
	public static void closeConnection(Connection conn, Statement st) {		
		if (st != null) try {	st.close(); } catch (SQLException e) {}
		if (conn != null) try {	conn.close(); } catch (SQLException e) {}
	}
	
	public static void closeConnection(Connection conn, CallableStatement cst) {		
		if (cst != null) try {	cst.close(); } catch (SQLException e) {}
		if (conn != null) try {	conn.close(); } catch (SQLException e) {}
	}
	
	public static void closeConnection(Connection conn, Statement st, ResultSet rs) {
		if (rs != null) try {	rs.close(); } catch (SQLException e) {}
		if (st != null) try {	st.close(); } catch (SQLException e) {}
		if (conn != null) try {	conn.close(); } catch (SQLException e) {}

	}

}
