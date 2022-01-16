package com.tang.goods.entity;

/*
 *文件名: Order
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 12:37
 *描述: 订单
 *
 */
public class Order {
    public String no;
    public String cNo;
    public String postcode;
    public String date;
    public float amount;

    @Override
    public String toString() {
        return "Order{" +
                "no='" + no + '\'' +
                ", cNo='" + cNo + '\'' +
                ", postcode='" + postcode + '\'' +
                ", date='" + date + '\'' +
                ", amount=" + amount +
                '}';
    }
}
