package com.patterns.twopointers;

/**
 * Given an array of sorted numbers, remove all duplicates from it. You should not use any extra space; after removing
 * the duplicates in-place return the length of the subarray that has no duplicate in it.
 * Input: [2, 3, 3, 3, 6, 9, 9]
 * Output: 4
 * Explanation: The first four elements after removing the duplicates will be [2, 3, 6, 9].
 * Time complexity : O(N)
 * Space complexity : O(1)
 */
public class RemoveDuplicates {

    public static void main(String[] args) {
        int[] arr = new int[]{2, 3, 3, 3, 6, 9, 9};
        System.out.println(RemoveDuplicates.remove(arr));
        arr = new int[]{2, 2, 2, 11};
        System.out.println(RemoveDuplicates.remove(arr));
    }

    public static int remove(int[] arr) {
        int nextNonDuplicate = 1; // index of the next non-duplicate element
        for (int i = 1; i < arr.length; i++) {
            if (arr[nextNonDuplicate - 1] != arr[i]) {
                arr[nextNonDuplicate] = arr[i];
                nextNonDuplicate++;
            }
        }
        return nextNonDuplicate;
    }
}
