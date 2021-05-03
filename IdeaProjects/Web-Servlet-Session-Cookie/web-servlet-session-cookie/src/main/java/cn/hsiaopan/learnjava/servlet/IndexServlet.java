package cn.hsiaopan.learnjava.servlet;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(urlPatterns = "/")
public class IndexServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String user = (String) req.getSession().getAttribute("user");
        String lang = parseLanguageFromCookie(req);
        resp.setContentType("text/html");
        resp.setCharacterEncoding("UTF-8");
        PrintWriter printWriter = resp.getWriter();
        if (lang.equals("zh")) {
            printWriter.write("<h1>你好，" + (user != null ? user : "Guest") + "!</h1>");
            if (user == null) {
                printWriter.write("<p><a href=\"/signin\">登录</a></p>");
            } else {
                printWriter.write("<p><a href=\"/signout\">登出</a></p>");
            }
        } else {
            printWriter.write("<h1>Welcome, " + (user != null ? user : "Guest") + "!</h1>");
            if (user == null) {
                printWriter.write("<p><a href=\"/signin\">Sign In</a></p>");
            } else {
                printWriter.write("<p><a href=\"/signout\">Sign Out</a></p>");
            }
        }
        printWriter.write("<p><a href=\"/pref?lang=en\">English</a> | <a href=\"/pref?lang=zh\">中文</a></p>");
        printWriter.flush();
    }

    private String parseLanguageFromCookie(HttpServletRequest req) {
        Cookie[] cookies = req.getCookies();
        if (cookies != null) {
            for (Cookie cookie :
                    cookies) {
                if (cookie.getName().equals("lang")) {
                    return cookie.getValue();
                }
            }
        }
        return "en";
    }
}
