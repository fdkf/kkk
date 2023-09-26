package servlet;

import SDao.SDao;
import com.mchange.lang.PotentiallySecondaryError;
import dao.ScDao;
import dao.ScDaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;import SDao.SDaoImpl;
import pojo.Users;


@WebServlet("/Showusername")
public class Showusername extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        response.setCharacterEncoding("utf-8");
        SDao sDao = new SDaoImpl();
        String flag = request.getParameter("f");
        System.out.println("flag"+flag);
        String username = request.getParameter("username");
        String password =request.getParameter("password");
        System.out.println("2."+password);//获取到了
        Users u = sDao.login(username,password);
        if (u != null) {//登录成功
            System.out.println("登陆成功");
            if ("true".equals(flag)) {//如果勾选
                //把用户名和密码存入cookie中
                System.out.println("勾选了");
                Cookie cookie = new Cookie("username", username);
                //7天
                cookie.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie);//保存到客户端
                Cookie cookie2 = new Cookie("password", password);
                //7天
                cookie2.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie2);//保存到客户端
                //保存flag  选中状态
                Cookie cookie3 = new Cookie("flag", flag);
                cookie3.setMaxAge(60 * 60 * 24 * 7);
                response.addCookie(cookie3);
            }request.getSession().setAttribute("u",u);
            response.sendRedirect(request.getContextPath() + "/Shangpin");
        } else {
            request.setAttribute("message","<font color='red'>用户名或者密码错误！</font>");
            request.getRequestDispatcher("/sign.jsp").forward(request,response);
            }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doPost(request,response);


}}
