package org.bhaskar.math;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;


class AllMathProblemsTest {

    @ParameterizedTest
    @MethodSource("palindromeTestCases")
    void testPalindromeNumbers(int n, boolean expected) {
        boolean actualValue = MathProblems.isPalindromeNumber(n);
        Assertions.assertEquals(expected, actualValue);
    }

    private static Stream<Object[]> palindromeTestCases() {
        return Stream.of(
                new Object[]{121, true},
                new Object[]{12321, true},
                new Object[]{123, false}
        );
    }


}