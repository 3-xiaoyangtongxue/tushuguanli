package com.java1234.dao;

import com.java1234.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class Userdao {
    /*登录验证*/
    public User login(Connection con,User user)throws Exception{
        User resultUser=null;
        String sql = "select * from t_user where userName=? and password =?";
        PreparedStatement pstmt=con.prepareStatement(sql);
        pstmt.setString(1,user.getUserName());
        pstmt.setString(2,user.getPassword());
        ResultSet rs=pstmt.executeQuery();
        if(rs.next()){
            resultUser=new User();
            resultUser.setId(rs.getInt("id"));
            resultUser.setUserName(rs.getString("userName"));
            resultUser.setPassword(rs.getString("password"));
        }
        return resultUser;
    }
}
