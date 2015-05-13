package com.student.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

import com.student.Util.LoggerManager;





public class ConnectionFactory {
	
	
	private static Connection mCon;
	private static Properties mProps;

	/**
	 * @return the props
	 */
	public static Properties getProperties()
	{
		return mProps;
	}

	/**
	 * @param props
	 *            application properties object
	 */
	public void setProperties(Properties aProps)
	{
		mProps = aProps;
	}

public static Connection getConnection()
	{
		try
		{
			Properties aProps = getProperties();
			Class.forName(aProps.getProperty("driver"));
			mCon = DriverManager.getConnection(aProps.getProperty("url"), aProps.getProperty("duser"), aProps.getProperty("dpass"));
		}
		catch (ClassNotFoundException cnfe)
		{
			LoggerManager.writeLogWarning(cnfe);
		}
		catch (SQLException se)
		{
			LoggerManager.writeLogWarning(se);
		}
		return mCon;
	}

	/*
	public static Connection getConnection()
	{
		try
		{
			Properties aProps = getProperties();
			Class.forName("oracle.jdbc.driver.OracleDriver");
			mCon = DriverManager.getConnection("jdbc:oracle:thin:@server3:1521:server3", "s88","s88");
		}
		catch (ClassNotFoundException cnfe)
		{
			LoggerManager.writeLogWarning(cnfe);
		}
		catch (SQLException se)
		{
			LoggerManager.writeLogWarning(se);
		}
		return mCon;
	}
*/

}
