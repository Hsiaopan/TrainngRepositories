package cn.hsiaopan.learnjava;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;


import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class HelloServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException{
        // 设置响应类型
        response.setContentType("text/html");
        // 获取输出流
        PrintWriter printWriter = response.getWriter();
        // 写入响应
        printWriter.write("<h1>Hello, world!</h1>");
        // flush强制退出
        printWriter.flush();
    }
}
