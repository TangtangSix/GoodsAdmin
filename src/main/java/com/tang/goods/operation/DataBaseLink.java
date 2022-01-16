package com.tang.goods.operation;

/*
 *文件名: DataBaseLink
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 15:32
 *描述: 这是一个示例
 */

import java.sql.Connection;
import java.sql.DriverManager;

public class DataBaseLink {
    static public Connection getConn() {
        String serverName="com.mysql.cj.jdbc.Driver";
        String dbURL="jdbc:mysql://localhost:3306/goods?useUnicode=true&characterEncoding=UTF-8&serverTimezone=GMT&allowMultiQueries=true";
        String userName="root";
        String userPwd="123456";
        try {
            Class.forName(serverName);
            Connection tmp = DriverManager.getConnection(dbURL, userName, userPwd);
            return tmp;
        }
        catch(Exception e) {
            System.out.println(e);
        }
        return null;
//		String driverName="com.microsoft.sqlserver.jdbc.SQLServerDriver";//SQL数据库引擎
//		String dbURL="jdbc:sqlserver://localhost:1433;DatabaseName=good";//数据源  ！！！！注意若出现加载或者连接数据库失败一般是这里出现问题
//		String Name="tang";
//		String Pwd="123456";
//		try
//		{
//			Class.forName(driverName);
//			Connection conn=DriverManager.getConnection(dbURL,Name,Pwd);
//			return conn;
//		}catch(Exception e){
//			e.printStackTrace();
//			System.out.println("连接失败");
//		}
//		return null;
    }

}

