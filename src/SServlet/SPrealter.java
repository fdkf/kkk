package SServlet;

import SDao.SDao;
import Spojo.Shang;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.util.List;

import SDao.SDaoImpl;


@WebServlet("/SPrealter")
public class SPrealter extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                      request.setCharacterEncoding("utf-8");
                          SDao sDao = new SDaoImpl();
        int tid = Integer.parseInt(request.getParameter("tid"));
        try {
            Shang shang = sDao.findOne(tid);
            request.setAttribute("shang",shang);
            request.getRequestDispatcher("/salter.jsp").forward(request,response);//建议用重定向
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }


    }
}
