// https://leetcode.com/explore/challenge/card/june-leetcoding-challenge/542/week-4-june-22nd-june-28th/3374/
// 332. Reconstruct Itinerary

class Solution {
    public List<String> findItinerary(List<List<String>> tickets) {

        List<String> res = new ArrayList<String>();
        if (tickets == null || tickets.size() == 0)
            return res;

        Map<String, List<String>> hm = new HashMap<>();
        for (List<String> s : tickets) {
            if (!hm.containsKey(s.get(0))) {
                hm.put(s.get(0), new ArrayList<String>());
            }
            hm.get(s.get(0)).add(s.get(1));
        }
        // hm.entrySet().forEach(entry->{
        // System.out.println(entry.getKey() + " " + entry.getValue());
        // });

        Stack<String> st = new Stack<>();
        st.push("JFK");
        while (!st.isEmpty()) {
            while (hm.containsKey(st.peek()) && !hm.get(st.peek()).isEmpty()) {
                List<String> ls = hm.get(st.peek());
                String s = st.peek();
                Collections.sort(ls);
                st.push(ls.get(0));
                ls.remove(ls.get(0));
                hm.put(s, ls);
            }
            res.add(0, st.pop());
        }
        return res;
    }
}