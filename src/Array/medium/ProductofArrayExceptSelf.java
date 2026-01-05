package Array.medium;

import java.util.Arrays;

public class ProductofArrayExceptSelf {
    public static void main(String[] args) {
        int[] arr = { 1, 2, 3, 4 };
        int[] result = ProductofArrayExceptSelf.productExceptSelf(arr);
        System.out.println(Arrays.toString(result));

    }

    public static int[] productExceptSelf(int[] nums) {

        int pre = 1, post = 1;
        int n = nums.length;
        int[] ans = new int[n];

        for (int i = 0; i < ans.length; i++) {
            ans[i] = pre;
            pre *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            ans[i] *= post;
            post *= nums[i];
        }

        return ans;

    }

}
