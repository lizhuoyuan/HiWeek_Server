package com.HiWeek.net.bean;

import java.util.List;

public class CinemaResult {

    private List<CinemaData> data;

    private int page;

    private int pagesize;

    private int totalpage;

    public void setData(List<CinemaData> data) {
	this.data = data;
    }

    public List<CinemaData> getData() {
	return this.data;
    }

    public void setPage(int page) {
	this.page = page;
    }

    public int getPage() {
	return this.page;
    }

    public void setPagesize(int pagesize) {
	this.pagesize = pagesize;
    }

    public int getPagesize() {
	return this.pagesize;
    }

    public void setTotalpage(int totalpage) {
	this.totalpage = totalpage;
    }

    public int getTotalpage() {
	return this.totalpage;
    }

}
