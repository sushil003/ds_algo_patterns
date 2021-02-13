package com.patterns.cyclicsort;

/**
 * We are given an unsorted array containing ‘n+1’ numbers taken from the range 1 to ‘n’. The array has only one
 * duplicate but it can be repeated multiple times. Find that duplicate number without using any extra space.
 * You are, however, allowed to modify the input array.
 * Input: [1, 4, 4, 3, 2]
 * Output: 4
 * Time complexity : O(N)
 * Space complexity : O(1)
 */
public class FindDuplicate {

    public static void main(String[] args) {
        System.out.println(FindDuplicate.findNumber(new int[]{1, 4, 4, 3, 2}));
        System.out.println(FindDuplicate.findNumber(new int[]{2, 1, 3, 3, 5, 4}));
        System.out.println(FindDuplicate.findNumber(new int[]{2, 4, 1, 4, 4}));
    }

    public static int findNumber(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            if (nums[i] != i + 1) {
                if (nums[i] != nums[nums[i] - 1])
                    swap(nums, i, nums[i] - 1);
                else // we have found the duplicate
                    return nums[i];
            } else {
                i++;
            }
        }

        return -1;
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
