package SServlet;

import SDao.SDao;
import SDao.SDaoImpl;
import Spojo.Shang;
import pojo.Emp;
import pojo.PageUtils;
import pojo.StringUtils;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.util.Date;
import java.util.List;

@WebServlet("/Shangpin")
public class Shangpin extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                  request.setCharacterEncoding("utf-8");
                  SDao sDao = new SDaoImpl();
        try {//登录判断
            String tname = request.getParameter("tname");
            String date = request.getParameter("date1");
            String dat = request.getParameter("date2");
            //以下两行有问题,同一个月了
            Date date1 = StringUtils.toDate(date);
            Date date2 = StringUtils.toDate(dat);
            int pno = request.getParameter("pno")==null?1:Integer.parseInt(request.getParameter("pno"));
            int pageSize=4;
            List<Shang> all = sDao.findAll(tname, date1, date2,pno,pageSize);
//            for (int i = 0; i <all.size() ; i++) {
//                System.out.println("嘿嘿"+all.get(i).getTname());
//            }
            Shang shang = new Shang(tname, date1, date2);
            int count = sDao.getCount(shang);
            PageUtils<Shang> page=new PageUtils(pno,pageSize,count,all);//分页信息类  包含所有的信息
            request.setAttribute("page",page);
            request.setAttribute("shang",shang);
            request.setAttribute("list",all);
            request.getRequestDispatcher("/sshow.jsp").forward(request,response);//建议用重定向
        } catch (SQLException | ParseException throwables) {
            throwables.printStackTrace();
        }


    }
}
