/**********************************************************************************
 * KnightMovesService.java
 *
 * @author Shrinivas Zilli (szilli@bekast.de)
 * Created on Mar 28, 2018
 *
 * Copyright (c) 2018 Bekast IT Consulting GmbH, All rights reserved.
 **********************************************************************************/
package com.szilli.cn.excercise.service;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

import com.szilli.cn.excercise.model.ChessPlayer;
import com.szilli.cn.excercise.model.ChessPosition;

/**
 * The Class KnightMovesService.
 */
public class KnightMovesService implements ChessPlayerMovesService {

	/** The start pos. */
	public ChessPosition startPos;

	/** The end pos. */
	public ChessPosition endPos;

	/** The player. */
	public ChessPlayer player;

	/**
	 * Instantiates a new knight moves service.
	 *
	 * @param start
	 *            the start
	 * @param end
	 *            the end
	 * @param player
	 *            the player
	 */
	public KnightMovesService(ChessPosition start, ChessPosition end, ChessPlayer player) {
		this.startPos = start;
		this.endPos = end;
		this.player = player;
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.szilli.cn.excercise.service.ChessPlayerMovesService#
	 * getMovesToDestinationPosition()
	 */
	@Override
	public String getMovesToDestinationPosition() {
		Map<ChessPosition, ChessPosition> parentPositions = new HashMap<ChessPosition, ChessPosition>();
		Queue<ChessPosition> positionsQueue = new LinkedList<ChessPosition>();

		parentPositions.put(startPos, null);
		positionsQueue.add(startPos);

		while (positionsQueue.peek() != null) {
			ChessPosition currentPosition = positionsQueue.poll();

			if (currentPosition.equals(endPos)) {
				break;
			}

			List<ChessPosition> nextPossibleMoves = player.getPossibleMoves(currentPosition);
			for (ChessPosition nextPosition : nextPossibleMoves) {
				if (!parentPositions.containsKey(nextPosition)) {
					parentPositions.put(nextPosition, currentPosition);
					positionsQueue.add(nextPosition);
				}
			}
		}

		ChessPosition currentPosition = endPos;
		String shortestPath = "";
		while (parentPositions.get(currentPosition) != null) {
			shortestPath = currentPosition.toString() + " " + shortestPath;
			currentPosition = parentPositions.get(currentPosition);
		}
		shortestPath = currentPosition.toString() + " " + shortestPath;
		if (shortestPath.length() == 0) {
			shortestPath = startPos.toString();
		}

		return shortestPath;
	}

}