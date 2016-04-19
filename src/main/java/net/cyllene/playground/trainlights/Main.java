package net.cyllene.playground.trainlights;

public class Main {
	public static int getTrainLength(Train train) {
		int offset = 1;
		while (true) {
			if (train.getStateOf(offset) == train.getStateOf(0)) {
				// Current light state is the same as in cart 0
				// We return back to cart 0 and toggle the light
				train.flipStateOf(0);
				if (train.getStateOf(offset) == train.getStateOf(0)) {
					// If n'th light toggles, a cycle is detected
					break;
				}
			}
			// If state is different from state of light 0, then this cart is new.
			// Go further next time
			offset++;
		}
		return offset;
	}

	public static void main(String[] args) {
		int testCases = 2;
		Train train;

		while (testCases-- > 0) {
			train = new Train();
			train.setStateRandom();

			System.out.println(train);

			int answer = getTrainLength(train);
			System.out.println("Calculated train length is: " + answer);

		}
	}
}
