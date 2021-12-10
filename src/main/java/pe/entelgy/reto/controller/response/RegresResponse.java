package pe.entelgy.reto.controller.response;

import java.util.ArrayList;

public class RegresResponse {

    private Integer page;
    private Integer per_page;
    private Integer total;
    private Integer total_pages;
    private ArrayList<RegresUser> data;

    public RegresResponse() {
        data = new ArrayList<>();
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPer_page() {
        return per_page;
    }

    public void setPer_page(Integer per_page) {
        this.per_page = per_page;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public Integer getTotal_pages() {
        return total_pages;
    }

    public void setTotal_pages(Integer total_pages) {
        this.total_pages = total_pages;
    }

    public ArrayList<RegresUser> getData() {
        return data;
    }

    public void setData(ArrayList<RegresUser> data) {
        this.data = data;
    }

    public RegresResponse(Integer page, Integer per_page, Integer total, Integer total_pages, ArrayList<RegresUser> data) {
        this.page = page;
        this.per_page = per_page;
        this.total = total;
        this.total_pages = total_pages;
        this.data = data;
    }
}
