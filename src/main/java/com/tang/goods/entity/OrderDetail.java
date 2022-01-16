package com.tang.goods.entity;

/*
 *文件名: OrderDetail
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 12:38
 *描述: 订单详情
 */
public class OrderDetail {
    public String no;
    public String oNo;
    public String gNo;
    public int n;
    public double amount;
    public double price;

    @Override
    public String toString() {
        return "OrderDetail{" +
                "no='" + no + '\'' +
                ", oNo='" + oNo + '\'' +
                ", gNo='" + gNo + '\'' +
                ", n=" + n +
                ", amount=" + amount +
                ", price=" + price +
                '}';
    }
}
