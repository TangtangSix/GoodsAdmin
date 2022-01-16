package com.tang.goods.entity;

/*
 *文件名: Goods
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 12:36
 *描述: 商品
 */
public class Goods {
    public String no;//编号
    public	String bname;//品牌名称
    public	String name;//名称
    public	String unit;//单位
    public	float p1;//市场价
    public	float p2;//销售价
    public	float p3;//成本价
    public	String introduction;//商品介绍
    public	int stock;//库存
    public  String sort;

    @Override
    public String toString() {
        return "Goods{" +
                "no='" + no + '\'' +
                ", bname='" + bname + '\'' +
                ", name='" + name + '\'' +
                ", unit='" + unit + '\'' +
                ", p1=" + p1 +
                ", p2=" + p2 +
                ", p3=" + p3 +
                ", introduction='" + introduction + '\'' +
                ", stock=" + stock +
                ", sort='" + sort + '\'' +
                '}';
    }
}

