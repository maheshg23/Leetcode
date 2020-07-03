class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int i = 0, j = 0, k = 0;
        int total = nums1.length + nums2.length;
        int[] a = new int[total];
        while (i < nums1.length && j < nums2.length) {
            if (nums1[i] < nums2[j])
                a[k++] = nums1[i++];
            else
                a[k++] = nums2[j++];
        }
        while (i < nums1.length) {
            a[k++] = nums1[i++];
        }
        while (j < nums2.length) {
            a[k++] = nums2[j++];
        }
        if (total % 2 == 0) {
            return (a[(total / 2) - 1] + a[(total / 2)]) / 2.0;
        } else {
            return a[total / 2];
        }
    }
}