package com.patterns.mergeintervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Given a list of intervals, merge all the overlapping intervals to produce a list that has only mutually exclusive
 * intervals.
 * Intervals: [[1,4], [2,5], [7,9]]
 * Output: [[1,5], [7,9]]
 * Explanation: Since the first two intervals [1,4] and [2,5] overlap, we merged them into
 * one [1,5].
 * Time complexity : O(NLog(N))
 * Space complexity : O(N)
 */
public class MergeIntervals {

    public static void main(String[] args) {
        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(6, 7));
        input.add(new Interval(2, 4));
        input.add(new Interval(5, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

        input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 6));
        input.add(new Interval(3, 5));
        System.out.print("Merged intervals: ");
        for (Interval interval : MergeIntervals.merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();
    }

    public static List<Interval> merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new LinkedList<Interval>();
        Collections.sort(intervals, (o1, o2) -> o1.start - o2.start);

        mergedIntervals.add(intervals.get(0));

        for (int i = 1; i < intervals.size(); i++) {

            Interval lastMerged = mergedIntervals.get(mergedIntervals.size() - 1);
            Interval curr = intervals.get(i);

            if (lastMerged.end >= curr.start) {
                lastMerged.end = Math.max(lastMerged.end, curr.end);

            } else {
                mergedIntervals.add(curr);
            }
        }

        return mergedIntervals;
    }
}
