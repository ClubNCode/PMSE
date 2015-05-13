package com.student.Factory;

import com.student.Dao.DataDao;

public class DBFactory {
	private static DataDao userDao = new DataDao();

	private DBFactory() {

	}

	public static DataDao getInstance() {
		return userDao;
	}
}
