package com.patterns.cyclicsort;

/**
 * We are given an array containing ‘n’ objects. Each object, when created, was assigned a unique number from 1 to ‘n’
 * based on their creation sequence. This means that the object with sequence number ‘3’ was created just before the
 * object with sequence number ‘4’.
 * Input: [3, 1, 5, 4, 2]
 * Output: [1, 2, 3, 4, 5]
 * Time complexity : O(N)
 * Space complexity : O(1)
 */
public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = new int[]{3, 1, 5, 4, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{2, 6, 4, 3, 1, 5};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();

        arr = new int[]{1, 5, 6, 4, 3, 2};
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
        System.out.println();
    }

    public static void sort(int[] nums) {
        int i = 0;
        while (i < nums.length) {
            int j = nums[i] - 1;
            if (nums[i] != nums[j])
                swap(nums, i, j);
            else
                i++;
        }
    }

    private static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
}
