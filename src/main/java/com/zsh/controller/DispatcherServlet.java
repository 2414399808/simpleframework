package com.zsh.controller;

import com.zsh.controller.frontend.MainPageController;
import com.zsh.controller.frontend.superadmin.HeadLineOperationController;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/")
public class DispatcherServlet extends HttpServlet {


    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        System.out.println("requeset path id:"+req.getServletPath());
        System.out.println("request method is:"+ req.getMethod());
        if("/frontend/getmainpageinfo".equals(req.getServletPath())&&"GET".equals(req.getMethod())){
            new MainPageController().getMainPageInfo(req,resp);
        }else if("/frontend/addheadline".equals(req.getServletPath())&&"POST".equals(req.getMethod())){
            new HeadLineOperationController().addHeadLine(req,resp);
        }
    }
}
