package com.dao;

import com.dto.WorkersFormBean;

public interface WorkersDao {

	Long saveWorkersDtls(WorkersFormBean retailBean) throws Exception;

	Long getMonthlyWorkersAmnt() throws Exception;

}
