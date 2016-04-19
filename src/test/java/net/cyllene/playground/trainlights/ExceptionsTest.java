package net.cyllene.playground.trainlights;

import org.junit.*;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;

@RunWith(value = Parameterized.class)
public class ExceptionsTest {
	private String conf;
	private boolean expectException;
	private Train train;

	@Rule
	public ExpectedException exception = ExpectedException.none();

	public ExceptionsTest(String conf, boolean expectException) {
		this.expectException = expectException;
		this.conf = conf;
	}

	@Parameterized.Parameters(name = "{index}: ({0}) should throw an exception: {1}")
	public static Iterable<Object[]> data() {
		return Arrays.asList(new Object[][]{
						{"", true},
						{new String(), true},
						{"01 10", true},
						{"11101bb", true},
						{"OO1", true},
						{"00I", true},
						{"1", false},
						{"000", false},
				}
		);
	}

	@Before
	public void setup() {
		train = new Train();
	}

	@After
	public void cleanup() {
		train = null;
	}

	@Test
	public void setStateFromStringThrowsExceptionOnIncorrectInput() {
		if (expectException) exception.expect(IllegalArgumentException.class);
		train.setStateFromString(conf);
	}
}
