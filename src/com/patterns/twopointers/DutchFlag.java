package com.patterns.twopointers;

/**
 * Given an array containing 0s, 1s and 2s, sort the array in-place. You should treat numbers of the array as objects,
 * hence, we can’t count 0s, 1s, and 2s to recreate the array.
 * Input: [1, 0, 2, 1, 0]
 * Output: [0 0 1 1 2]
 * Time complexity : O(N)
 * Space complexity : O(1)
 */
public class DutchFlag {

    public static void main(String[] args) {
        int[] arr = new int[]{1, 0, 2, 1, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 2, 0, 1, 2, 0};
        DutchFlag.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    public static void sort(int[] arr) {
        int low = 0;
        int curr = 0;
        int high = arr.length - 1;

        while (curr <= high) {

            if (arr[curr] == 0) {
                swap(arr, curr++, low++);

            } else if (arr[curr] == 2) {
                swap(arr, curr, high--);
            } else {
                curr++;
            }
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
