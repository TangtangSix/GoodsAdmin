package com.tang.goods.operation;

/*
 *文件名: OrderOperation
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/31 16:13
 *描述: 这是一个示例
 */

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tang.goods.entity.Order;
import com.tang.goods.entity.OrderDetail;


public class OrderOperation {
    public static List<Order> getOrders(){
        List<Order> results = new ArrayList<Order>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 订单";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();

                while(res.next()) {
                    Order o=new Order();
                    o.no=res.getString(1);
                    o.cNo=res.getString(2);
                    o.postcode=res.getString(3);
                    o.date=res.getString(4);
                    o.amount=res.getFloat(5);
                    results.add(o);
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

    public static Order getOrderByNo(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 订单 where 订单编号='"+no+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Order o=new Order();
                    o.no=res.getString(1);
                    o.cNo=res.getString(2);
                    o.postcode=res.getString(3);
                    o.date=res.getString(4);
                    o.amount=res.getFloat(5);
                    return o;
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

    public static boolean addOrder(Order o) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 订单 values(?,?,?,?,?)";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, o.no);
                pst.setString(2, o.cNo);
                pst.setString(3, o.postcode);
                pst.setString(4, o.date);
                pst.setFloat(5, o.amount);
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

    public static boolean deleteOrder(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "delete from 订单 where 订单编号='"+no+"'";
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

    public static boolean updateOrder(Order o) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "update 订单 "
                    + "set "+
                    "客户号='"+o.cNo+"', "+
                    "邮编='"+o.postcode+"', "+
                    "订购日期='"+o.date+"', "+
                    "订购金额='"+o.amount+"' "+
                    " where 订单编号='"+o.no+"'";
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

    public static List<Order> searchOrderBykey(String key){
        Connection conn = DataBaseLink.getConn();
        List<Order> results=new ArrayList<Order>();
        if (conn != null) {
            String sql = "select *from 订单 where "+
                    "订单编号 like '%"+key+"%' "+
                    "or 客户号 like '%"+key+"%' "+
                    "or 邮编 like '%"+key+"%' "+
                    "or 订购金额 like '%"+key+"%' "+
                    "or 订购时间 like '%"+key+"%' ";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    Order o=new Order();
                    o.no=res.getString(1);
                    o.cNo=res.getString(2);
                    o.postcode=res.getString(3);
                    o.date=res.getDate(4).toString()+" "+res.getTime(4).toString();
                    o.amount=res.getFloat(5);
                    results.add(o);				}
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


    public static List<OrderDetail> getOrderDetails(){
        List<OrderDetail> results = new ArrayList<OrderDetail>();
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "select *from 订单明细";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();

                while(res.next()) {
                    OrderDetail o=new OrderDetail();
                    o.no=res.getString(1);
                    o.oNo=res.getString(2);
                    o.gNo=res.getString(3);
                    o.n=res.getInt(4);
                    o.amount=res.getDouble(5);
                    o.price=res.getDouble(6);
                    results.add(o);
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

    public static List<OrderDetail> getOrderDetailByoNo(String oNo) {
        Connection conn = DataBaseLink.getConn();
        List<OrderDetail> results = new ArrayList<OrderDetail>();
        if (conn != null) {
            String sql = "select *from 订单明细 where 订单编号='"+oNo+"'";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    OrderDetail o=new OrderDetail();
                    o.no=res.getString(1);
                    o.oNo=res.getString(2);
                    o.gNo=res.getString(3);
                    o.n=res.getInt(4);
                    o.amount=res.getDouble(5);
                    o.price=res.getDouble(6);
                    results.add(o);
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

    public static boolean addOrderDetail(OrderDetail o) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "insert into 订单明细 values(?,?,?,?,?,?)";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                pst.setString(1, o.no);
                pst.setString(2, o.oNo);
                pst.setString(3, o.gNo);
                pst.setInt(4, o.n);
                pst.setDouble(5, o.amount);
                pst.setDouble(6, o.price);
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

    public static boolean deleteOrderDetail(String no) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "delete from 订单明细 where 明细编号='"+no+"'";
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

    public static boolean updateOrderDetail(OrderDetail o) {
        Connection conn = DataBaseLink.getConn();
        if (conn != null) {
            String sql = "update 订单明细 "
                    + "set "+
                    "订单编号='"+o.oNo+"', "+
                    "商品代码='"+o.gNo+"', "+
                    "数量='"+o.n+"', "+
                    "金额='"+o.amount+"' "+
                    "单价='"+o.price+"', "+
                    " where 订单编号='"+o.no+"'";
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

    public static List<OrderDetail> searchOrderDetailBykey(String key){
        Connection conn = DataBaseLink.getConn();
        List<OrderDetail> results=new ArrayList<OrderDetail>();
        if (conn != null) {
            String sql = "select *from 订单明细 where "+
                    "明细编号 like '%"+key+"%' "+
                    "or 订单编号 like '%"+key+"%' "+
                    "or 商品代码 like '%"+key+"%' "+
                    "or 数量 like '%"+key+"%' "+
                    "or 单价 like '%"+key+"%' "+
                    "or 金额 like '%"+key+"%' ";
            try {
                PreparedStatement pst = conn.prepareStatement(sql);
                ResultSet res = pst.executeQuery();
                while(res.next()) {
                    OrderDetail o=new OrderDetail();
                    o.no=res.getString(1);
                    o.oNo=res.getString(2);
                    o.gNo=res.getString(3);
                    o.n=res.getInt(4);
                    o.amount=res.getDouble(5);
                    o.price=res.getDouble(6);
                    results.add(o);}
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

