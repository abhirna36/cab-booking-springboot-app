/**
 * 
 */
package com.example.util;

/**
 * @author apple
 *
 */
public final class utils {

	public static double calculateDistance(int x1, int y1, int x2, int y2) {
		double distance = Math.sqrt((y2 - y1) * (y2 - y1) + (x2 - x1) * (x2 - x1));
		return distance;
	}

}
