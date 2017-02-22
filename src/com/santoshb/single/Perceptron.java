package com.santoshb.single;

public class Perceptron {
	
	private final float[] weights;
	private final float[][] input;
	private final float[] output;
	private int numOfWeights;
	
	/**
	 * @param input 
	 * 
	 * Ex - Format  
	 * x , y  
	 * 0  0
	 * 0  1 
	 * 1  0
	 * 1  1 
	 * 
	 * @param output
	 * 
	 * Ex - Format
	 * 0 
	 * 0
	 * 0
	 * 1	 
	 * 
	 */
	public Perceptron(float[][] input, float[] output) {
		this.input = input;
		this.output = output;
		this.numOfWeights = input[0].length;
		this.weights = new float[numOfWeights];	
		initialzeWeight();
	}

	/**
	 */
	private void initialzeWeight() {
		for(int i=0;i<numOfWeights;++i)
			weights[i] = 0;
	}
	
	/**
	 * Train is to update the weight 
	 * New Weight = old weight + (learningRate * input * error)
	 * 			  = old weight + delta 
	 * where delta is (learningRate * input * error)
	 * 
	 * @param learningRate
	 */
	public void train(float learningRate) {		
		float totalError = 1;		
		while ( totalError != 0 ) {			
			totalError = 0;			
			for(int i=0;i<output.length;i++) {				
				float calculatedOutput = calculateOutput(input[i]);
				float error = Math.abs(output[i]-calculatedOutput);				
				totalError += error;				
				for(int j=0;j<numOfWeights;j++) {
					weights[j] = weights[j] + learningRate * input[i][j] * error;
					System.out.println("Updated weight: " + weights[j]);
				}
			}
			
			System.out.println("Keep on training the network, error is: " + totalError);
		}
		
	}
	
	/**
	 * @param input
	 * @return
	 * ActivationFunction (Sum of ( weight * input) )
	 */
	public float calculateOutput(float[] input) {		
		float sum = 0f;		
		for(int i=0;i<input.length;++i) {
			sum = sum + weights[i] * input[i];
		}		
		return ActivationFunction.stepFunction(sum);
	}
}
