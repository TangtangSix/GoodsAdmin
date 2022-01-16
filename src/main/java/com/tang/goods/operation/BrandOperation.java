package com.tang.goods.operation;

/*
 *文件名: BrandOperation
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 16:10
 *描述: 这是一个示例
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tang.goods.entity.Brand;

public class BrandOperation {
    public static List<Brand> getBrands(){
        List<Brand> results = new ArrayList<Brand>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 品牌";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();

                while(res.next()) {
                    Brand b=new Brand();
                    b.name=res.getString(1);
                    b.url=res.getString(2);
                    results.add(b);
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

    public static Brand getBrandByName(String name) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 品牌 where 品牌名称='"+name+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Brand b=new Brand();
                    b.name=res.getString(1);
                    b.url=res.getString(2);
                    return b;
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

    public static boolean addBrand(Brand b) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 品牌 values(?,?,?)";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, b.name);
                pst.setString(2, b.url);
                pst.setString(3, null);
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

    public static boolean deleteBrand(String name) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "delete from 品牌 where 品牌名称="+name;
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                int i = pst.executeUpdate();
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

    public static boolean updateBrand(Brand b) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "update 品牌 "
                    + "set "+
                    "品牌网站='"+b.url+"' "+
                    " where 品牌名称='"+b.name+"'";
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

    public static List<Brand> searchBrandBykey(String key){
        Connection conn = DataBaseLink.getConn();
        List<Brand> results=new ArrayList<Brand>();
        if (conn != null) {
            String sql = "select *from 品牌 where "+
                    "品牌名称 like '%"+key+"%' "+
                    "or 品牌网站 like '%"+key+"%' ";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Brand g=new Brand();
                    g.name=res.getString(1);
                    g.url=res.getString(2);
                    results.add(g);
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
}
