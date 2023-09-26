package servlet;

import dao.ScDao;
import dao.ScDaoimpl;
import pojo.Emp;
import service.EmpService;
import service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;

@WebServlet("/ShownameServlet")
public class ShownameServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
                response.setCharacterEncoding("utf-8");
        ScDao scDaoimpl = new ScDaoimpl();
        int empno = Integer.parseInt(request.getParameter("empno"));
        System.out.println("empno"+empno);
        try {
            Emp one = scDaoimpl.findOne(empno);
             if (one == null){
                 response.getWriter().write("ok");
                 System.out.println("ok了");
             }else {response.getWriter().write("no");
             }
            System.out.println("one"+one);
            System.out.println(one.getEname());


        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
          this.doPost(request,response);
    }
}
