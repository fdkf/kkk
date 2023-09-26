package pojo;

import java.util.List;

public class PageUtils<T> {
    private Integer pageNo;//当前页数
    private Integer pageSize;//每页大小
    private Integer total;//总记录数  查询的  count(*)
    private Integer pages;//总页数
    //每页的数据
    private List<T> list;

    //构造方法  给pages赋值
    public PageUtils(Integer pageNo, Integer pageSize, Integer total, List<T> list) {
        this.pageNo = pageNo;
        this.pageSize = pageSize;
        this.total = total;
        this.list = list;
        if (total % pageSize == 0) {//计算总页数pages的值
            this.pages = total / pageSize;
        } else {
            this.pages = total / pageSize + 1;
        }
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getPages() {
        return pages;
    }


    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

}
