class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int res = numBottles;
        while (numBottles >= numExchange) {
            res += (numBottles / numExchange);
            numBottles = (numBottles / numExchange) + (numBottles % numExchange);
        }
        return res;
    }
}

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {

        int m = numBottles;
        int n = numExchange;
        int res = m;
        while (m > n) {
            res += (m / n);
            m = (m / n) + (m % n);
            // System.out.println("res " + res + " m "+m);
        }
        return res + m / n;
    }
}