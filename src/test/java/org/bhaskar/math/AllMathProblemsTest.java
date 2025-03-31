package org.bhaskar.math;

import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.List;
import java.util.stream.Stream;


class AllMathProblemsTest {

    MathProblems mathProblems;
    @BeforeEach
    public void setup() {
        mathProblems = new MathProblems();
    }

    @ParameterizedTest
    @MethodSource("palindromeTestCases")
    void testPalindromeNumbers(int n, boolean expected) {
        boolean actualValue = mathProblems.isPalindromeNumber(n);
        Assertions.assertEquals(expected, actualValue);
    }

    private static Stream<Object[]> palindromeTestCases() {
        return Stream.of(
                new Object[]{121, true},
                new Object[]{12321, true},
                new Object[]{123, false}
        );
    }
    @ParameterizedTest
    @MethodSource("getAllDivisorOfNumberTestCases")
    void testGetAllDivisorOfNumber(int n, List<Integer> expectedList) {
        List<Integer> actualList = mathProblems.getAllDivisorOfNumber(n);
        Assertions.assertEquals(expectedList, actualList);
    }
    @ParameterizedTest
    @MethodSource("getAllDivisorOfNumberTestCases")
    void testGetAllDivisorOfNumber2(int n, List<Integer> expectedList) {
        List<Integer> actualList = mathProblems.getAllDivisorOfNumber2(n);
        Assertions.assertEquals(expectedList, actualList);
    }

    private static Stream<Object[]> getAllDivisorOfNumberTestCases() {
        return Stream.of(
                new Object[]{20, List.of(1,2,4,5,10,20)},
                new Object[]{10, List.of(1,2,5,10)}
        );
    }


}