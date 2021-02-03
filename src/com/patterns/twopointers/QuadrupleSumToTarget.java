package com.patterns.twopointers;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Given an array of unsorted numbers and a target number, find all unique quadruplets in it, whose sum is equal to the
 * target number.
 * Input: [4, 1, 2, -1, 1, -3], target=1
 * Output: [-3, -1, 1, 4], [-3, 1, 1, 2]
 * Explanation: Both the quadruplets add up to the target.
 * Time complexity : O(N^3)
 * Space complexity : O(N)
 */
public class QuadrupleSumToTarget {

    public static void main(String[] args) {
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[]{4, 1, 2, -1, 1, -3}, 1));
        System.out.println(QuadrupleSumToTarget.searchQuadruplets(new int[]{2, 0, -1, 1, -2, 2}, 2));
    }

    public static List<List<Integer>> searchQuadruplets(int[] arr, int target) {
        List<List<Integer>> quadruplets = new ArrayList<>();
        Arrays.sort(arr);

        for (int i = 0; i < arr.length - 3; i++) {

            for (int j = i + 1; j < arr.length - 2; j++) {

                int left = j + 1;
                int right = arr.length - 1;
                while (left <= right) {

                    if (arr[i] + arr[j] + arr[left] + arr[right] == target) {

                        quadruplets.add(Arrays.asList(arr[i], arr[j], arr[left], arr[right]));
                        left++;
                        right--;

                    } else if (arr[i] + arr[j] + arr[left] + arr[right] > target) {
                        right--;

                    } else {
                        left++;
                    }

                }
            }
        }
        return quadruplets;
    }
}
