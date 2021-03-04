package com.patterns.modifiedbinarysearch;

/**
 * Given an array of numbers which is sorted in ascending order and also rotated by some arbitrary number,
 * find if a given ‘key’ is present in it.
 * Write a function to return the index of the ‘key’ in the rotated array. If the ‘key’ is not present, return
 * -1. You can assume that the given array does not have any duplicates.
 * Input: [10, 15, 1, 3, 8], key = 15
 * Output: 1
 * Explanation: '15' is present in the array at index '1'.
 * Time complexity : O(LOG(N))
 * Space complexity : O(1)
 */
public class SearchRotatedArray {

    public static void main(String[] args) {
        System.out.println(SearchRotatedArray.search(new int[]{10, 15, 1, 3, 8}, 15));
        System.out.println(SearchRotatedArray.search(new int[]{4, 5, 7, 9, 10, -1, 2}, 10));
    }

    public static int search(int[] arr, int key) {
        int start = 0, end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key)
                return mid;

            if (arr[start] <= arr[mid]) { // left side is sorted in ascending order
                if (key >= arr[start] && key < arr[mid]) {
                    end = mid - 1;
                } else { //key > arr[mid]
                    start = mid + 1;
                }
            } else { // right side is sorted in ascending order
                if (key > arr[mid] && key <= arr[end]) {
                    start = mid + 1;
                } else {
                    end = mid - 1;
                }
            }
        }

        // we are not able to find the element in the given array
        return -1;
    }
}
