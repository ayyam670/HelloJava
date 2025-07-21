package com.yedam.app;

import java.sql.Connection;
import java.sql.DriverManager;
// ojdbc11.jar   외부 라이브러리 추가.

public class DBUtil {
	//DB 접속정보 활용 -> 세션(Connection객체)
	public static Connection getConnect()
	{
		Connection conn = null;
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "scott", "tiger");
			
		} catch (Exception e) {
			// TODO 자동 생성된 catch 블록
			e.printStackTrace();
		}
		return conn;
	}
}//end class
