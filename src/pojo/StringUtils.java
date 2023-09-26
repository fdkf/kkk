package pojo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringUtils {
    public static Date toDate(String sdate) throws ParseException {
        //格式化工具类
        SimpleDateFormat sf=new SimpleDateFormat("yyyy-mm-dd");
        if (sdate!=null && !"".equals(sdate)){
        Date d = sf.parse(sdate);
            return  d;
        }
        return  null;
    }
}
