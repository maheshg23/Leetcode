// 56. Merge Intervals

class Solution {
    public int[][] merge(int[][] intervals) {
        if (intervals.length <= 1)
            return intervals;
        List<int[]> list = new ArrayList<>();

        Arrays.sort(intervals, ((a, b) -> a[0] - b[0]));

        list.add(intervals[0]);
        for (int i = 1; i < intervals.length; i++) {
            int[] prev = list.get(list.size() - 1);
            if (list.isEmpty() || intervals[i][0] > prev[1]) {
                list.add(intervals[i]);
            } else {
                prev[1] = Math.max(prev[1], intervals[i][1]);
            }
        }
        return list.toArray(new int[list.size()][]);
    }
}