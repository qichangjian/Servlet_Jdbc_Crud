package com.qcj.test;

import com.qcj.dao.UserInfosDao;
import com.qcj.dao.impl.UserInfosDaoImpl;
import com.qcj.entity.UserInfos;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        UserInfos u = new UserInfos("aa","111");
        UserInfosDao userDao = new UserInfosDaoImpl();
        List<UserInfos> list = userDao.loginUser(u);
        list.forEach(System.out::println);
    }
}
