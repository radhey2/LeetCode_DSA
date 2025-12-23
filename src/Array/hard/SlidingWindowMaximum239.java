package Array.hard;

import java.util.Arrays;

public class SlidingWindowMaximum239 {
    public static void main(String[] args) {
        int[] arr = { 1, 3, -1, -3, 5, 3, 6, 7 };
        SlidingWindowMaximum239.maxSlidingWindow(arr, 3);
    }

    public static int[] maxSlidingWindow(int[] nums, int k) {
        int max = Integer.MIN_VALUE;
        int n = nums.length;
        int[] arr = new int[n];
        int i = 0;

        while (i < n) {

            if (i < k) {
                max = Math.max(max, nums[i]);
                i++;
            }

            if (arr[i] < max) {
                arr[i] = max;
            }

        }
        System.out.println(Arrays.toString(arr));
        return arr;
    }
}
