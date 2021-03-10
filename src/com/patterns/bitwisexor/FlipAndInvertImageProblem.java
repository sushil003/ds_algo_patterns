package com.patterns.bitwisexor;

/**
 * Given a binary matrix representing an image, we want to flip the image horizontally, then invert it.
 * To flip an image horizontally means that each row of the image is reversed. For example,
 * flipping [0, 1, 1] horizontally results in [1, 1, 0].
 * To invert an image means that each 0 is replaced by 1, and each 1 is replaced by 0. For example,
 * inverting [1, 1, 0] results in [0, 0, 1].
 * Example 1:
 * Input: [
 * [1,0,1],
 * [1,1,1],
 * [0,1,1]
 * ]
 * Output: [
 * [0,1,0],
 * [0,0,0],
 * [0,0,1]
 * ]
 * Time complexity : O(N)
 * Space complexity : O(1)
 */
public class FlipAndInvertImageProblem {

    public static void main(String[] args) {
        int[][] arr = {{1, 0, 1}, {1, 1, 1}, {0, 1, 1}};
        print(flipAndInvertImage(arr));
        System.out.println();

        int[][] arr2 = {{1, 1, 0, 0}, {1, 0, 0, 1}, {0, 1, 1, 1}, {1, 0, 1, 0}};
        print(flipAndInvertImage(arr2));
    }

    public static int[][] flipAndInvertImage(int[][] arr) {
        int C = arr[0].length;
        for (int[] row : arr) {
            for (int i = 0; i < (C + 1) / 2; ++i) {
                int tmp = row[i] ^ 1;
                row[i] = row[C - 1 - i] ^ 1;
                row[C - 1 - i] = tmp;
            }
        }
        return arr;
    }

    public static void print(int[][] arr) {
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }
}
