/*
 * @lc app=leetcode id=118 lang=java
 *
 * [118] Pascal's Triangle
 *
 * https://leetcode.com/problems/pascals-triangle/description/
 *
 * algorithms
 * Easy (51.64%)
 * Likes:    1372
 * Dislikes: 106
 * Total Accepted:    371.1K
 * Total Submissions: 718.4K
 * Testcase Example:  '5'
 *
 * Given a non-negative integer numRows, generate the first numRows of Pascal's
 * triangle.
 *
 *
 * In Pascal's triangle, each number is the sum of the two numbers directly
 * above it.
 *
 * Example:
 *
 *
 * Input: 5
 * Output:
 * [
 * ⁠    [1],
 * ⁠   [1,1],
 * ⁠  [1,2,1],
 * ⁠ [1,3,3,1],
 * ⁠[1,4,6,4,1]
 * ]
 *
 *
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
class Solution {

    public List<List<Integer>> generate(int numRows) {
        if (numRows == 0) {
            return new ArrayList<>();
        }
        List<List<Integer>> pascalsTriangle = new ArrayList<>();
        pascalsTriangle.add(Collections.singletonList(1));
        for (int i = 1; i < numRows; i++) {
            List<Integer> temp = new ArrayList<>();
            temp.add(pascalsTriangle.get(i - 1).get(0));
            for (int j = 1; j < pascalsTriangle.get(i - 1).size(); j++) {
                temp.add(pascalsTriangle.get(i - 1).get(j - 1) + pascalsTriangle.get(i - 1).get(j));
            }
            temp.add(pascalsTriangle.get(i - 1).get(pascalsTriangle.get(i - 1).size() - 1));
            pascalsTriangle.add(temp);
        }

        return pascalsTriangle;
    }

}
// @lc code=end
