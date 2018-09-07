package com.qcj.servlet;

import com.qcj.dao.UserInfosDao;
import com.qcj.dao.impl.UserInfosDaoImpl;
import com.qcj.entity.UserInfos;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.List;

@WebServlet(value = "/user")
public class UserInfosServlet extends HttpServlet {
    UserInfosDao userInfosDao = new UserInfosDaoImpl();

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String method = request.getParameter("method");
        HttpSession session = request.getSession();
        System.out.println("aa"+method);
        if("login".equals(method)){
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            UserInfos users = new UserInfos(uname,password);
            List<UserInfos> list = userInfosDao.loginUser(users);
            List<UserInfos> uList = userInfosDao.selectAllUser();
            //HttpSession session = request.getSession();
            if (list.size() > 0){
                session.setAttribute("loginUName",uname);
                session.setAttribute("loginPassword",password);
                request.setAttribute("uLists",uList);
                request.getRequestDispatcher("main.jsp").forward(request,response);
            }else {
                session.setAttribute("failMsg","登录失败，重新登录");
                response.sendRedirect("login.jsp");
            }
        }else if("register".equals(method)){
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            UserInfos users = new UserInfos(uname,password);
            int result = userInfosDao.insertUser(users);
            //HttpSession session = request.getSession();
            if (result == 1){
                request.setAttribute("registerMsgT","注册成功");
                request.getRequestDispatcher("register.jsp").forward(request,response);
            }else {
                session.setAttribute("registerMsgF","注册失败，重新注册");
                response.sendRedirect("register.jsp");
            }
        }else if("toUpdate".equals(method)){
            String uid = request.getParameter("uid");
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            request.setAttribute("uid",uid);
            request.setAttribute("uname",uname);
            request.setAttribute("password",password);
            request.getRequestDispatcher("update.jsp").forward(request,response);
        }else if("update".equals(method)){
            String uid = request.getParameter("uid");
            String uname = request.getParameter("uname");
            String password = request.getParameter("password");
            UserInfos users = new UserInfos(Integer.parseInt(uid),uname,password);
            int result = userInfosDao.updateUser(users);
            System.out.println("----------------" + result + "" + uid + uname + password);
            if(1 == result){
                request.getRequestDispatcher("/user?method=login&uname=" +
                        session.getAttribute("loginUName") +"&password=" +
                        session.getAttribute("loginPassword")).forward(request,response);
            }else{
                request.setAttribute("updateMsg","修改失败");
                request.getRequestDispatcher("/user?method=update&uname=" +
                        uname +"&password=" +
                        password + "&uid=" +
                        uid).forward(request,response);
            }
        }else if("delete".equals(method)){
            String uid = request.getParameter("uid");
            int result = userInfosDao.deleteUser(Integer.parseInt(uid));
            System.out.println(result+"aaaaa:" + session.getAttribute("loginUName") + session.getAttribute("loginPassword"));
            //HttpSession session = request.getSession();
            if (result == 1){
                request.getRequestDispatcher("/user?method=login&uname=" +
                        session.getAttribute("loginUName") +"&password=" +
                        session.getAttribute("loginPassword")).forward(request,response);
            }else {
                session.setAttribute("deleteMsg","删除失败");
                request.getRequestDispatcher("/user?method=login&uname=" +
                        session.getAttribute("loginUName") +"&password=" +
                        session.getAttribute("loginPassword")).forward(request,response);
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request,response);
    }
}
