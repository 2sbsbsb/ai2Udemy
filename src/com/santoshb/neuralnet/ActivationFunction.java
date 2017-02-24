package com.santoshb.neuralnet;

public class ActivationFunction {

	public static float sigmoid(float x) {
		return (float) (1 / (1 + Math.exp(-x)));
	}
	
	/**
	 * Differentiation (1/(1+e^-x) =  e^-x / (1+e^-x)^2  = 1/(1+e^-x) [ 1 - {1/(1+e^-x)}] = sigmoid (1 - sigmoid) 
	 *   
	 * @param sigmoid
	 * @return
	 */
	public static float dSigmoid(float sigmoid) {
		return sigmoid*(1-sigmoid);
	}
}
