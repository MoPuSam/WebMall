package org.tysf.utils;

import java.sql.Connection;
import java.sql.SQLException;

import javax.sql.DataSource;

import com.mchange.v2.c3p0.ComboPooledDataSource;

public class JdbcUtils {
	//使用命名配置
	private static ComboPooledDataSource dataSource = new ComboPooledDataSource("tysf");
	/**
	 * 获得数据源
	 */
	public  static  DataSource getDataSource(){
		return dataSource;
	}
	/*
	 * 获得链接
	 */
	public static  Connection getConnection() throws SQLException{
		return dataSource.getConnection();
	}
}
