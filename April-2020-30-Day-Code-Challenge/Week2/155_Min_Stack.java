// https://leetcode.com/explore/challenge/card/30-day-leetcoding-challenge/529/week-2/3292/
// 155 https://leetcode.com/problems/min-stack/

// ArrayList Implementation and custom function for the Min
class MinStack {

    List<Integer> list;
    int top;
    int min;

    /** initialize your data structure here. */
    public MinStack() {
        this.list = new ArrayList<>();
        this.top = -1;
        this.min = Integer.MAX_VALUE;
    }

    public void recalculate() {
        this.min = Integer.MAX_VALUE;
        for (int i = 0; i < this.list.size(); i++) {
            this.min = this.list.get(i) < this.min ? this.list.get(i) : this.min;
        }
    }

    public void push(int x) {
        this.list.add(x);
        if (x < this.min)
            this.min = x;
    }

    public void pop() {
        int remove = this.list.remove(this.list.size() - 1);
        if (remove == this.min)
            this.recalculate();
    }

    public int top() {
        return this.list.get(this.list.size() - 1);
    }

    public int getMin() {
        return this.min;
    }
}

// ArrayList Implementation with Priority Queue for the Min value
class MinStack {

    List<Integer> list;
    int top;
    PriorityQueue<Integer> pq;

    /** initialize your data structure here. */
    public MinStack() {
        this.list = new ArrayList<>();
        this.top = -1;
        this.pq = new PriorityQueue<>();
    }

    public void push(int x) {
        this.list.add(x);
        if (pq.isEmpty())
            this.pq.add(x);
        else if (x <= this.pq.peek())
            this.pq.add(x);
    }

    public void pop() {
        int remove = this.list.remove(this.list.size() - 1);
        if (remove == this.pq.peek())
            this.pq.poll();
    }

    public int top() {
        return this.list.get(this.list.size() - 1);
    }

    public int getMin() {
        return this.pq.peek();
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.getMin();
 */