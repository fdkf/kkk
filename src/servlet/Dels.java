package servlet;

import service.EmpService;
import service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.Arrays;

@WebServlet("/Dels")
public class Dels extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
               this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        EmpService empService = new EmpServiceImpl();
        String[] ids = request.getParameterValues("ids");
        try {
            int dels = empService.dels(ids);
            if (dels>0){
                request.getRequestDispatcher("/show.jsp").forward(request,response);//建议用重定向
            }else request.getRequestDispatcher("/error.jsp").forward(request,response);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
