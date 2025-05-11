package com.promineotech;

import org.junit.jupiter.params.ParameterizedTest;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.params.provider.Arguments.arguments;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.spy;

import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class TestDemoJUnitTest {

	private TestDemo testDemo;

	@BeforeEach
	void setUp() throws Exception {
		testDemo = new TestDemo();
	}

	@ParameterizedTest
	@MethodSource("com.promineotech.TestDemoJUnitTest#argumentsForAddPositive")
	public void assertThatTwoPositiveNumbersAreAddedCorrectly(int a, int b, int expected, boolean expectException) {
		if (!expectException) {

			assertThat(testDemo.addPositive(a, b)).isEqualTo(expected);

		} else {
			assertThatThrownBy(() -> testDemo.addPositive(a, b)).isInstanceOf(IllegalArgumentException.class);
		}
	}

	static Stream<Arguments> argumentsForAddPositive() {
		return Stream.of(arguments(2, 3, 5, false), // Valid
				arguments(10, 15, 25, false), // Valid
				arguments(-1, 5, 0, true), // Negative a
				arguments(4, -3, 0, true), // Negative b
				arguments(0, 5, 0, true), // Zero a
				arguments(7, 0, 0, true), // Zero b
				arguments(-2, -8, 0, true) // Both negative
		);
	}
	
	@Test 
	void assertThatPairsOfPositiveNumbersAreAddedCorrectly() {
		TestDemo testDemo = new TestDemo();

		assertThat(testDemo.addPositive(4, 5)).isEqualTo(9);
		assertThat(testDemo.addPositive(40, 50)).isEqualTo(90);
		assertThat(testDemo.addPositive(1, 2)).isEqualTo(3);
		assertThat(testDemo.addPositive(100, 200)).isEqualTo(300);
		assertThat(testDemo.addPositive(7, 8)).isEqualTo(15);
	}
	
//@test for reverse string method
	public void assertThatReverseStringWorksCorrectly() {
		TestDemo testDemo = new TestDemo();

		assertThat(testDemo.reverseString("hello")).isEqualTo("olleh");
		assertThat(testDemo.reverseString("donut")).isEqualTo("tunod");
		assertThat(testDemo.reverseString("HotShot")).isEqualTo("tohStoH");
		assertThat(testDemo.reverseString("thisisnotastring")).isEqualTo("gnirtsatonsisiht");
		assertThat(testDemo.reverseString(null)).isNull(); //null test
	}

	@Test //  Mockito Spy test
    void assertThatNumberSquaredIsCorrect() {
        TestDemo testDemo = new TestDemo();

        // b. mock test using Mockito.spy
        TestDemo mockDemo = spy(testDemo);

        // c. Program mocked object to return 5 when getRandomInt method is called
        doReturn(5).when(mockDemo).getRandomInt();

        // d. Call method randomNumberSquared() on mocked TestDemo object
        int fiveSquared = mockDemo.randomNumberSquared();

        // e. Assert result is 25
        assertThat(fiveSquared).isEqualTo(25);
    }

		
		

		
}

