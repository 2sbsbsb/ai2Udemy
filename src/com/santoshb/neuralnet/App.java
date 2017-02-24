package com.santoshb.neuralnet;

public class App {

	public static void main(String[] args) throws Exception {

		BackpropNeuralNetwork backpropagationNeuralNetworks = new BackpropNeuralNetwork(4, 6, 3);

		for (int iterations = 0; iterations < NeuralNetConstants.ITERATIONS; iterations++) {
			for (int i = 0; i < Data.trainingResults.length; i++) {
				backpropagationNeuralNetworks.train(Data.trainingData[i], Data.trainingResults[i],
						NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
			}

			if ((iterations + 1) % 1 == 0) {
				System.out.println("Iteration #" + iterations + "\n");
				for (int i = 0; i < Data.trainingResults.length; i++) {
					float[] data = Data.trainingData[i];
					float[] calculatedOutput = backpropagationNeuralNetworks.run(data);
					System.out.println(data[0] + ", " + data[1] + ", " + data[2] + ", " + data[3] + " --> "
							+ Math.round(calculatedOutput[0]) + " - " + Math.round(calculatedOutput[1]) + " - "
							+ Math.round(calculatedOutput[2]));
				}
			}
		}
	}
}