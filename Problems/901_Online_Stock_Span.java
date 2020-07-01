// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/536/week-3-may-15th-may-21st/3334/
// 901. Online Stock Span

class StockSpanner {

    Stack<int[]> st;

    public StockSpanner() {
        st = new Stack<>();
    }

    public int next(int price) {
        int res = 1;
        while (!st.isEmpty() && st.peek()[1] <= price) {
            res += st.pop()[0];
        }
        st.add(new int[] { res, price });
        return res;
    }
}

/**
 * Your StockSpanner object will be instantiated and called as such:
 * StockSpanner obj = new StockSpanner(); 
 * int param_1 = obj.next(price);
 */