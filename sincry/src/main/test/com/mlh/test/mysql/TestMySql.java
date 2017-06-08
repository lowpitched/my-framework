package com.mlh.test.mysql;

import org.springframework.util.Assert;

import java.sql.*;

/**
 * Created by menglihao on 2017/6/7.
 */

public class TestMySql {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		// 数据库连接url
		String url = "jdbc:mysql://localhost:3306/sincry";
		// 获取数据库连接
		Connection conn = DriverManager.getConnection(url, "root", "Justdoit3!");
		Statement stmt = conn.createStatement();
		ResultSet rs = stmt.executeQuery("select 2 from dual");
		while(rs.next()){
			int i = rs.getInt(1);
			System.out.println(i);
		}
	}

}
