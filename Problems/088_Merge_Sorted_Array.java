// 88. Merge Sorted Array

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int t1 = m - 1, t2 = n - 1, k = m + n - 1;

        while (t1 >= 0 && t2 >= 0) {
            nums1[k--] = nums1[t1] > nums2[t2] ? nums1[t1--] : nums2[t2--];
        }
        while (t2 >= 0) {
            nums1[k--] = nums2[t2--];
        }
    }
}

class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0)
            return;
        int[] res = new int[m + n];
        int i = 0, j = 0;
        for (int k = 0; k < m + n; k++) {
            if (j < n && nums1[i] > nums2[j]) {
                res[k] = nums2[j];
                j++;
            } else if (i < m && j < n && nums1[i] == nums2[j]) {
                res[k] = nums1[i];
                i++;
            } else if (i >= m) {
                res[k] = nums2[j];
                j++;
            } else {
                res[k] = nums1[i];
                i++;
            }
        }
        for (i = 0; i < m + n; i++) {
            nums1[i] = res[i];
        }
    }
}