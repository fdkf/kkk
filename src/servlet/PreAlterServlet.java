package servlet;

import dao.ScDao;
import dao.ScDaoimpl;
import pojo.Emp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/PreAlterServlet")
public class PreAlterServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
              this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
           request.setCharacterEncoding("utf-8");
        int empno =Integer.parseInt( request.getParameter("empno"));
        ScDao scDaoimpl = new ScDaoimpl();
        try {
            Emp emp = scDaoimpl.findOne(empno);
            request.setAttribute("emp",emp);
            request.getRequestDispatcher("alter.jsp").forward(request,response);


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
