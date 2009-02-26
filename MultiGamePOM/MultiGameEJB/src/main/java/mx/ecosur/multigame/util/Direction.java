/*
* Copyright (C) 2008 ECOSUR, Andrew Waterman and Max Pimm
* 
* Licensed under the Academic Free License v. 3.0. 
* http://www.opensource.org/licenses/afl-3.0.php
*/

/**
 * Basic enum used for determining the direction a set of tokens
 * is aligned.
 * 
 * @author awaterma@ecosur.mx
 */

package mx.ecosur.multigame.util;

import java.util.TreeSet;

import mx.ecosur.multigame.ejb.entity.Cell;


public enum Direction {
	
	NORTH, SOUTH, EAST, WEST, NORTHEAST, SOUTHEAST, NORTHWEST, SOUTHWEST, UNKNOWN;
	
	public Vertice getVertice () {
		
		Vertice ret = null;
		
		switch (this) {
			case NORTH:
				ret = Vertice.VERTICAL;
				break;
			case SOUTH:
				ret = Vertice.VERTICAL;
				break;
			case EAST:
				ret = Vertice.HORIZONTAL;
				break;
			case WEST:
				ret = Vertice.HORIZONTAL;
				break;
			case NORTHEAST:
				ret = Vertice.FORWARD;
				break;
			case SOUTHEAST:
				ret = Vertice.REVERSE;
				break;
			case NORTHWEST:
				ret = Vertice.REVERSE;
				break;
			case SOUTHWEST:
				ret = Vertice.FORWARD;
				break;
			default:
				ret = Vertice.UNKNOWN;
				break;
		}
		
		return ret;
	}

}
