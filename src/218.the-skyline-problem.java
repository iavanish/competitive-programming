/*
 * @lc app=leetcode id=218 lang=java
 *
 * [218] The Skyline Problem
 *
 * https://leetcode.com/problems/the-skyline-problem/description/
 *
 * algorithms
 * Hard (33.05%)
 * Likes:    1769
 * Dislikes: 98
 * Total Accepted:    120.7K
 * Total Submissions: 359.3K
 * Testcase Example:  '[[2,9,10],[3,7,15],[5,12,12],[15,20,10],[19,24,8]]'
 *
 * A city's skyline is the outer contour of the silhouette formed by all the
 * buildings in that city when viewed from a distance. Now suppose you are
 * given the locations and height of all the buildings as shown on a cityscape
 * photo (Figure A), write a program to output the skyline formed by these
 * buildings collectively (Figure B).
 * ⁠   
 * 
 * The geometric information of each building is represented by a triplet of
 * integers [Li, Ri, Hi], where Li and Ri are the x coordinates of the left and
 * right edge of the ith building, respectively, and Hi is its height. It is
 * guaranteed that 0 ≤ Li, Ri ≤ INT_MAX, 0 < Hi ≤ INT_MAX, and Ri - Li > 0. You
 * may assume all buildings are perfect rectangles grounded on an absolutely
 * flat surface at height 0.
 * 
 * For instance, the dimensions of all buildings in Figure A are recorded as: [
 * [2 9 10], [3 7 15], [5 12 12], [15 20 10], [19 24 8] ] .
 * 
 * The output is a list of "key points" (red dots in Figure B) in the format of
 * [ [x1,y1], [x2, y2], [x3, y3], ... ] that uniquely defines a skyline. A key
 * point is the left endpoint of a horizontal line segment. Note that the last
 * key point, where the rightmost building ends, is merely used to mark the
 * termination of the skyline, and always has zero height. Also, the ground in
 * between any two adjacent buildings should be considered part of the skyline
 * contour.
 * 
 * For instance, the skyline in Figure B should be represented as:[ [2 10], [3
 * 15], [7 12], [12 0], [15 10], [20 8], [24, 0] ].
 * 
 * Notes:
 * 
 * 
 * The number of buildings in any input list is guaranteed to be in the range
 * [0, 10000].
 * The input list is already sorted in ascending order by the left x position
 * Li.
 * The output list must be sorted by the x position.
 * There must be no consecutive horizontal lines of equal height in the output
 * skyline. For instance, [...[2 3], [4 5], [7 5], [11 5], [12 7]...] is not
 * acceptable; the three lines of height 5 should be merged into one in the
 * final output as such: [...[2 3], [4 5], [12 7], ...]
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

// @lc code=start
class Solution {

    public List<List<Integer>> getSkyline(int[][] buildings) {
        int n = buildings.length;
        if (n == 0) {
            return new ArrayList<>();
        }

        PriorityQueue<Building> priorityQueue = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            priorityQueue.add(new Building(buildings[i][0], buildings[i][1], buildings[i][2]));
        }

        List<Building> processedBuildings = new ArrayList<>();
        while (!priorityQueue.isEmpty()) {
            Building building1 = priorityQueue.poll();
            if (priorityQueue.isEmpty()) {
                processedBuildings.add(building1);
            }
            else {
                Building building2 = priorityQueue.poll();
                if (building1.r <= building2.l) {
                    processedBuildings.add(building1);
                    priorityQueue.add(building2);
                }
                else {
                    if (building1.h < building2.h) {
                        priorityQueue.add(new Building(building1.l, building2.l, building1.h));
                        priorityQueue.add(building2);
                        if (building2.r < building1.r) {
                            priorityQueue.add(new Building(building2.r, building1.r, building1.h));
                        }
                    }
                    else {
                        priorityQueue.add(building1);
                        if (building1.r < building2.r) {
                            priorityQueue.add(new Building(building1.r, building2.r, building2.h));
                        }
                    }
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < processedBuildings.size(); i++) {
            if (i > 0 && processedBuildings.get(i-1).r < processedBuildings.get(i).l) {
                result.add(Arrays.asList(processedBuildings.get(i-1).r, 0));
            }
            if (i == 0 || processedBuildings.get(i-1).h != processedBuildings.get(i).h) {
                result.add(Arrays.asList(processedBuildings.get(i).l, processedBuildings.get(i).h));
            }
        }
        result.add(Arrays.asList(processedBuildings.get(processedBuildings.size()-1).r, 0));

        return result;
    }

    private static class Building implements Comparable<Building> {
        public int l;
        public int r;
        public int h;
        public Building(int l, int r, int h) {
            this.l = l;
            this.r = r;
            this.h = h;
        }
        @Override
        public int compareTo(Building building) {
            if (this.l != building.l) {
                return this.l - building.l;
            }
            return building.h - this.h;
        }
    }

}
// @lc code=end
