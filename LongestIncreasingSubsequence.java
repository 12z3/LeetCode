package LeetCode;

import java.util.Arrays;

public class LongestIncreasingSubsequence {

    /**
      <a href="https://leetcode.com/problems/longest-increasing-subsequence/description/">...</a>
     */

    public static void main(String[] args) {

        int[] arr5 = {10, 9, 2, 5, 3, 7, 101, 18};
        int[] arr1 = {0, 1, 0, 3, 2, 3};
        int[] arr3 = {-2, -1};
        int[] arr = {4, 10, 4, 3, 8, 9};                                  // 9 > 4, 4 < 10 но 10 > 4
        int[] arr2 = {7, 7, 7, 7, 7, 7};
        int[] arr4 = {10, 9, 2, 5, 3, 4};

        System.out.println(lengthOfLIS(arr));
    }

    private static int lengthOfLIS(int[] nums) {
        int[] tmp = new int[nums.length];
        Arrays.fill(tmp, 1);
        int result = 1, elC = 1, lastEl = 0;

        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j] && tmp[i] < tmp[j] + 1 ) {
                    tmp[i] = tmp[j] + 1;
                }
            }
            elC = tmp[i];
            result = Math.max(result, elC);
        }
        System.out.println(Arrays.toString(tmp));
        return result;
    }
}
