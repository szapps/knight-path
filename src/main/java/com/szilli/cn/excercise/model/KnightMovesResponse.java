/**********************************************************************************
 * KnightMovesResponse.java
 *
 * @author Shrinivas Zilli (szilli@bekast.de)
 * Created on Mar 28, 2018
 *
 * Copyright (c) 2018 Bekast IT Consulting GmbH, All rights reserved.
 **********************************************************************************/
package com.szilli.cn.excercise.model;

/**
 * The Class KnightMovesResponse.
 */
public class KnightMovesResponse {

	/** The white knight path. */
	private String whiteKnightPath;

	/** The black knight path. */
	private String blackKnightPath;

	private String status;

	/**
	 * Instantiates a new knight path.
	 */
	public KnightMovesResponse() {
	}

	/**
	 * Gets the white knight path.
	 *
	 * @return the white knight path
	 */
	public String getWhiteKnightPath() {
		return whiteKnightPath;
	}

	/**
	 * Sets the white knight path.
	 *
	 * @param whiteKnightPath
	 *            the new white knight path
	 */
	public void setWhiteKnightPath(String whiteKnightPath) {
		this.whiteKnightPath = whiteKnightPath;
	}

	/**
	 * Gets the black knight path.
	 *
	 * @return the black knight path
	 */
	public String getBlackKnightPath() {
		return blackKnightPath;
	}

	/**
	 * Sets the black knight path.
	 *
	 * @param blackKnightPath
	 *            the new black knight path
	 */
	public void setBlackKnightPath(String blackKnightPath) {
		this.blackKnightPath = blackKnightPath;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

}
