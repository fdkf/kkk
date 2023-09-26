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
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/AddServlet")
public class AddServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       request.setCharacterEncoding("UTF-8");
        response.setHeader("Content-Type","text/html;charset=UTF-8");
        ScDao dao = new ScDaoimpl();
//        HttpSession session = request.getSession();
//        Integer deptno =Integer.parseInt(String.valueOf(session.getAttribute("deptno")));
//        String ename = (String) session.getAttribute("ename");
//        Integer emptno =Integer.parseInt(String.valueOf(session.getAttribute("emptno")));
        Integer emptno =Integer.parseInt(request.getParameter("emptno")) ;
        String ename = request.getParameter("ename");
        Integer deptno =Integer.parseInt(request.getParameter("deptno")) ;
        String job = request.getParameter("job");
        Integer sal =Integer.parseInt(request.getParameter("sal")) ;
        String brit = request.getParameter("brith");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-mm-dd");
        Date brith = null;
        try {
            brith = simpleDateFormat.parse(brit);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Emp e=new Emp(emptno,ename,job,brith,sal,deptno);
        int add = 0;
        try {
            add = dao.add(e);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        System.out.println(add);
        if (add==1){
            response.sendRedirect(request.getContextPath()+"/CServlet");
        }else {response.sendRedirect(request.getContextPath()+"/error.jsp");}



    }
}
