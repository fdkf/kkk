package servlet;

import dao.ScDao;
import dao.ScDaoimpl;
import pojo.Dept;
import pojo.Emp;
import pojo.PageUtils;
import pojo.StringUtils;
import service.EmpService;
import service.EmpServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.List;

@WebServlet("/CServlet")
public class CServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ScDao s = new ScDaoimpl();
        EmpService empService = new EmpServiceImpl();
        String ename = request.getParameter("ename");
        String date1 = request.getParameter("date1");
        String date2 = request.getParameter("date2");
        int did =request.getParameter("did")==null?0:Integer.parseInt(request.getParameter("did"));
        int pno = request.getParameter("pno")==null?1:Integer.parseInt(request.getParameter("pno"));
        int  pageSize=5;//每页显示条数
        try {
            Emp sa=new Emp(ename,StringUtils.toDate(date1),StringUtils.toDate(date2),did);
            List<Emp> all = empService.findEmps(sa,pno,pageSize);//总记录获取
            int count = empService.getCount(sa);
            PageUtils<Emp>  page=new PageUtils(pno,pageSize,count,all);//分页信息类  包含所有的信息
            //存值
            request.setAttribute("page",page);
            request.setAttribute("sa",sa);
      List<Dept> dept = s.findDept();
      request.setAttribute("depts",dept);
      request.getRequestDispatcher("/show.jsp").forward(request,response);//建议用重定向
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }

    }
}
