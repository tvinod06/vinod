package com.dto;

import java.util.Date;
import java.util.List;

public class ReportFormBean {
	
	private Long stockOutAmount;
	private Date todayDate;
	private String customerName;
	private Long stockInAmount;
	private Long expenditureAmount;
	private Long liveRate;
	private Long finalStockInAmount;
	private Long finalStockOutAmount;
	private Long finalInvestmentAmount;
	private List<ReportFormBean> reportFormBeanList;
	private Long retailAmount;
	private Long finalRetailAmount;
	
	
	public Long getRetailAmount() {
		return retailAmount;
	}
	public void setRetailAmount(Long retailAmount) {
		this.retailAmount = retailAmount;
	}
	public Long getFinalRetailAmount() {
		return finalRetailAmount;
	}
	public void setFinalRetailAmount(Long finalRetailAmount) {
		this.finalRetailAmount = finalRetailAmount;
	}
	public Long getFinalStockInAmount() {
		return finalStockInAmount;
	}
	public void setFinalStockInAmount(Long finalStockInAmount) {
		this.finalStockInAmount = finalStockInAmount;
	}
	public Long getFinalStockOutAmount() {
		return finalStockOutAmount;
	}
	public void setFinalStockOutAmount(Long finalStockOutAmount) {
		this.finalStockOutAmount = finalStockOutAmount;
	}
	public Long getFinalInvestmentAmount() {
		return finalInvestmentAmount;
	}
	public void setFinalInvestmentAmount(Long finalInvestmentAmount) {
		this.finalInvestmentAmount = finalInvestmentAmount;
	}
	public List<ReportFormBean> getReportFormBeanList() {
		return reportFormBeanList;
	}
	public void setReportFormBeanList(List<ReportFormBean> reportFormBeanList) {
		this.reportFormBeanList = reportFormBeanList;
	}
	public Long getLiveRate() {
		return liveRate;
	}
	public void setLiveRate(Long liveRate) {
		this.liveRate = liveRate;
	}
	public Long getStockOutAmount() {
		return stockOutAmount;
	}
	public void setStockOutAmount(Long stockOutAmount) {
		this.stockOutAmount = stockOutAmount;
	}
	public Date getTodayDate() {
		return todayDate;
	}
	public void setTodayDate(Date todayDate) {
		this.todayDate = todayDate;
	}
	public String getCustomerName() {
		return customerName;
	}
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	public Long getStockInAmount() {
		return stockInAmount;
	}
	public void setStockInAmount(Long stockInAmount) {
		this.stockInAmount = stockInAmount;
	}
	public Long getExpenditureAmount() {
		return expenditureAmount;
	}
	public void setExpenditureAmount(Long expenditureAmount) {
		this.expenditureAmount = expenditureAmount;
	}

	
}
