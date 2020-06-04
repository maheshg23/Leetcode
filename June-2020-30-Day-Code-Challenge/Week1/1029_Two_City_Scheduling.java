// https://leetcode.com/explore/featured/card/june-leetcoding-challenge/539/week-1-june-1st-june-7th/3349/
// 1029 https://leetcode.com/problems/two-city-scheduling/

class Solution {
    public int twoCitySchedCost(int[][] costs) {

        Arrays.sort(costs, (a, b) -> {
            return (a[0] - a[1]) - (b[0] - b[1]);
        });

        int sum = 0;
        int n = costs.length / 2;
        for (int i = 0; i < n; i++) {
            sum += costs[i][0] + costs[i + n][1];
        }
        return sum;
    }
}