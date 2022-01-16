package com.tang.goods.operation;

/*
 *文件名: ClientOperation
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 15:31
 *描述: 这是一个示例
 */

import com.tang.goods.entity.Client;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class ClientOperation {
    public static List<Client> getClients(){
        List<Client> results = new ArrayList<Client>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 客户";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();

                while(res.next()) {
                    Client c=new Client();
                    c.no=res.getString(1);
                    c.name=res.getString(2);
                    c.address=res.getString(3);
                    c.tNumber=res.getString(4);
                    c.password=res.getString(5);
                    c.root=res.getString(6);
                    results.add(c);
                }
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return results;
        } else {
            return null;
        }
    }

    public static Client getClientByNo(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 客户 where 客户号='"+no+"' or 客户电话='"+no+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Client c=new Client();
                    c.no=res.getString(1);
                    c.name=res.getString(2);
                    c.address=res.getString(3);
                    c.tNumber=res.getString(4);
                    c.password=res.getString(5);
                    c.root=res.getString(6);
                    return c;
                }
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    public static boolean addClient(Client c) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 客户 values(?,?,?,?,?,?)";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, c.no);
                pst.setString(2, c.name);
                pst.setString(3, c.address);
                pst.setString(4, c.tNumber);
                pst.setString(5, c.password);
                pst.setString(6, c.root);
                int i=pst.executeUpdate();
                pst.close();
                conn.close();
                if (i >= 0) {
                    return true;
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            return false;
        }
    }

    public static boolean deleteClient(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "delete from 客户 where 客户号='"+no+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                int i = pst.executeUpdate();
                pst.close();
                conn.close();
                if (i > 0) {
                    return true;
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            return false;
        }
    }

    public static boolean updateClient(Client c) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "update 客户 "
                    + "set "+
                    "客户姓名='"+c.name+"', "+
                    "客户地址='"+c.address+"', "+
                    "客户电话='"+c.tNumber+"' "+
                    " where 客户号='"+c.no+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                int i=pst.executeUpdate();
                pst.close();
                conn.close();
                if (i >= 0) {
                    return true;
                }
                return false;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return false;
        } else {
            return false;
        }
    }

    public static List<Client> searchClientBykey(String key){
        Connection conn = DataBaseLink.getConn();
        List<Client> results=new ArrayList<Client>();
        if (conn != null) {
            String sql = "select *from 客户 where "+
                    "客户号 like '%"+key+"%' "+
                    "or 客户姓名 like '%"+key+"%' "+
                    "or 客户地址 like '%"+key+"%' "+
                    "or 客户电话 like '%"+key+"%' ";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Client c=new Client();
                    c.no=res.getString(1);
                    c.name=res.getString(2);
                    c.address=res.getString(3);
                    c.tNumber=res.getString(4);
                    c.password=res.getString(5);
                    c.root=res.getString(6);
                    results.add(c);
                }
                pst.close();
                conn.close();
                return results;
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }

    public static Client login(String name,String password) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select * from 客户 where (客户号='"+name+"' or 客户电话='"+name+"') and password='"+password+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Client c=new Client();
                    c.no=res.getString(1);
                    c.name=res.getString(2);
                    c.address=res.getString(3);
                    c.tNumber=res.getString(4);
                    c.password=res.getString(5);
                    c.root=res.getString(6);
                    return c;
                }
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return null;
        } else {
            return null;
        }
    }
}

