package com.patterns.subsets;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Given an expression containing digits and operations (+, -, *), find all possible ways in which the expression
 * can be evaluated by grouping the numbers and operators using parentheses.
 * Input: "1+2*3"
 * Output: 7, 9
 * Explanation: 1+(2*3) => 7 and (1+2)*3 => 9
 * Time complexity : O(N*2^N)
 * Space complexity : O(2^N)
 */
public class EvaluateExpression {

    // memoization map
    Map<String, List<Integer>> map = new HashMap<String, List<Integer>>();

    public static void main(String[] args) {
        EvaluateExpression ee = new EvaluateExpression();
        List<Integer> result = ee.diffWaysToEvaluateExpression("1+2*3");
        System.out.println("Expression evaluations: " + result);

        ee = new EvaluateExpression();
        result = ee.diffWaysToEvaluateExpression("2*3-4-5");
        System.out.println("Expression evaluations: " + result);
    }

    public List<Integer> diffWaysToEvaluateExpression(String input) {
        if (map.containsKey(input))
            return map.get(input);
        List<Integer> result = new ArrayList<>();
        // base case: if the input string is a number, parse and return it.
        if (!input.contains("+") && !input.contains("-") && !input.contains("*")) {
            result.add(Integer.parseInt(input));
        } else {
            for (int i = 0; i < input.length(); i++) {
                char chr = input.charAt(i);
                if (!Character.isDigit(chr)) {
                    List<Integer> leftParts = diffWaysToEvaluateExpression(input.substring(0, i));
                    List<Integer> rightParts = diffWaysToEvaluateExpression(input.substring(i + 1));
                    for (int part1 : leftParts) {
                        for (int part2 : rightParts) {
                            if (chr == '+')
                                result.add(part1 + part2);
                            else if (chr == '-')
                                result.add(part1 - part2);
                            else if (chr == '*')
                                result.add(part1 * part2);
                        }
                    }
                }
            }
        }
        map.put(input, result);
        return result;
    }
}
