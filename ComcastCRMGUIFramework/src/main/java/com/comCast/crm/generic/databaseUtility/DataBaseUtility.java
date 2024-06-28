package com.comCast.crm.generic.databaseUtility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.mysql.jdbc.Driver;
/**
 * @author Pratyusha
 * utility class for data base usage
 */
public class DataBaseUtility {
	
	Connection conn;
	
	/**
	 * utility method for get the connection to db based on url and passowrd,username
	 * @param url
	 * @param username
	 * @param password
	 */
	public void getDbConnection(String url,String username,String password) {
		
		try {
			
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 conn=DriverManager.getConnection(url,username,password);
			
		}catch(Exception e) {
			System.err.println(".....Failed to get Connection......");
		}
	}
	/**
	 * utility method for get the db connection 
	 */
public void getDbConnection() {
		
		try {
			
			Driver driver=new Driver();
			DriverManager.registerDriver(driver);
			 conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/project", "root", "root");
			
		}catch(Exception e) {
			System.err.println(".....Failed to get Connection......");
		}
	}
/**
 * utility method for close the db connection
 */
	public void closeDbConnection() {
		try {
			conn.close();
		}catch(Exception e) {
			System.out.println(".....Failed to close connection....");
		}
	}
	/**
	 * utility method for execute select query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public ResultSet executeSelectQuery(String query) throws SQLException {
		ResultSet resTable=null;
		try{
			Statement st=conn.createStatement();
		
		 resTable=st.executeQuery(query);
		}catch(Exception e) {
			
		}
		return resTable;
	}
	/**
	 * utility method for execute non select query
	 * @param query
	 * @return
	 * @throws SQLException
	 */
	public int executeNonSelectQuery(String query) throws SQLException {
		int result=0;
		try{
			Statement st=conn.createStatement();
		
		result= st.executeUpdate(query);
		
		}catch(Exception e) {
			
	}
		return result;

}
}
