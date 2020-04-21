/*
 * @lc app=leetcode id=307 lang=java
 *
 * [307] Range Sum Query - Mutable
 *
 * https://leetcode.com/problems/range-sum-query-mutable/description/
 *
 * algorithms
 * Medium (31.50%)
 * Likes:    1098
 * Dislikes: 73
 * Total Accepted:    96.4K
 * Total Submissions: 294.8K
 * Testcase Example:  '["NumArray","sumRange","update","sumRange"]\n[[[1,3,5]],[0,2],[1,2],[0,2]]'
 *
 * Given an integer array nums, find the sum of the elements between indices i
 * and j (i ≤ j), inclusive.
 * 
 * The update(i, val) function modifies nums by updating the element at index i
 * to val.
 * 
 * Example:
 * 
 * 
 * Given nums = [1, 3, 5]
 * 
 * sumRange(0, 2) -> 9
 * update(1, 2)
 * sumRange(0, 2) -> 8
 * 
 * 
 * Note:
 * 
 * 
 * The array is only modifiable by the update function.
 * You may assume the number of calls to update and sumRange function is
 * distributed evenly.
 * 
 * 
 */

// @lc code=start
class NumArray {

    private int[] segmentTree;
    private int n;

    public NumArray(int[] nums) {
        n = nums.length;
        segmentTree = new int[3 * n];
        buildTree(segmentTree, 0, 0, n-1, nums);
    }
    
    public void update(int i, int val) {
        updateTree(segmentTree, 0, 0, n-1, i, val);
    }
    
    public int sumRange(int i, int j) {
        return queryTree(segmentTree, 0, 0, n-1, i, j);
    }

    private void buildTree(int[] segmentTree, int node, int left, int right, int[] nums) {
        if (left == right) {
            segmentTree[node] = nums[left];
        }
        else if (left < right) {
            int middle = middle(left, right);
            buildTree(segmentTree, node * 2 + 1, left, middle, nums);
            buildTree(segmentTree, node * 2 + 2, middle + 1, right, nums);
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }
    }

    private void updateTree(int[] segmentTree, int node, int left, int right, int index, int value) {
        if (left == right && left == index) {
            segmentTree[node] = value;
        }
        else if (left <= index && index <= right) {
            int middle = middle(left, right);
            updateTree(segmentTree, node * 2 + 1, left, middle, index, value);
            updateTree(segmentTree, node * 2 + 2, middle + 1, right, index, value);
            segmentTree[node] = segmentTree[node * 2 + 1] + segmentTree[node * 2 + 2];
        }
    }

    private int queryTree(int[] segmentTree, int node, int left, int right, int queryI, int queryJ) {
        if (right < left || queryJ < left || right < queryI) {
            return 0;
        }
        else if (queryI <= left && right <= queryJ) {
            return segmentTree[node];
        }
        int middle = middle(left, right);
        return queryTree(segmentTree, node * 2 + 1, left, middle, queryI, queryJ) +
                queryTree(segmentTree, node * 2 + 2, middle + 1, right, queryI, queryJ);
    }

    private int middle(int left, int right) {
        return left + (right - left) / 2;
    }

}

/**
 * Your NumArray object will be instantiated and called as such:
 * NumArray obj = new NumArray(nums);
 * obj.update(i,val);
 * int param_2 = obj.sumRange(i,j);
 */
// @lc code=end
