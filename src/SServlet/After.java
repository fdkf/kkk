package SServlet;

import SDao.SDao;

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
import java.util.Date;
import java.util.UUID;

import SDao.SDaoImpl;
import Spojo.Shang;
import pojo.StringUtils;

@MultipartConfig
@WebServlet("/After")
public class After extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
            this.doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
                request.setCharacterEncoding("utf-8");
        response.setHeader("Content-Type", "text/html;charset=UTF-8");
        SDao sDao = new SDaoImpl();
        int tid = Integer.parseInt(request.getParameter("tid"));
        String tname = request.getParameter("tname");
        String date = request.getParameter("tdate");
        Part file = request.getPart("file");
        String oldName = file.getSubmittedFileName();//获取初始名字
        if (file.getSize() > 0) {
            //随机数  数字  字母
            String timg = UUID.randomUUID().toString() + oldName.substring(oldName.indexOf("."));
            //获取upload是远程位置
            String realPath = request.getServletContext().getRealPath("/IMG");
            System.out.println(realPath);
            file.write(realPath + "\\" + timg);
            try {
                Date tdate = StringUtils.toDate(date);
                Shang shang = new Shang(tid,tname,timg,tdate);
                int alter = sDao.alter(shang);
                if (alter == 1) {
                    request.getRequestDispatcher("/Shangpin").forward(request, response);
                } else {
                    request.getRequestDispatcher("/error.jsp").forward(request, response);
                }

            } catch (SQLException | ParseException throwables) {
                throwables.printStackTrace();
            }


        }}
}
