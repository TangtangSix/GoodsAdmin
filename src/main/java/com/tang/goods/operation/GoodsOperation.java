package com.tang.goods.operation;

/*
 *文件名: GoodsOperation
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 16:05
 *描述: 这是一个示例
 */

import com.tang.goods.entity.Goods;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
public class GoodsOperation {
    public static List<Goods> getAllGoods() {
        List<Goods> res = new ArrayList<Goods>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select 商品.商品代码,品牌名称,商品名称,计量单位,市场价,销售价,成本价,商品介绍,库存,分类.分类名称 from 商品,分类,商品分类 where  商品.商品代码=分类.商品代码 and 分类.分类名称=商品分类.分类名称";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet results = pst.executeQuery();
                while(results.next()) {
                    Goods g=new Goods();
                    g.no=results.getString(1);
                    g.bname=results.getString(2);
                    g.name=results.getString(3);
                    g.unit=results.getString(4);
                    g.p1=results.getFloat(5);
                    g.p2=results.getFloat(6);
                    g.p3=results.getFloat(7);
                    g.introduction=results.getString(8);
                    g.stock=results.getInt(9);
                    g.sort=results.getString(10);
                    res.add(g);
                }
                pst.close();
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
            return res;
        } else {
            return null;
        }
    }

    public static List<String> getBrands(){
        List<String> results = new ArrayList<String>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 品牌";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();

                while(res.next()) {
                    results.add(res.getString(1));				}
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

    public static Goods getGoodByNo(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 商品 where 商品代码="+no;
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Goods g=new Goods();
                    g.no=res.getString(1);
                    g.bname=res.getString(2);
                    g.name=res.getString(3);
                    g.unit=res.getString(4);
                    g.p1=res.getFloat(5);
                    g.p2=res.getFloat(6);
                    g.p3=res.getFloat(7);
                    g.introduction=res.getString(9);
                    g.stock=res.getInt(10);
                    return g;
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

    public static boolean addGood(Goods g) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 商品 values(?,?,?,?,?,?,?,?,?,?)";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, g.no);
                pst.setString(2, g.bname);
                pst.setString(3, g.name);
                pst.setString(4, g.unit);
                pst.setFloat(5, g.p1);
                pst.setFloat(6, g.p2);
                pst.setFloat(7, g.p3);
                pst.setString(8, null);
                pst.setString(9, g.introduction);
                pst.setInt(10, g.stock);
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

    public static boolean deleteGoods(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "delete from 商品 where 商品代码="+no;
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

    public static boolean updateGoods(Goods g) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "update 商品 "
                    + "set "+
                    "商品代码='"+g.no+"',"+
                    "品牌名称='"+g.bname+"',"+
                    "商品名称='"+g.name+"',"+
                    "计量单位='"+g.unit+"',"+
                    "市场价='"+g.p1+"',"+
                    "销售价='"+g.p2+"',"+
                    "成本价='"+g.p3+"',"+
                    "商品介绍='"+g.introduction+"',"+
                    "库存='"+g.stock+"' "+
                    " where 商品代码="+g.no;
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

    public static List<Goods> searchGoodsBykey(String key){
        Connection conn = DataBaseLink.getConn();
        List<Goods> results=new ArrayList<Goods>();
        if (conn != null) {
            String sql = "select 商品.商品代码,品牌名称,商品名称,计量单位,市场价,销售价,成本价,商品介绍,库存,分类.分类名称 "
                    + "from 商品,分类,商品分类 "
                    + "where (商品.商品代码=分类.商品代码 "
                    + "and 分类.分类名称=商品分类.分类名称) "
                    + "and (" +
                    "商品.商品代码 like '%"+key+"%' "+
                    "or 品牌名称 like '%"+key+"%' "+
                    "or 商品名称 like '%"+key+"%' "+
                    "or 计量单位 like '%"+key+"' "+
                    "or 市场价 like '%"+key+"%' "+
                    "or 销售价 like '%"+key+"%' "+
                    "or 成本价 like '%"+key+"%' "+
                    "or 分类.分类名称 like '%"+key+"%' "+
                    "or 商品介绍 like '%"+key+"%' "+
                    "or 库存 like '%"+key+"%') ";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Goods g=new Goods();
                    g.no=res.getString(1);
                    g.bname=res.getString(2);
                    g.name=res.getString(3);
                    g.unit=res.getString(4);
                    g.p1=res.getFloat(5);
                    g.p2=res.getFloat(6);
                    g.p3=res.getFloat(7);
                    g.introduction=res.getString(8);
                    g.stock=res.getInt(9);
                    g.sort=res.getString(10);
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

    public static List<String> getSorts(){
        List<String> results = new ArrayList<String>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 商品分类";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();

                while(res.next()) {
                    results.add(res.getString(1));
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
    public static boolean addSort(String str){
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 商品分类 value('"+str+"')";
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
    public static boolean addSortAfterAddGood(String no,String str){
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 分类 value('"+no+"',"+"'"+str+"')";
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

}
