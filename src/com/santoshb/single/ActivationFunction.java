package com.santoshb.single;

/**
 */
public class ActivationFunction {
	
	/**
	 * Simple activation function 
	 * @param activation
	 * @return
	 */
	public static int stepFunction(float activation) {	
		return activation>1 ? 1 : 0;
	}	
}
