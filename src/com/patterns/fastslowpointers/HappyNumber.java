package com.patterns.fastslowpointers;

/**
 * Any number will be called a happy number if, after repeatedly replacing it with a number equal to the sum of the
 * square of all of its digits, leads us to number ‘1’. All other (not-happy) numbers will never reach ‘1’. Instead,
 * they will be stuck in a cycle of numbers which does not include ‘1’.
 * Input: 23
 * Output: true (23 is a happy number)
 * Explanations: Here are the steps to find out that 23 is a happy number:
 * Time complexity : O(NLog(N))
 * Space complexity : O(1)
 */
public class HappyNumber {

    public static void main(String[] args) {
        System.out.println(HappyNumber.find(23));
        System.out.println(HappyNumber.find(12));
    }

    public static boolean find(int num) {
        int slow = num;
        int fast = num;

        do {

            slow = getNext(slow);
            fast = getNext(getNext(fast));
        } while (slow != fast);
        return slow == 1;
    }

    private static int getNext(int num) {
        int sum = 0;
        int d = num % 10;
        sum += (d * d);
        num /= 10;
        return sum;
    }
}
