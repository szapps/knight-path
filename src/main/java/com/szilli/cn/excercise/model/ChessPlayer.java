package com.szilli.cn.excercise.model;

import java.util.List;

public interface ChessPlayer {

	/**
	 * This method returns a list of valid position a chess player can move from
	 * given start position
	 * 
	 * @param startPosition
	 * @return
	 */
	public List<ChessPosition> getPossibleMoves(ChessPosition startPosition);

}