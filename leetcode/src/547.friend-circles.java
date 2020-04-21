/*
 * @lc app=leetcode id=547 lang=java
 *
 * [547] Friend Circles
 *
 * https://leetcode.com/problems/friend-circles/description/
 *
 * algorithms
 * Medium (56.22%)
 * Likes:    1565
 * Dislikes: 123
 * Total Accepted:    141.1K
 * Total Submissions: 247.2K
 * Testcase Example:  '[[1,1,0],[1,1,0],[0,0,1]]'
 *
 * 
 * There are N students in a class. Some of them are friends, while some are
 * not. Their friendship is transitive in nature. For example, if A is a direct
 * friend of B, and B is a direct friend of C, then A is an indirect friend of
 * C. And we defined a friend circle is a group of students who are direct or
 * indirect friends.
 * 
 * 
 * 
 * Given a N*N matrix M representing the friend relationship between students
 * in the class. If M[i][j] = 1, then the ith and jth students are direct
 * friends with each other, otherwise not. And you have to output the total
 * number of friend circles among all the students.
 * 
 * 
 * Example 1:
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,0],
 * ⁠[0,0,1]]
 * Output: 2
 * Explanation:The 0th and 1st students are direct friends, so they are in a
 * friend circle. The 2nd student himself is in a friend circle. So return
 * 2.
 * 
 * 
 * 
 * Example 2:
 * 
 * Input: 
 * [[1,1,0],
 * ⁠[1,1,1],
 * ⁠[0,1,1]]
 * Output: 1
 * Explanation:The 0th and 1st students are direct friends, the 1st and 2nd
 * students are direct friends, so the 0th and 2nd students are indirect
 * friends. All of them are in the same friend circle, so return 1.
 * 
 * 
 * 
 * 
 * Note:
 * 
 * N is in range [1,200].
 * M[i][i] = 1 for all students.
 * If M[i][j] = 1, then M[j][i] = 1.
 * 
 * 
 */

// @lc code=start
class Solution {

    public int findCircleNum(int[][] M) {
        int n = M.length;
        int[] parent = new int[n];
        int[] size = new int[n];
        for (int i = 0; i < n; i++) {
            parent[i] = i;
            size[i] = 1;
        }

        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                if (M[i][j] == 1) {
                    union(parent, size, i, j);
                }
            }
        }

        int noOfComponents = 0;
        for (int i = 0; i < n; i++) {
            if (i == parent[i]) {
                noOfComponents++;
            }
        }
        return noOfComponents;
    }

    private int findParent(int[] parent, int i) {
        while (parent[i] != i) {
            parent[i] = parent[parent[i]];
            i = parent[parent[i]];
        }
        return i;
    }

    private void union(int[] parent, int[] size, int i, int j) {
        int parentI = findParent(parent, i);
        int parentJ = findParent(parent, j);
        if (parentI == parentJ) {
            return;
        }
        if (size[parentI] < size[parentJ]) {
            parent[parentI] = parentJ;
            size[parentJ] += size[parentI];
        }
        else {
            parent[parentJ] = parentI;
            size[parentI] += size[parentJ];
        }
    }

}
// @lc code=end
