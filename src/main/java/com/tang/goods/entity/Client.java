package com.tang.goods.entity;

/*
 *文件名: Client
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/13 12:34
 *描述: 这是一个示例
 */
public class Client {
    public String no;
    public String name;
    public String address;
    public String tNumber;
    public String password;
    public String root;

    public String getNo() {
        return no;
    }

    public void setNo(String no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String gettNumber() {
        return tNumber;
    }

    public void settNumber(String tNumber) {
        this.tNumber = tNumber;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRoot() {
        return root;
    }

    public void setRoot(String root) {
        this.root = root;
    }

    @Override
    public String toString() {
        return "Order{" +
                "no='" + no + '\'' +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", tNumber='" + tNumber + '\'' +
                ", password='" + password + '\'' +
                ", root='" + root + '\'' +
                '}';
    }
}
