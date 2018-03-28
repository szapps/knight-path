/**********************************************************************************
 * ChessPosition.java
 *
 * @author Shrinivas Zilli (szilli@bekast.de)
 * Created on Mar 27, 2018
 *
 * Copyright (c) 2018 Bekast IT Consulting GmbH, All rights reserved.
 **********************************************************************************/
package com.szilli.cn.excercise.model;

/**
 * The Class ChessPosition.
 */
public class ChessPosition {

	/** The board size. */
	public static int BOARD_SIZE = 8;

	/** The x-coordinate value. */
	private int x;

	/** The y-coordinate value. */
	private int y;

	/**
	 * Instantiates a new position.
	 *
	 * @param xCoordinate
	 *            the x coordinate
	 * @param yCoordinate
	 *            the y coordinate
	 * @throws IllegalArgumentException
	 *             the illegal argument exception
	 */
	public ChessPosition(int xCoordinate, int yCoordinate) throws IllegalArgumentException {
		if (isValidPosition(xCoordinate, yCoordinate)) {
			this.x = xCoordinate;
			this.y = yCoordinate;
		} else {
			throw new IllegalArgumentException("Invalid position. Board size is: " + BOARD_SIZE + " X " + BOARD_SIZE);
		}
	}

	/**
	 * Gets the x.
	 *
	 * @return the x
	 */
	public int getX() {
		return x;
	}

	/**
	 * Sets the x.
	 *
	 * @param x
	 *            the new x
	 */
	public void setX(int x) {
		this.x = x;
	}

	/**
	 * Gets the y.
	 *
	 * @return the y
	 */
	public int getY() {
		return y;
	}

	/**
	 * Sets the y.
	 *
	 * @param y
	 *            the new y
	 */
	public void setY(int y) {
		this.y = y;
	}

	/**
	 * Checks if is valid position.
	 *
	 * @param xvalue
	 *            the xvalue
	 * @param yvalue
	 *            the yvalue
	 * @return true, if is valid position
	 */
	public static boolean isValidPosition(int xvalue, int yvalue) {
		if (xvalue > 0 && xvalue <= BOARD_SIZE && yvalue > 0 && yvalue <= BOARD_SIZE) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#equals(java.lang.Object)
	 */
	public boolean equals(Object other) {
		ChessPosition another = (ChessPosition) other;

		if (another.x == this.x && another.y == this.y) {
			return true;
		} else {
			return false;
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#hashCode()
	 */
	public int hashCode() {
		String xString = String.valueOf(this.x);
		String yString = String.valueOf(this.y);
		String stringCoordinate = xString + yString;
		return Integer.parseInt(stringCoordinate);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see java.lang.Object#toString()
	 */
	public String toString() {
		return (new StringBuilder()).append(YCoordinate.fromInt(this.x)).append(this.y).toString();
	}

}