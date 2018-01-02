package com.frontend.web.model.request;

import java.io.Serializable;

public class ReqTopflag implements Serializable {

	private static final long serialVersionUID = 1L;

	/**
	 * 取值范围
	 */
	private int rows;
	
	public int getRows() {
		return rows;
	}

	public void setRows(int rows) {
		this.rows = rows;
	}


	
}
