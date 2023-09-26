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

@WebServlet("/DelServlet")
public class DelServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           this.doGet(request,response);
        System.out.println("过来了");
    }


    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScDao dao = new ScDaoimpl();
        int i = Integer.parseInt(request.getParameter("empno"));
        int i1 = 0;
        try {
            i1 = dao.del(i);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println("来了来了");
        if (i1==1){
            System.out.println(i);
            response.sendRedirect(request.getContextPath()+"/CServlet");
        }else {response.sendRedirect(request.getContextPath()+"/error.jsp");}
    }
}
