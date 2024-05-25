package com.promineotech;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;

class TestDemoJUnitTest {

	private TestDemo testDemo;
	
	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	void assertThatTwoPostiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		expectException = true;
		
		if(!expectException) {
			assertThat(testDemo.addPositive(a,b)).isEqualTo(expected);
		}
		else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b))
						.isInstanceOf(IllegalArgumentException.class);
		}
	}
	
	 Arguments argumentsForAddPositive() {
		arguments(2,4,6,false);
		
		arguments(9, 0, 9, true);
		
		arguments(5, 7, 12, false);
		
		return (Arguments) Stream.of();
	}

	private void arguments(int i, int j, int k, boolean b) {
		// TODO Auto-generated method stub
		
	}
	
	@Test 
	public void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		assertThat(testDemo.addPositive(4,5)).isEqualTo(9);
		
		assertThat(testDemo.addPositive(9,5)).isEqualTo(14);
		
	}
	//Test to see if numbers are really being multiplied
	@Test
	public void assertThatNumbersAreBeingMultiplied() {
		assertThat(testDemo.multiplyNumber(3, 3)).isEqualTo(9);
		
		assertThat(testDemo.multiplyNumber(0, 5)).isEqualTo(0);
		
		assertThat(testDemo.multiplyNumber(-1, 5)).isEqualTo(-5);
	}
	@Test
	public void assertThatNumberSquaredIsCorrect() {
		TestDemo mockDemo = spy(testDemo);
		
		doReturn(5).when(mockDemo).getRandomInt();	
		
		int fiveSquared = mockDemo.randomNumberSquared();
		
		assertThat(fiveSquared).isEqualTo(25);
	}

}
