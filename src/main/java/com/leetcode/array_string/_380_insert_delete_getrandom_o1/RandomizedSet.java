package com.leetcode.array_string._380_insert_delete_getrandom_o1;

import java.util.*;

/**
 * <h1>380. Insert Delete GetRandom O(1)</h1><br>
 * Implement the RandomizedSet class:<br>
 *<br>
 * RandomizedSet() Initializes the RandomizedSet object.<br>
 * bool insert(int val) Inserts an item val into the set if not present. Returns true if the item was not present, false otherwise.<br>
 * bool remove(int val) Removes an item val from the set if present. Returns true if the item was present, false otherwise.<br>
 * int getRandom() Returns a random element from the current set of elements (it's guaranteed that at least one element exists when this method is called). Each element must have the same probability of being returned.<br>
 * You must implement the functions of the class such that each function works in average O(1) time complexity.<br>
 *<br>
 * Example 1:<br>
 * Input<br>
 * ["RandomizedSet", "insert", "remove", "insert", "getRandom", "remove", "insert", "getRandom"]<br>
 * [[], [1], [2], [2], [], [1], [2], []]<br>
 * Output<br>
 * [null, true, false, true, 2, true, false, 2]<br>
 *<br>
 * Explanation<br>
 * RandomizedSet randomizedSet = new RandomizedSet();<br>
 * randomizedSet.insert(1); // Inserts 1 to the set. Returns true as 1 was inserted successfully.<br>
 * randomizedSet.remove(2); // Returns false as 2 does not exist in the set.<br>
 * randomizedSet.insert(2); // Inserts 2 to the set, returns true. Set now contains [1,2].<br>
 * randomizedSet.getRandom(); // getRandom() should return either 1 or 2 randomly.<br>
 * randomizedSet.remove(1); // Removes 1 from the set, returns true. Set now contains [2].<br>
 * randomizedSet.insert(2); // 2 was already in the set, so return false.<br>
 * randomizedSet.getRandom(); // Since 2 is the only number in the set, getRandom() will always return 2.<br>
 *<br>
 * Constraints:<br>
 * -2^31 <= val <= 2^31 - 1<br>
 * At most 2 * 10^5 calls will be made to insert, remove, and getRandom.<br>
 * There will be at least one element in the data structure when getRandom is called.<br>
 */
public class RandomizedSet {

    private final Map<Integer, Integer> map;
    private final List<Integer> list;
    private final Random random;

    public RandomizedSet() {
        this.map = new HashMap<>();
        this.list = new ArrayList<>();
        this.random = new Random();
    }

    public boolean insert(int val) {
        if (!map.containsKey(val)) {
            list.add(val);
            map.put(val, list.size() - 1);
            return true;
        }
        return false;
    }

    public boolean remove(int val) {
        var index = map.get(val);
        if (index == null) {
            return false;
        }
        map.remove(val);
        var last = list.remove(list.size() - 1);
        if (!list.isEmpty() && !last.equals(val)) {
            list.set(index, last);
            map.put(last, index);
        }
        return true;
    }

    public int getRandom() {
        return list.get(random.nextInt(list.size()));
    }

    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.insert(3));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(1));
        System.out.println(randomizedSet.remove(3));
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.getRandom());
        System.out.println(randomizedSet.insert(0));
        System.out.println(randomizedSet.remove(0));
    }
}
