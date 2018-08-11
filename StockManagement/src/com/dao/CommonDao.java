package com.dao;

import java.util.Date;
import java.util.List;

import com.dto.CmnLookupBean;
import com.dto.ReportFormBean;

public interface CommonDao {

	List<CmnLookupBean> getLookupNameByParentId(Long parentId) throws Exception;

	List<ReportFormBean> getAllReportDtls(Date frmDate, Date toDate) throws Exception;

	ReportFormBean getReportFooterDetails(Date frmDate, Date toDate)
			throws Exception;

	List<ReportFormBean> getRetailDtls(Date frmDate, Date toDate)
			throws Exception;


}
