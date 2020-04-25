/*
 * @lc app=leetcode id=1418 lang=java
 *
 * [1418] Display Table of Food Orders in a Restaurant
 *
 * https://leetcode.com/problems/display-table-of-food-orders-in-a-restaurant/description/
 *
 * algorithms
 * Medium (62.24%)
 * Likes:    24
 * Dislikes: 102
 * Total Accepted:    7.3K
 * Total Submissions: 11.8K
 * Testcase Example:  '[["David","3","Ceviche"],["Corina","10","Beef Burrito"],["David","3","Fried Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]'
 *
 * Given the array orders, which represents the orders that customers have done
 * in a restaurant. More specifically
 * orders[i]=[customerNamei,tableNumberi,foodItemi] where customerNamei is the
 * name of the customer, tableNumberi is the table customer sit at, and
 * foodItemi is the item customer orders.
 * 
 * Return the restaurant's “display table”. The “display table” is a table
 * whose row entries denote how many of each food item each table ordered. The
 * first column is the table number and the remaining columns correspond to
 * each food item in alphabetical order. The first row should be a header whose
 * first column is “Table”, followed by the names of the food items. Note that
 * the customer names are not part of the table. Additionally, the rows should
 * be sorted in numerically increasing order.
 * 
 * 
 * Example 1:
 * 
 * 
 * Input: orders = [["David","3","Ceviche"],["Corina","10","Beef
 * Burrito"],["David","3","Fried
 * Chicken"],["Carla","5","Water"],["Carla","5","Ceviche"],["Rous","3","Ceviche"]]
 * Output: [["Table","Beef Burrito","Ceviche","Fried
 * Chicken","Water"],["3","0","2","1","0"],["5","0","1","0","1"],["10","1","0","0","0"]] 
 * Explanation:
 * The displaying table looks like:
 * Table,Beef Burrito,Ceviche,Fried Chicken,Water
 * 3    ,0           ,2      ,1            ,0
 * 5    ,0           ,1      ,0            ,1
 * 10   ,1           ,0      ,0            ,0
 * For the table 3: David orders "Ceviche" and "Fried Chicken", and Rous orders
 * "Ceviche".
 * For the table 5: Carla orders "Water" and "Ceviche".
 * For the table 10: Corina orders "Beef Burrito". 
 * 
 * 
 * Example 2:
 * 
 * 
 * Input: orders = [["James","12","Fried Chicken"],["Ratesh","12","Fried
 * Chicken"],["Amadeus","12","Fried Chicken"],["Adam","1","Canadian
 * Waffles"],["Brianna","1","Canadian Waffles"]]
 * Output: [["Table","Canadian Waffles","Fried
 * Chicken"],["1","2","0"],["12","0","3"]] 
 * Explanation: 
 * For the table 1: Adam and Brianna order "Canadian Waffles".
 * For the table 12: James, Ratesh and Amadeus order "Fried Chicken".
 * 
 * 
 * Example 3:
 * 
 * 
 * Input: orders = [["Laura","2","Bean Burrito"],["Jhon","2","Beef
 * Burrito"],["Melissa","2","Soda"]]
 * Output: [["Table","Bean Burrito","Beef
 * Burrito","Soda"],["2","1","1","1"]]
 * 
 * 
 * 
 * Constraints:
 * 
 * 
 * 1 <= orders.length <= 5 * 10^4
 * orders[i].length == 3
 * 1 <= customerNamei.length, foodItemi.length <= 20
 * customerNamei and foodItemi consist of lowercase and uppercase English
 * letters and the space character.
 * tableNumberi is a valid integer between 1 and 500.
 * 
 * 
 */

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.TreeMap;

// @lc code=start
class Solution {

    public List<List<String>> displayTable(List<List<String>> orders) {
        Map<Integer, Map<String, Integer>> displayTable = new TreeMap<>();
        Set<String> foodItems = new HashSet<>();
        for (List<String> order : orders) {
            int tableNumber = Integer.parseInt(order.get(1));
            String foodItem = order.get(2);
            foodItems.add(foodItem);

            Map<String, Integer> table = displayTable.getOrDefault(tableNumber, new HashMap<>());
            table.put(foodItem, table.getOrDefault(foodItem, 0) + 1);

            displayTable.put(tableNumber, table);
        }

        List<List<String>> result = new ArrayList<>();
        List<String> sortedFoodItems = new ArrayList<>(foodItems);
        Collections.sort(sortedFoodItems);
        sortedFoodItems.add(0, "Table");
        result.add(sortedFoodItems);

        for (Map.Entry<Integer, Map<String, Integer>> entry : displayTable.entrySet()) {
            List<String> temp = new ArrayList<>();
            temp.add(String.valueOf(entry.getKey()));
            for (int i = 1; i < sortedFoodItems.size(); i++) {
                temp.add(String.valueOf(entry.getValue().getOrDefault(sortedFoodItems.get(i), 0)));
            }
            result.add(temp);
        }

        return result;
    }

}
// @lc code=end
