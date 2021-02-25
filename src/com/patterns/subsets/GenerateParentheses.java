package com.patterns.subsets;

import java.util.ArrayList;
import java.util.List;

/**
 * For a given number ‘N’, write a function to generate all combination of ‘N’ pairs of balanced parentheses.
 * Input: N=3
 * Output: ((())), (()()), (())(), ()(()), ()()()
 * Time complexity : O(N*2^N)
 * Space complexity : O(N*2^N)
 */
public class GenerateParentheses {

    public static void main(String[] args) {
        List<String> result = GenerateParentheses.generateValidParentheses(2);
        System.out.println("All combinations of balanced parentheses are: " + result);

        result = GenerateParentheses.generateValidParentheses(3);
        System.out.println("All combinations of balanced parentheses are: " + result);
    }

    public static List<String> generateValidParentheses(int num) {
        List<String> result = new ArrayList<String>();
        backTrack("", 0, 0, num, result);
        return result;
    }

    private static void backTrack(String curr, int open, int close, int max, List<String> result) {

        if (curr.length() == 2 * max) {
            result.add(curr);
        }

        if (open < max) {
            backTrack(curr + "(", open + 1, close, max, result);
        }

        if (close < open) {
            backTrack(curr + ")", open, close + 1, max, result);
        }

    }
}
