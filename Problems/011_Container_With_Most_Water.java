class Solution {
    public int maxArea(int[] height) {
        int max = 0;
        int l = 0, r = height.length - 1;
        while (l < r) {
            if (height[l] <= height[r]) {
                if (max < height[l] * (r - l)) {
                    max = height[l] * (r - l);
                }
                l = l + 1;
            } else {
                if (max < height[r] * (r - l)) {
                    max = height[r] * (r - l);
                }
                r = r - 1;
            }
        }
        return max;
    }
}