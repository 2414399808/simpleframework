package com.zsh;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/hello")
@Slf4j
public class HelloServlet extends HttpServlet {

    @Override
    public void init() throws ServletException {
        System.out.println("初始化Servlet容器...");
    }

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("我执行了doget方法");
        doGet(req,resp);
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String name="我的简易框架";
        log.debug("name is"+name);
        req.setAttribute("name",name);
        req.getRequestDispatcher("/WEB-INF/jsp/hello.jsp").forward(req,resp);
//        super.doGet(req, resp);
    }

//    @Override
//    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("post");
//        super.doPost(req, resp);
//    }

    @Override
    public void destroy() {
        System.out.println("destory");
    }
}
