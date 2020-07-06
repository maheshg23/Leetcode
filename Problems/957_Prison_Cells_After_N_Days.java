// https://leetcode.com/explore/challenge/card/july-leetcoding-challenge/544/week-1-july-1st-july-7th/3379/
// 957. Prison Cells After N Days

// 11ms
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        Map<String, Integer> hm = new HashMap<>();

        for (int i = 0; i < N; i++) {
            String str = Arrays.toString(cells);
            if (hm.containsKey(str)) {
                int length = i - hm.get(str);
                int rem = (N - i) % length;
                return prisonAfterNDays(cells, rem);
            } else {
                hm.put(str, i);
                int prev = cells[0];
                for (int j = 1; j < 7; j++) {
                    int curr = cells[j];
                    cells[j] = prev == cells[j + 1] ? 1 : 0;
                    prev = curr;
                }
            }
            cells[0] = 0;
            cells[7] = 0;
        }
        return cells;
    }
}

// 4ms
class Solution {
    public int[] prisonAfterNDays(int[] cells, int N) {
        if (N == 0 || cells.length == 0)
            return new int[0];
        Map<String, Integer> seen = new HashMap<>();
        while (N > 0) {
            int[] nextDay = new int[cells.length];
            String cellString = Arrays.toString(cells);
            seen.put(cellString, N--);
            for (int i = 1; i < cells.length - 1; i++) {
                if (cells[i - 1] == cells[i + 1])
                    nextDay[i] = 1;
            }
            if (seen.containsKey(Arrays.toString(nextDay))) {
                int repeatDay = seen.get(Arrays.toString(nextDay));
                N = N % (repeatDay - N);
            }
            cells = nextDay;
        }
        return cells;
    }
}