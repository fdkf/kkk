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
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.IOException;
import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;


@WebServlet("/AdddServlet")
@MultipartConfig
public class AdddServlet extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
       this.doGet(request,response);


    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        ScDao scDaoimpl = new ScDaoimpl();
        Integer empno =Integer.parseInt(request.getParameter("empno")) ;
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
        //获取文件
        Part file = request.getPart("file");
        String oldName = file.getSubmittedFileName();//获取初始名字
        if (file.getSize()>0){
            //随机数  数字  字母
            String  photo= UUID.randomUUID().toString()+oldName.substring(oldName.indexOf("."));
            //获取upload是远程位置
            String realPath = request.getServletContext().getRealPath("/IMG");
            System.out.println(realPath);
            file.write(realPath+"\\"+photo);
            Emp e=new Emp(empno,ename,job,brith,sal,deptno,photo);
            try {
                scDaoimpl.addEmp(e);
                response.sendRedirect(request.getContextPath()+"/CServlet");

            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }

        }

    }
}
