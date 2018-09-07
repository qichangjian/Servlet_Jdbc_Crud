package com.qcj.dao;

import com.qcj.entity.UserInfos;

import java.util.List;

public interface UserInfosDao {
    //登录查询
    List<UserInfos> loginUser(UserInfos userInfos);
    //查询全部
    List<UserInfos> selectAllUser();
    //添加用户
    int insertUser(UserInfos userInfos);
    //根据id删除用户
    int deleteUser(int uid);
    //根据id修改用户
    int updateUser(UserInfos userInfos);
}
