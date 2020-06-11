/*
 * @lc app=leetcode id=127 lang=java
 *
 * [127] Word Ladder
 *
 * https://leetcode.com/problems/word-ladder/description/
 *
 * algorithms
 * Medium (26.87%)
 * Likes:    2603
 * Dislikes: 1036
 * Total Accepted:    378.2K
 * Total Submissions: 1.3M
 * Testcase Example:  '"hit"\n"cog"\n["hot","dot","dog","lot","log","cog"]'
 *
 * Given two words (beginWord and endWord), and a dictionary's word list, find
 * the length of shortest transformation sequence from beginWord to endWord,
 * such that:
 *
 *
 * Only one letter can be changed at a time.
 * Each transformed word must exist in the word list. Note that beginWord is
 * not a transformed word.
 *
 *
 * Note:
 *
 *
 * Return 0 if there is no such transformation sequence.
 * All words have the same length.
 * All words contain only lowercase alphabetic characters.
 * You may assume no duplicates in the word list.
 * You may assume beginWord and endWord are non-empty and are not the same.
 *
 *
 * Example 1:
 *
 *
 * Input:
 * beginWord = "hit",
 * endWord = "cog",
 * wordList = ["hot","dot","dog","lot","log","cog"]
 *
 * Output: 5
 *
 * Explanation: As one shortest transformation is "hit" -> "hot" -> "dot" ->
 * "dog" -> "cog",
 * return its length 5.
 *
 *
 * Example 2:
 *
 *
 * Input:
 * beginWord = "hit"
 * endWord = "cog"
 * wordList = ["hot","dot","dog","lot","log"]
 *
 * Output: 0
 *
 * Explanation: The endWord "cog" is not in wordList, therefore no possible
 * transformation.
 *
 *
 *
 *
 *
 */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

// @lc code=start
class Solution {

    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if (beginWord.equals(endWord)) {
            return 1;
        }
        Set<String> wordSet = new HashSet<>(wordList);
        if (!wordSet.contains(endWord)) {
            return 0;
        }
        wordSet.remove(beginWord);
        wordSet.remove(endWord);
        wordList = new ArrayList<>(wordSet);
        wordList.add(beginWord);
        wordList.add(endWord);

        List<List<Integer>> graph = new ArrayList<>();
        for (int i = 0; i < wordList.size(); i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < wordList.size(); i++) {
            for (int j = i + 1; j < wordList.size(); j++) {
                int countDiff = 0;
                for (int k = 0; k < wordList.get(i).length() && countDiff <= 1; k++) {
                    if (wordList.get(i).charAt(k) != wordList.get(j).charAt(k)) {
                        countDiff++;
                    }
                }
                if (countDiff == 1) {
                    graph.get(i).add(j);
                    graph.get(j).add(i);
                }
            }
        }

        boolean[] isVisited = new boolean[wordList.size()];
        Queue<Integer> queueNode = new LinkedList<>();
        Queue<Integer> queueLength = new LinkedList<>();
        isVisited[wordList.size() - 1] = true;
        queueNode.offer(wordList.size() - 1);
        queueLength.offer(1);
        while (!queueNode.isEmpty()) {
            int frontNode = queueNode.poll();
            int frontLength = queueLength.poll();
            for (Integer neighbour : graph.get(frontNode)) {
                if (!isVisited[neighbour]) {
                    if (neighbour == wordList.size() - 2) {
                        return 1 + frontLength;
                    }
                    isVisited[neighbour] = true;
                    queueNode.offer(neighbour);
                    queueLength.offer(1 + frontLength);
                }
            }
        }

        return 0;
    }

}
// @lc code=end
