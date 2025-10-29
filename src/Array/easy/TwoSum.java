package Array.easy;

import java.util.Arrays;
import java.util.HashMap;

public class TwoSum {
    public static void main(String[] args) {

        int[] arr = { 3, 3 };

        int[] res = TwoSum.twoSum(arr, 6);

        System.out.println(Arrays.toString(res));

    }

    public static int[] twoSum(int[] nums, int target) {

        int arr[] = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int rem = target - nums[i];

            if (hashMap.containsKey(rem)) {
                arr[0] = i;
                arr[1] = hashMap.get(rem);
            }

            hashMap.put(nums[i], i);

        }
        System.out.println(hashMap);

        return arr;
    }
}
