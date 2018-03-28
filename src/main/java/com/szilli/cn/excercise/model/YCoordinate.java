/**********************************************************************************
 * YCoordinate.java
 *
 * @author Shrinivas Zilli (szilli@bekast.de)
 * Created on Mar 28, 2018
 *
 * Copyright (c) 2018 Bekast IT Consulting GmbH, All rights reserved.
 **********************************************************************************/
package com.szilli.cn.excercise.model;

/**
 * The Enum YCoordinate.
 */
public enum YCoordinate {

	/** The a. */
	A(1),
	/** The b. */
	B(2),
	/** The c. */
	C(3),
	/** The d. */
	D(4),
	/** The e. */
	E(5),
	/** The f. */
	F(6),
	/** The g. */
	G(7),
	/** The h. */
	H(8);

	/** The x value. */
	private int xValue;

	/**
	 * Instantiates a new y coordinate.
	 *
	 * @param xValue
	 *            the x value
	 */
	private YCoordinate(final int xValue) {
		this.xValue = xValue;
	}

	/**
	 * Gets the value.
	 *
	 * @return the value
	 */
	public int getValue() {
		return this.xValue;
	}

	/**
	 * From int.
	 *
	 * @param pointX
	 *            the point X
	 * @return the y coordinate
	 */
	public static YCoordinate fromInt(int pointX) {
		for (YCoordinate xValue : YCoordinate.values()) {
			if (pointX == xValue.getValue()) {
				return xValue;
			}
		}
		throw new IllegalArgumentException("Invalid YCoordinate value");
	}

}
