package Array.easy;

import java.util.HashSet;

public class ContainsDuplicate219 {

    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 5 };

        boolean res = ContainsDuplicate219.containsNearbyDuplicate(nums, 3);
        System.out.println(res);

        int[] arr1 = { 1, 2, 3 };
        String[] arr2 = { "A", "B", "C" };
        String[] res2 = ContainsDuplicate219.getData(arr1, arr2);

        for (int i = 0; i < res2.length; i++) {
            System.out.println(res2[i]);
        }
    }

    public static boolean containsNearbyDuplicate(int[] nums, int k) {

        HashSet<Integer> hashSet = new HashSet<>();
        for (int i = 0; i < nums.length; i++) {

            if (hashSet.contains(nums[i])) {
                return true;
            } else {
                hashSet.add(nums[i]);

                if (hashSet.size() > k) {
                    hashSet.remove(nums[i - k]);
                }
            }
        }

        return false;

    }

    public static String[] getData(int[] arr1, String[] arr2) {
        String[] res = new String[3];
        int n = arr1.length;
        for (int i = 0; i < arr1.length; i++) {
            res[i] = arr2[i] + arr1[n - 1 - i];
        }

        return res;
    }

}