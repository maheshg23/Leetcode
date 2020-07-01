// https://leetcode.com/explore/challenge/card/may-leetcoding-challenge/535/week-2-may-8th-may-14th/3326/
// 733. Flood Fill

class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int prevColor = image[sr][sc];
        imageColor(image, sr, sc, prevColor, newColor);
        return image;
    }

    public void imageColor(int[][] image, int r, int c, int prevColor, int newColor) {
        if (r < 0 || r >= image.length || c < 0 || c >= image[0].length)
            return;
        if (prevColor != image[r][c] || prevColor == newColor) {
            return;
        }
        image[r][c] = newColor;
        imageColor(image, r + 1, c, prevColor, newColor);
        imageColor(image, r - 1, c, prevColor, newColor);
        imageColor(image, r, c + 1, prevColor, newColor);
        imageColor(image, r, c - 1, prevColor, newColor);
    }
}