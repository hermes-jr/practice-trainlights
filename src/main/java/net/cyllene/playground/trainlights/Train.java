package net.cyllene.playground.trainlights;

import com.sun.istack.internal.NotNull;

import java.util.BitSet;
import java.util.Random;

public class Train {
	private BitSet lights;
	private int length;
	private Random rand;

	public Train() {
		//setStateRandom();
		setStateFromString("0"); // default state
	}

	public void setStateFromString(@NotNull String s) throws IllegalArgumentException {
		if (s.isEmpty() || s.replaceAll("[01]", "").length() > 0) {
			throw new IllegalArgumentException();
		}

		lights = BitSet.valueOf(new long[]{Long.valueOf(s, 2)});
		length = s.length();
	}

	public void setStateRandom() {
		rand = new Random();
		length = rand.nextInt(Integer.MAX_VALUE - 1) + 1; // 1..max carts
		lights = new BitSet(length);

		for (int i = 0; i < length; i++) {
			if (rand.nextBoolean()) lights.set(i);
		}
	}

	public boolean getStateOf(int light) {
		int n = light % length;
		return lights.get(n);
	}

	public void flipStateOf(int light) {
		lights.flip(light);
	}

	@Override
	public String toString() {
		return "Train{" +
				"length=" + length +
				", lights on=" + lights.cardinality() +
				'}';
	}
}
