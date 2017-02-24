package com.santoshb.neuralnet;



public class App {

	public static void main(String[] args) throws Exception {
		// Uncomment one by one to experiment
		//sample();
		//tryAnd();
		//tryOr();
		//tryXOr();
	}



	


	/**
	 */
	private static void sample() {
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
	
	private static void tryAnd() {
		float[][] trainingData = new float[][] {
			new float[] {0,0},
			new float[] {0,1},
			new float[] {1,0},
			new float[] {1,1},			
		};
		
		float[][] trainingResults = new float[][] {
			new float[] {0},
			new float[] {0},
			new float[] {0},
			new float[] {1},			
		};		
		tryModel(trainingData,trainingResults);
	}

	
	private static void tryOr() {
		float[][] trainingData = new float[][] {
			new float[] {0,0},
			new float[] {0,1},
			new float[] {1,0},
			new float[] {1,1},			
		};
		
		float[][] trainingResults = new float[][] {
			new float[] {0},
			new float[] {1},
			new float[] {1},
			new float[] {1},			
		};		
		tryModel(trainingData,trainingResults);
	}
	
	private static void tryXOr() {
		float[][] trainingData = new float[][] {
			new float[] {0,0},
			new float[] {0,1},
			new float[] {1,0},
			new float[] {1,1},			
		};
		
		float[][] trainingResults = new float[][] {
			new float[] {0},
			new float[] {1},
			new float[] {1},
			new float[] {0},			
		};		
		tryModel(trainingData,trainingResults);
	}
	
	
	static void tryModel(float[][] trainingData, float[][] trainingResults) {
		BackpropNeuralNetwork backpropagationNeuralNetworks = new BackpropNeuralNetwork(2, 3, 1);
		
		for (int iterations = 0; iterations < NeuralNetConstants.ITERATIONS; iterations++) {
			
			for(int i=0; i<trainingResults.length;i++) {
				backpropagationNeuralNetworks.train(trainingData[i], trainingResults[i], NeuralNetConstants.LEARNING_RATE, NeuralNetConstants.MOMENTUM);
			}
			//
			System.out.println("");
			//
			for(int i=0; i<trainingResults.length; i++) {
				float[] t = trainingData[i];
				System.out.println("Num of iterations: " + (iterations + 1));
				System.out.printf("%.1f, %.1f --> %.3f\n", t[0], t[1], backpropagationNeuralNetworks.run(t)[0]);	
			}						
		}		
	}	
	
}