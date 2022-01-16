package com.tang.goods.entity;

/*
 *文件名: User
 *创建者: 醉意丶千层梦
 *创建时间:2021/12/12 20:43
 *描述: 用户
 */
public class User {
    String userName;
    String password;
    String root;


    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
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
        return "User{" +
                "userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", root='" + root + '\'' +
                '}';
    }
}
