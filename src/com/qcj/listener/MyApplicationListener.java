package com.qcj.listener;

import javax.servlet.ServletContext;
import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.annotation.WebListener;
import java.util.HashMap;
import java.util.Map;

@WebListener()
public class MyApplicationListener implements ServletContextListener {

    /**
     * 在服务器启动时创建Map，保存到ServletContext
     */
    public void contextInitialized(ServletContextEvent sce) {
        Map<String,Integer> map = new HashMap<>();
        //得到ServletContext
        //sce.getServletContext().setAttribute("map",map);//sce.getServletContext()获取aplication域  设置值*/
        //得到ServletContext
        ServletContext application = sce.getServletContext();
        //把map保存到application中
        application.setAttribute("map", map);
        System.out.println("application ServletContext Filter创建");
    }

    public void contextDestroyed(ServletContextEvent sce) {
        System.out.println("application销毁");
    }
}
