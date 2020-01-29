package util;



import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mchange.v2.c3p0.ComboPooledDataSource;


public class JDBC_util {
private static String url = "jdbc:mysql://localhost:3306/liuyanhao";
private static String user = "liuyanhao";
private static String password = "123456";
private static ComboPooledDataSource ds = null;
static {
	try {
	Class.forName("com.mysql.jdbc.Driver");
}catch(Exception e) {
	e.printStackTrace();
}
}
public static Connection getConnection() {
	if(ds==null) {
	try {
		ds = new ComboPooledDataSource();
		ds.setDriverClass("com.mysql.jdbc.Driver");
		ds.setJdbcUrl("jdbc:mysql://localhost:3306/liuyanhao");
		ds.setUser("liuyanhao");
		ds.setPassword("123456");
	    ds.setMaxPoolSize(10);
	    ds.setMinPoolSize(2);
 Connection conn = (Connection)ds.getConnection();
 return conn;
		}catch(Exception e) {
		e.printStackTrace();
	}
	} else
		try {
			return ds.getConnection();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	return null;
}
public static Connection getPoolConnection() {
	try {
		Connection conn = (Connection) DriverManager.getConnection(url, user, password);
		return conn;
		}catch(Exception e)
		{
		e.printStackTrace();
		}
	return null;
										}
public static void close(Connection conn) {
	close(conn,null,null);
}
public static void close(Connection conn,Statement st) {
close(conn,null,null);
}
public static void close(Connection conn,Statement st,ResultSet rs) {
	try {
	  if(rs!=null)
		  rs.close();
	}catch(Exception e)
	{
		e.printStackTrace();
	}
	try {
		  if(st!=null)
			  st.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
	try {
		  if(conn!=null)
			  conn.close();
		}catch(Exception e)
		{
			e.printStackTrace();
		}
}

	
}
