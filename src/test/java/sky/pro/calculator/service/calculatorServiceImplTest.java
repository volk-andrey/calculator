package sky.pro.calculator.service;


import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Random;
import java.util.stream.Stream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThatExceptionOfType;
import static org.junit.jupiter.api.Assertions.*;

class calculatorServiceImplTest {

    private final calculatorService calculatorService = new calculatorServiceImpl();
    private static final Random RANDOM = new Random();

    @Test
    void getHello_WhenCalled_ThenReturnHello() {
        String hello = calculatorService.getHello();
        assertEquals("Добро пожаловать в калькулятор", hello);
    }

    @ParameterizedTest
    @MethodSource("provideDifferentParams")
    void getSummary_WhenCorrectParams_ThenReturnCorrectResult(Integer a, Integer b) {
        int expected = a + b;

        int actual = calculatorService.plus(a, b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNullParams")
    void getSum_WhenNullParams_ThenReturnCorrectResult(Integer a, Integer b) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> calculatorService.plus(a, b));
    }
    @ParameterizedTest
    @MethodSource("provideDifferentParams")
    void getMinus_WhenCorrectParams_ThenReturnCorrectResult(Integer a, Integer b) {
        int expected = a - b;

        int actual = calculatorService.minus(a, b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNullParams")
    void getMinus_WhenNullParams_ThenReturnCorrectResult(Integer a, Integer b) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> calculatorService.minus(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideDifferentParams")
    void getMultiply_WhenCorrectParams_ThenReturnCorrectResult(Integer a, Integer b) {
        int expected = a * b;

        int actual = calculatorService.multiply(a, b);
        assertEquals(expected, actual);
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNullParams")
    void getMultiply_WhenNullParams_ThenReturnCorrectResult(Integer a, Integer b) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> calculatorService.multiply(a, b));
    }

    @ParameterizedTest
    @MethodSource("provideDifferentDivideParams")
    void getDivide_WhenCorrectParams_ThenReturnCorrectResult(Integer a, Integer b) {
        int expected = a / b;

        int actual = calculatorService.divide(a, b);
        assertEquals(expected, actual);
    }

    @Test
    void getDivide_WhenIncorrectParams_ThenReturnCorrectResult() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> calculatorService.divide(1,0));
    }

    @ParameterizedTest
    @MethodSource("provideDifferentNullParams")
    void getDivide_WhenNullParams_ThenReturnCorrectResult(Integer a, Integer b) {
        assertThatExceptionOfType(NullPointerException.class)
                .isThrownBy(() -> calculatorService.divide(a, b));
    }

    private static Stream<Arguments> provideDifferentParams() {
        return Stream.concat(
                provideDifferentDivideParams(),
                Stream.of(Arguments.of(RANDOM.nextInt(), RANDOM.nextInt()),
                Arguments.of(0,0)));
    }

    private static Stream<Arguments> provideDifferentDivideParams() {
        return Stream.of(
                Arguments.of(10, 2),
                Arguments.of(200, 100),
                Arguments.of(RANDOM.nextInt(), 4)
        );
    }

    private static Stream<Arguments> provideDifferentNullParams() {
        return Stream.of(
                Arguments.of(1, null),
                Arguments.of(null, 100),
                Arguments.of(null, null)
        );
    }
}