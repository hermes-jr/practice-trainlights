package net.cyllene.playground.trainlights;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

import java.util.Arrays;

import static org.junit.Assert.assertEquals;

@RunWith(value = Parameterized.class)
public class TrainlightsTest {
	private String state;

	public TrainlightsTest(String state) {
		this.state = state;
	}

	@Test
	public void isCalculatorCorrect() {
		Train train = new Train();
		train.setStateFromString(state);
		assertEquals(state.length(), Main.getTrainLength(train));
	}

	@Parameters(name = "{index}: calculate length of:({0})")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
						{"1000100011101"},
						{"1"},
						{"0"},
						{"101"}
				}
		);
	}
}
