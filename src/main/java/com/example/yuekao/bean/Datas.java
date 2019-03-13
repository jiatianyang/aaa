package com.example.yuekao.bean;

import java.util.List;

/**
 * @Author：贾天阳
 * @E-mail： 15001194794@163.com
 * @Date：2019/3/8 10:23
 * @Description：描述信息
 */
public class Datas {
    private List<Datass> data;
    private String max_page;
    private String page;
    private String perpage;
    private String total;

    @Override
    public String toString() {
        return "Datas{" +
                "data=" + data +
                ", max_page='" + max_page + '\'' +
                ", page='" + page + '\'' +
                ", perpage='" + perpage + '\'' +
                ", total='" + total + '\'' +
                '}';
    }

    public List<Datass> getData() {
        return data;
    }

    public void setData(List<Datass> data) {
        this.data = data;
    }

    public String getMax_page() {
        return max_page;
    }

    public void setMax_page(String max_page) {
        this.max_page = max_page;
    }

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public String getPerpage() {
        return perpage;
    }

    public void setPerpage(String perpage) {
        this.perpage = perpage;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public Datas(List<Datass> data, String max_page, String page, String perpage, String total) {

        this.data = data;
        this.max_page = max_page;
        this.page = page;
        this.perpage = perpage;
        this.total = total;
    }
}
