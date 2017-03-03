package com.santoshb.neuralnet;


public class BackpropNeuralNetwork {
	
	private Layer[] layers;
	
	/**
	 * @param inputSize
	 * @param hiddenSize
	 * @param outputSize
	 */
	public BackpropNeuralNetwork(int inputSize, int hiddenSize, int outputSize) {		
		layers = new Layer[2];
		layers[0] = new Layer(inputSize, hiddenSize);
		layers[1] = new Layer(hiddenSize, outputSize);
	}
	
	/**
	 * @param index
	 * @return
	 */
	public Layer getLayers(int index) {
		return layers[0];
	}
	
	
	/**
	 * @param input
	 * @return
	 */
	public float[] run(float[] input) {
		float[] activations = input;
		for (int i = 0; i < layers.length; i++) {
			activations = layers[i].run(activations);
		}
		return activations;
	}
	
	
	/**
	 * @param input
	 * @param targetOutput
	 * @param learningRate
	 * @param momentum
	 */
	public void train(float[] input, float[] targetOutput, float learningRate, float momentum) {
		
		float[] calculatedOutput = run(input);
		float[] error = new float[calculatedOutput.length];
		
		for (int i = 0; i < error.length; i++) {
			error[i] = targetOutput[i] - calculatedOutput[i]; 
		}		
		// Start training from the output (Remember backward propagation)
		for (int i = layers.length - 1; i >= 0; i--) {
			error = layers[i].train(error, learningRate, momentum);
		}
	}
}
