/*
 * @lc app=leetcode id=1086 lang=java
 *
 * [1086] High Five
 *
 * https://leetcode.com/problems/high-five/description/
 *
 * algorithms
 * Easy (76.29%)
 * Likes:    123
 * Dislikes: 28
 * Total Accepted:    15.7K
 * Total Submissions: 20.4K
 * Testcase Example:  '[[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]'
 *
 * Given a list of scores of different students, return the average score of
 * each student's top five scores in the order of each student's id.
 * 
 * Each entry items[i] has items[i][0] the student's id, and items[i][1] the
 * student's score.  The average score is calculated using integer
 * division.
 * 
 * 
 * 
 * Example 1:
 * 
 * 
 * Input:
 * [[1,91],[1,92],[2,93],[2,97],[1,60],[2,77],[1,65],[1,87],[1,100],[2,100],[2,76]]
 * Output: [[1,87],[2,88]]
 * Explanation: 
 * The average of the student with id = 1 is 87.
 * The average of the student with id = 2 is 88.6. But with integer division
 * their average converts to 88.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * 
 * 1 <= items.length <= 1000
 * items[i].length == 2
 * The IDs of the students is between 1 to 1000
 * The score of the students is between 1 to 100
 * For each student, there are at least 5 scores
 * 
 */

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

// @lc code=start
class Solution {

    public int[][] highFive(int[][] items) {
        List<PriorityQueue<Integer>> scores = new ArrayList<>();
        for(int i = 0; i <= 1000; i++) {
            scores.add(new PriorityQueue<>());
        }

        int count = 0;
        for(int[] item : items) {
            scores.get(item[0]).add(item[1]);
            if(scores.get(item[0]).size() > 5) {
                scores.get(item[0]).poll();
            }
            if(scores.get(item[0]).size() == 1) {
                count++;
            }
        }

        int[][] result = new int[count][2];
        for(int i = 0, j = 0; i < 1000; i++) {
            if(!scores.get(i).isEmpty()) {
                int sum = 0;
                int n = scores.get(i).size();
                while(!scores.get(i).isEmpty()) {
                    sum += scores.get(i).poll();
                }
                result[j][0] = i;
                result[j++][1] = sum / n;
            }
        }

        return result;
    }

}
// @lc code=end
