package com.santoshb.single;

import java.util.Arrays;

public class App {

	public static void main(String[] args) {
		
		float[][] input = { {0,0}, {0,1}, {1,0}, {1,1} };
		
		// AND LOGIC 
		float[] outputAnd = {0,0,0,1};
		//Expectation - The final output after training will be same as the output provided
		tryLogic(input,outputAnd);
		
		
		// OR LOGIC 		
		float[] outputOR = {0,1,1,1};
		//Expectation - The final output after training will be same as the output provided
		tryLogic(input,outputOR);
		
		// Try XOR LOGIC and it will not work because it is non-linear separable problem (0s and 1s cannot be seperated by a single line, try plotting (x, y) with output
		float[] outputXor = {0,1,1,0};
		//Expectation -  It will not work here because this solution doesn't have a hidden layer
		//tryLogic(input,outputXor);						
		//System.out.println("The error is 0 so our neural network is ready! Predictions: ");
	}
	
	
	
	static void tryLogic(float[][] input, float[] output) {
		Perceptron perceptron = new Perceptron(input, output);
		perceptron.train(0.1f);			
		// Verify final output		
		int length = input.length;
		for(int i=0; i<length; i++) {
			System.out.println("The final output after training for " + Arrays.toString(input[i]) + " is " + perceptron.calculateOutput(input[i]));					 
		}		
	}
	
	
	
}
