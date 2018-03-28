/**********************************************************************************
 * Knight.java
 *
 * @author Shrinivas Zilli (szilli@bekast.de)
 * Created on Mar 27, 2018
 *
 * Copyright (c) 2018 Bekast IT Consulting GmbH, All rights reserved.
 **********************************************************************************/
package com.szilli.cn.excercise.model;

import java.util.ArrayList;
import java.util.List;

/**
 * The Class Knight.
 */
public class Knight implements ChessPlayer {

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.szilli.cn.excercise.ChessPlayer#getPossibleMoves(com.szilli.cn.excercise.
	 * Position)
	 */
	public List<ChessPosition> getPossibleMoves(ChessPosition startPosition) {
		List<ChessPosition> lstValidPositions = new ArrayList<ChessPosition>();

		int[] moves = { -2, -1, 1, 2 };

		for (int xMove : moves) {
			for (int yMove : moves) {
				if (Math.abs(xMove) != Math.abs(yMove)) { // A Knight can only move 1 space in one direction and 2 in
															// the other
					if (ChessPosition.isValidPosition(startPosition.getX() + xMove, startPosition.getY() + yMove)) {
						lstValidPositions.add(
								(new ChessPosition((startPosition.getX() + xMove), (startPosition.getY() + yMove))));
					}
				}
			}
		}

		return lstValidPositions;
	}

}