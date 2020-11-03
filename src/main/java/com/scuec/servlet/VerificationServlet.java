package com.scuec.servlet;

import com.alibaba.fastjson.JSONObject;
import com.scuec.EmailCodeService.EmailVerficationCheckImpl;
import com.scuec.Util.JsonReader;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;


public class VerificationServlet extends javax.servlet.http.HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setCharacterEncoding("GBK");
        //获取客户端提交的信息

        JsonReader jsonReader = new JsonReader();

        String req = jsonReader.getJsonRequest(request);

        System.out.println(req);

        JSONObject jsonObject = JSONObject.parseObject(req);

        EmailVerficationCheckImpl Evci = JSONObject.toJavaObject(jsonObject,EmailVerficationCheckImpl.class);

        System.out.println(Evci.toString());

        boolean check = Evci.check();

        if (check){
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Example</title>");
            writer.println("</head>");
            writer.println("<body align='center'>");
            writer.println("<h1>200</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }else {
            PrintWriter writer = response.getWriter();
            writer.println("<html>");
            writer.println("<head>");
            writer.println("<title>Example</title>");
            writer.println("</head>");
            writer.println("<body align='center'>");
            writer.println("<h1>400</h1>");
            writer.println("</body>");
            writer.println("</html>");
        }
    }

    protected void doGet(javax.servlet.http.HttpServletRequest request, javax.servlet.http.HttpServletResponse response) throws javax.servlet.ServletException, IOException {

    }


}
