package com.qiyachao.movie.vo;

import com.qiyachao.movie.domain.Movie;

public class MovieVo extends Movie{

	private String startDate;
	private String endDate;
	private String startlongtime;
	private String endlongtime;
	private Double startprice;
	private Double endtprice;
	
	private String orderFiled;//排序字段
	private String orderMethod;//排序方式
	public MovieVo() {
		super();
	}
	public String getStartDate() {
		return startDate;
	}
	public void setStartDate(String startDate) {
		this.startDate = startDate;
	}
	public String getEndDate() {
		return endDate;
	}
	public void setEndDate(String endDate) {
		this.endDate = endDate;
	}
	public String getStartlongtime() {
		return startlongtime;
	}
	public void setStartlongtime(String startlongtime) {
		this.startlongtime = startlongtime;
	}
	public String getEndlongtime() {
		return endlongtime;
	}
	public void setEndlongtime(String endlongtime) {
		this.endlongtime = endlongtime;
	}
	public Double getStartprice() {
		return startprice;
	}
	public void setStartprice(Double startprice) {
		this.startprice = startprice;
	}
	public Double getEndtprice() {
		return endtprice;
	}
	public void setEndtprice(Double endtprice) {
		this.endtprice = endtprice;
	}
	
	
	public String getOrderFiled() {
		return orderFiled;
	}
	public void setOrderFiled(String orderFiled) {
		this.orderFiled = orderFiled;
	}
	public String getOrderMethod() {
		return orderMethod;
	}
	public void setOrderMethod(String orderMethod) {
		this.orderMethod = orderMethod;
	}
	
	
}
