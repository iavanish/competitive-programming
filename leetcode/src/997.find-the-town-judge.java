/*
 * @lc app=leetcode id=997 lang=java
 *
 * [997] Find the Town Judge
 *
 * https://leetcode.com/problems/find-the-town-judge/description/
 *
 * algorithms
 * Easy (50.11%)
 * Likes:    602
 * Dislikes: 66
 * Total Accepted:    76.5K
 * Total Submissions: 151.7K
 * Testcase Example:  '2\n[[1,2]]'
 *
 * In a town, there are N people labelled from 1 to N.  There is a rumor that
 * one of these people is secretly the town judge.
 *
 * If the town judge exists, then:
 *
 *
 * The town judge trusts nobody.
 * Everybody (except for the town judge) trusts the town judge.
 * There is exactly one person that satisfies properties 1 and 2.
 *
 *
 * You are given trust, an array of pairs trust[i] = [a, b] representing that
 * the person labelled a trusts the person labelled b.
 *
 * If the town judge exists and can be identified, return the label of the town
 * judge.  Otherwise, return -1.
 *
 *
 *
 * Example 1:
 *
 *
 * Input: N = 2, trust = [[1,2]]
 * Output: 2
 *
 *
 *
 * Example 2:
 *
 *
 * Input: N = 3, trust = [[1,3],[2,3]]
 * Output: 3
 *
 *
 *
 * Example 3:
 *
 *
 * Input: N = 3, trust = [[1,3],[2,3],[3,1]]
 * Output: -1
 *
 *
 *
 * Example 4:
 *
 *
 * Input: N = 3, trust = [[1,2],[2,3]]
 * Output: -1
 *
 *
 *
 * Example 5:
 *
 *
 * Input: N = 4, trust = [[1,3],[1,4],[2,3],[2,4],[4,3]]
 * Output: 3
 *
 *
 *
 *
 *
 *
 *
 * Note:
 *
 *
 * 1 <= N <= 1000
 * trust.length <= 10000
 * trust[i] are all different
 * trust[i][0] != trust[i][1]
 * 1 <= trust[i][0], trust[i][1] <= N
 *
 *
 */

import java.util.HashSet;
import java.util.Set;

// @lc code=start
class Solution {

    public int findJudge(int N, int[][] trust) {
        Set<Integer> allN = new HashSet<>();
        for (int i = 1; i <= N; i++) {
            allN.add(i);
        }
        int[] countTrustees = new int[N + 1];

        for (int[] t : trust) {
            allN.remove(t[0]);
            countTrustees[t[1]]++;
        }

        if (allN.size() == 1 && countTrustees[allN.iterator().next()] == N - 1) {
            return allN.iterator().next();
        }
        return -1;
    }

}
// @lc code=end
