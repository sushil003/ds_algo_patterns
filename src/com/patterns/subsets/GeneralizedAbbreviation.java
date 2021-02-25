package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * Given a word, write a function to generate all of its unique generalized abbreviations.
 * <p>
 * Generalized abbreviation of a word can be generated by replacing each substring of the word by the count of
 * characters in the substring. Take the example of “ab” which has four substrings: “”, “a”, “b”, and “ab”. After
 * replacing these substrings in the actual word by the count of characters we get all the generalized
 * abbreviations: “ab”, “1b”, “a1”, and “2”.
 * Example 1:
 * Input: "BAT"
 * Output: "BAT", "BA1", "B1T", "B2", "1AT", "1A1", "2T", "3"
 * Time complexity : O(N*2^N)
 * Space complexity : O(N*2^N)
 */
public class GeneralizedAbbreviation {

    public static void main(String[] args) {
        List<String> result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("BAT");
        System.out.println("Generalized abbreviation are: " + result);

        result = GeneralizedAbbreviation.generateGeneralizedAbbreviation("code");
        System.out.println("Generalized abbreviation are: " + result);
    }

    public static List<String> generateGeneralizedAbbreviation(String word) {
        List<String> result = new ArrayList<String>();
        generateAbbreviationRecursive(word, new StringBuilder(), 0, 0, result);
        return result;
    }

    private static void generateAbbreviationRecursive(String word, StringBuilder abWord, int start, int count,
                                                      List<String> result) {

        if (start == word.length()) {
            if (count != 0)
                abWord.append(count);
            result.add(abWord.toString());
        } else {
            // continue abbreviating by incrementing the current abbreviation count
            generateAbbreviationRecursive(word, new StringBuilder(abWord), start + 1, count + 1, result);

            // restart abbreviating, append the count and the current character to the string
            if (count != 0)
                abWord.append(count);
            generateAbbreviationRecursive(word, new StringBuilder(abWord).append(word.charAt(start)), start + 1, 0, result);
        }
    }
}
