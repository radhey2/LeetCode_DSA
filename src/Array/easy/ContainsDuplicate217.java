package Array.easy;

import java.util.HashSet;

public class ContainsDuplicate217 {
    public static void main(String[] args) {

        int[] nums = { 1, 2, 3, 4, 3 };

        boolean res = ContainsDuplicate217.containsDuplicate(nums);
        System.out.println(res);
    }

    public static boolean containsDuplicate(int[] nums) {

        HashSet<Integer> hashSet = new HashSet<>();

        for (int i = 0; i < nums.length; i++) {
            if (!hashSet.contains(nums[i])) {
                hashSet.add(nums[i]);
            } else {
                return true;
            }
        }

        return false;

    }
}
