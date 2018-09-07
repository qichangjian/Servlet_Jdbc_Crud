package com.qcj.dao.impl;

import com.qcj.dao.UserInfosDao;
import com.qcj.entity.UserInfos;
import com.qcj.util.JdbcUtils;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class UserInfosDaoImpl implements UserInfosDao {
    Connection conn = null;
    PreparedStatement ps = null;
    ResultSet rs = null;

    @Override
    public List<UserInfos> loginUser(UserInfos userInfos) {
        List<UserInfos> list = new LinkedList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from userinfos where uname=? and password = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userInfos.getUname());
            ps.setString(2,userInfos.getPassword());
            rs = ps.executeQuery();
            while(rs.next()){
                UserInfos user = new UserInfos();
                user.setUname(rs.getString("uname"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeRes(conn,ps,rs);
        }
        return list;
    }

    @Override
    public List<UserInfos> selectAllUser() {
        List<UserInfos> list = new ArrayList<>();
        try {
            conn = JdbcUtils.getConnection();
            String sql = "select * from userinfos";
            ps = conn.prepareStatement(sql);
            rs = ps.executeQuery();
            while(rs.next()){
                UserInfos userInfos = new UserInfos();
                userInfos.setUid(rs.getInt("uid"));
                userInfos.setUname(rs.getString("uname"));
                userInfos.setPassword(rs.getString("password"));
                list.add(userInfos);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeRes(conn,ps,rs);
        }
        return list;
    }

    @Override
    public int insertUser(UserInfos userInfos) {
        int result = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "insert into userinfos(uname,password) values(?,?)";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userInfos.getUname());
            ps.setString(2,userInfos.getPassword());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeRes(conn,ps,null);
        }
        return result;
    }

    @Override
    public int deleteUser(int uid) {
        int result = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "delete from userinfos where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setInt(1,uid);
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeRes(conn,ps,null);
        }
        return result;
    }

    @Override
    public int updateUser(UserInfos userInfos) {
        int result = 0;
        try {
            conn = JdbcUtils.getConnection();
            String sql = "update userinfos set uname = ?,password = ? where uid = ?";
            ps = conn.prepareStatement(sql);
            ps.setString(1,userInfos.getUname());
            ps.setString(2,userInfos.getPassword());
            ps.setInt(3,userInfos.getUid());
            result = ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeRes(conn,ps,null);
        }
        return result;
    }
}
