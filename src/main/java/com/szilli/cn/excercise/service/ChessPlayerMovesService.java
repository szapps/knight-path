/**********************************************************************************
 * ChessPlayerMovesService.java
 *
 * @author Shrinivas Zilli (szilli@bekast.de)
 * Created on Mar 28, 2018
 *
 * Copyright (c) 2018 Bekast IT Consulting GmbH, All rights reserved.
 **********************************************************************************/
package com.szilli.cn.excercise.service;

/**
 * The Interface ChessPlayerMovesService.
 */
public interface ChessPlayerMovesService {

	/**
	 * Gets the moves to opponant player's (destination) position.
	 *
	 * @return the moves to opponant player's (destination) position.
	 */
	public String getMovesToDestinationPosition();
}
