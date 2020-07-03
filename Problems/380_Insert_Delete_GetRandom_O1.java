// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/540/week-2-june-8th-june-14th/3358/
// 380. Insert Delete GetRandom O(1)

class RandomizedSet {

    Map<Integer, Integer> hm;
    Random r;
    List<Integer> ls;

    /** Initialize your data structure here. */
    public RandomizedSet() {
        hm = new HashMap<>();
        r = new Random();
        ls = new ArrayList<>();
    }

    /**
     * Inserts a value to the set. Returns true if the set did not already contain
     * the specified element.
     */
    public boolean insert(int val) {
        if (!hm.containsKey(val)) {
            hm.put(val, ls.size());
            ls.add(val);
            return true;
        }
        return false;
    }

    /**
     * Removes a value from the set. Returns true if the set contained the specified
     * element.
     */
    public boolean remove(int val) {
        if (hm.containsKey(val)) {
            int index = hm.remove(val);
            int lastElement = ls.get(ls.size() - 1);
            if (lastElement != val) {
                ls.set(index, lastElement);
                hm.put(lastElement, index);
            }
            ls.remove(ls.size() - 1);
            return true;
        } else {
            return false;
        }
    }

    /** Get a random element from the set. */
    public int getRandom() {
        return ls.get(r.nextInt(ls.size()));
    }
}

/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet(); 
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val); 
 * int param_3 = obj.getRandom();
 */