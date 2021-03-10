package com.zarek.setting.web.controller;

import com.zarek.utils.PrintJson;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author zhao
 * @date 2021/2/27 17:59
 */
public class LoginController extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        System.out.println("进入到用户控制器");

        String path = request.getServletPath();

        if("/setting/login.do".equals(path)){
            login(request,response);
        }else if("".equals(path)){

        }
    }

    private void login(HttpServletRequest request, HttpServletResponse response)
    {
        System.out.println("进入到验证登录操作");

        boolean flag = true;

        PrintJson.printJsonFlag(response,flag);


    }
}
