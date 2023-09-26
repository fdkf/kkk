package servlet;

import dao.ScDao;
import dao.ScDaoimpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ZhuCe")
public class ZhuCeServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        this.doGet(request,response);
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("utf-8");
        ScDao scDao = new ScDaoimpl();
        int username = Integer.parseInt(request.getParameter("username"));
        int password = Integer.parseInt(request.getParameter("password"));
        System.out.println(username);
        System.out.println(password);
        int zhuce = 0;
        try {
            zhuce = scDao.zhuce(username, password);
            if (zhuce==1){
                response.sendRedirect(request.getContextPath()+"/sign.jsp");
            }else {response.sendRedirect(request.getContextPath()+"/error.jsp");}
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
