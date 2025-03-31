package org.bhaskar.string;


import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertEquals;

class StringProblemTest {

        @Test
        public void testStringCompression() {
            StringProblem stringProblem = new StringProblem();
            char[] charArray = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
            int compressedLength = stringProblem.compress(charArray);

            assertEquals(6, compressedLength, "Compressed length should be 6");
            assertEquals("a2b2c3", new String(charArray, 0, compressedLength), "Compressed array should be 'a2b2c3'");
        }

}