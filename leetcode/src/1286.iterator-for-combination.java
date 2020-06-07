/*
 * @lc app=leetcode id=1286 lang=java
 *
 * [1286] Iterator for Combination
 *
 * https://leetcode.com/problems/iterator-for-combination/description/
 *
 * algorithms
 * Medium (67.17%)
 * Likes:    157
 * Dislikes: 23
 * Total Accepted:    7.9K
 * Total Submissions: 11.8K
 * Testcase Example:  '["CombinationIterator","next","hasNext","next","hasNext","next","hasNext"]\r\n' +
  '[["abc",2],[],[],[],[],[],[]]\r'
 *
 * Design an Iterator class, which has:
 * 
 * 
 * A constructor that takes a string characters of sorted distinct lowercase
 * English letters and a number combinationLength as arguments.
 * A function next() that returns the next combination of length
 * combinationLength in lexicographical order.
 * A function hasNext() that returns True if and only if there exists a next
 * combination.
 * 
 * 
 * 
 * 
 * Example:
 * 
 * 
 * CombinationIterator iterator = new CombinationIterator("abc", 2); // creates
 * the iterator.
 * 
 * iterator.next(); // returns "ab"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "ac"
 * iterator.hasNext(); // returns true
 * iterator.next(); // returns "bc"
 * iterator.hasNext(); // returns false
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= combinationLength <= characters.length <= 15
 * There will be at most 10^4 function calls per test.
 * It's guaranteed that all calls of the function next are valid.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

// @lc code=start
class CombinationIterator {

    private List<String> combinations;
    private int currIndex;

    public CombinationIterator(String characters, int combinationLength) {
        combinations = new ArrayList<>();
        currIndex = 0;

        for (int i = 0; i < (1 << characters.length()); i++) {
            StringBuilder tempCombination = new StringBuilder();
            int temp = i;
            for (int j = 0; j < characters.length() && temp > 0; j++) {
                if ((temp & 1) != 0) {
                    tempCombination.append(characters.charAt(j));
                }
                temp >>= 1;
            }
            if (tempCombination.length() == combinationLength) {
                combinations.add(tempCombination.toString());
            }
        }
        Collections.sort(combinations);
    }

    public String next() {
        return combinations.get(currIndex++);
    }

    public boolean hasNext() {
        return currIndex < combinations.size();
    }

}

/**
 * Your CombinationIterator object will be instantiated and called as such:
 * CombinationIterator obj = new CombinationIterator(characters, combinationLength);
 * String param_1 = obj.next();
 * boolean param_2 = obj.hasNext();
 */
// @lc code=end
