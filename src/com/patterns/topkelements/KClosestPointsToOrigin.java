package com.patterns.topkelements;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

/**
 * Given an array of points in the a 2D2D plane, find ‘K’ closest points to the origin.
 * Example 1:
 * Input: points = [[1,2],[1,3]], K = 1
 * Output: [[1,2]]
 * Explanation: The Euclidean distance between (1, 2) and the origin is sqrt(5).
 * The Euclidean distance between (1, 3) and the origin is sqrt(10).
 * Since sqrt(5) < sqrt(10), therefore (1, 2) is closer to the origin.
 * Time complexity : O(NLOG(K))
 * Space complexity : O(K)
 */
public class KClosestPointsToOrigin {

    public static void main(String[] args) {
        Point[] points = new Point[]{new Point(1, 3), new Point(3, 4), new Point(2, -1)};
        List<Point> result = KClosestPointsToOrigin.findClosestPoints(points, 2);
        System.out.print("Here are the k points closest the origin: ");
        for (Point p : result)
            System.out.print("[" + p.x + " , " + p.y + "] ");
    }

    public static List<Point> findClosestPoints(Point[] points, int k) {

        PriorityQueue<Point> queue = new PriorityQueue<>((a, b) -> b.distFromOrigin() - a.distFromOrigin());

        for (Point p : points) {

            queue.offer(p);
            if (queue.size() > k) {

                queue.poll();
            }
        }

        return new ArrayList<>(queue);
    }
}
