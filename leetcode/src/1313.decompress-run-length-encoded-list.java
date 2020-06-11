/*
 * @lc app=leetcode id=1313 lang=java
 *
 * [1313] Decompress Run-Length Encoded List
 *
 * https://leetcode.com/problems/decompress-run-length-encoded-list/description/
 *
 * algorithms
 * Easy (85.2%)
 * Likes:    42
 * Dislikes: 174
 * Total Accepted:    9.7K
 * Total Submissions: 11.4K
 * Testcase Example:  '[1,2,3,4]'
 *
 * We are given a list nums of integers representing a list compressed with run-length encoding.
 * Consider each adjacent pair of elements [a, b] = [nums[2*i], nums[2*i+1]] (with i >= 0).
 * For each such pair, there are a elements with value b in the decompressed list.
 * Return the decompressed list.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: nums = [1,2,3,4]
 * Output: [2,4,4,4]
 * Explanation: The first pair [1,2] means we have freq = 1 and val = 2 so we generate the array [2].
 * The second pair [3,4] means we have freq = 3 and val = 4 so we generate [4,4,4].
 * At the end the concatenation [2] + [4,4,4,4] is [2,4,4,4].
 *
 *
 *
 *
 *
 * Constraints:
 * 2 <= nums.length <= 100
 * nums.length % 2 == 0
 * 1 <= nums[i] <= 100
 *
 */

import java.util.ArrayList;
import java.util.List;

// @lc code=start
class Solution {

    public int[] decompressRLElist(int[] nums) {
        List<Integer> decompressedList = new ArrayList<>();
        for (int i = 0; i < nums.length; i += 2) {
            for (int j = 0; j < nums[i]; j++) {
                decompressedList.add(nums[i + 1]);
            }
        }

        int[] result = new int[decompressedList.size()];
        for (int i = 0; i < decompressedList.size(); i++) {
            result[i] = decompressedList.get(i);
        }
        return result;
    }

}
// @lc code=end
