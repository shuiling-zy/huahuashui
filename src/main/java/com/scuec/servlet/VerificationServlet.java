package com.scuec.servlet;

import com.scuec.EmailCodeService.EmailVerficationCheckImpl;

import java.io.IOException;


public class VerificationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {
        response.setCharacterEncoding("GBK");
        //获取客户端提交的信息
        String email = request.getParameter("email");

        String password = request.getParameter("password");

        String code = request.getParameter("code");

        EmailVerficationCheckImpl Evci = new EmailVerficationCheckImpl(email,password,code);

        boolean check = Evci.check();

        if (check){
            response.getWriter().write("注册成功.");
        }else {
            response.getWriter().write("注册失败.");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }
}
