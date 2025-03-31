package org.bhaskar.string;

public class StringProblemRunner {
    public static void main(String[] args) {
        StringProblem stringProblem =new StringProblem();
        char[] charArray = {'a', 'a', 'b', 'b', 'c', 'c', 'c'};
        int compressedLength = stringProblem.compress(charArray);
        System.out.println("Compressed length: " + compressedLength);
        System.out.println("Compressed array: " + new String(charArray, 0, compressedLength));

        // Assertions
        assert compressedLength == 6 : "Compressed length should be 6";
        assert new String(charArray, 0, compressedLength).equals("a2b2c3") : "Compressed array should be 'a2b2c3'";


    }
}
