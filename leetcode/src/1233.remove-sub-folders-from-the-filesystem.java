/*
 * @lc app=leetcode id=1233 lang=java
 *
 * [1233] Remove Sub-Folders from the Filesystem
 *
 * https://leetcode.com/problems/remove-sub-folders-from-the-filesystem/description/
 *
 * algorithms
 * Medium (57.82%)
 * Likes:    170
 * Dislikes: 34
 * Total Accepted:    14.6K
 * Total Submissions: 25.3K
 * Testcase Example:  '["/a","/a/b","/c/d","/c/d/e","/c/f"]'
 *
 * Given a list of folders, remove all sub-folders in those folders and return
 * in any order the folders after removing.
 *
 * If a folder[i] is located within another folder[j], it is called a
 * sub-folder of it.
 *
 * The format of a path is one or more concatenated strings of the form: /
 * followed by one or more lowercase English letters. For example, /leetcode
 * and /leetcode/problems are valid paths while an empty string and / are
 * not.
 *
 *
 * Example 1:
 *
 *
 * Input: folder = ["/a","/a/b","/c/d","/c/d/e","/c/f"]
 * Output: ["/a","/c/d","/c/f"]
 * Explanation: Folders "/a/b/" is a subfolder of "/a" and "/c/d/e" is inside
 * of folder "/c/d" in our filesystem.
 *
 *
 * Example 2:
 *
 *
 * Input: folder = ["/a","/a/b/c","/a/b/d"]
 * Output: ["/a"]
 * Explanation: Folders "/a/b/c" and "/a/b/d/" will be removed because they are
 * subfolders of "/a".
 *
 *
 * Example 3:
 *
 *
 * Input: folder = ["/a/b/c","/a/b/ca","/a/b/d"]
 * Output: ["/a/b/c","/a/b/ca","/a/b/d"]
 *
 *
 *
 * Constraints:
 *
 *
 * 1 <= folder.length <= 4 * 10^4
 * 2 <= folder[i].length <= 100
 * folder[i] contains only lowercase letters and '/'
 * folder[i] always starts with character '/'
 * Each folder name is unique.
 *
 *
 */

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// @lc code=start
class Solution {

    public List<String> removeSubfolders(String[] folder) {
        Trie trie = new Trie();
        for (String f : folder) {
            String[] split = f.split("/");
            Trie temp = trie;
            for (String s : split) {
                temp = temp.insert(s);
            }
            temp.terminatedDirectory = f;
        }

        List<String> result = new ArrayList<>();
        traverseTrie(trie, result);
        return result;
    }

    private void traverseTrie(Trie trie, List<String> result) {
        if (trie.terminatedDirectory != null) {
            result.add(trie.terminatedDirectory);
        }
        else {
            for (Map.Entry<String, Trie> node : trie.node.entrySet()) {
                traverseTrie(node.getValue(), result);
            }
        }
    }

    private static class Trie {

        public Map<String, Trie> node;
        public String terminatedDirectory;

        public Trie() {
            node = new HashMap<>();
            terminatedDirectory = null;
        }

        public Trie insert(String s) {
            if (node.containsKey(s)) {
                return node.get(s);
            }
            Trie child = new Trie();
            node.put(s, child);
            return child;
        }

    }

}
// @lc code=end
