package Array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;

public class Interview {
    public static void main(String[] args) {
        System.out.println("Hello Interview");
        int[] nums = { 2, 7, 11, 15 };
        int target = 9;
        // int[] res = Interview.TwoSum(nums, target);
        // System.out.println(Arrays.toString(res));

        String s = "leetcode";
        // boolean isAnagram = Interview.isAnagram(s, "leetecod");
        // System.out.println(isAnagram);

        // Interview.moveZeroes(nums);
        // Interview.rotate(nums, 3);

        int[][] matrix = { { 1, 3, 5, 7 }, { 10, 11, 16, 20 }, { 23, 30, 34, 60 } };
        // boolean res = Interview.searchMatrix(matrix, target);

        // boolean res = Interview.containsDeplicate(nums);
        // boolean res = Interview.validAnagram("ggii", "eekk");
        int[] res = Interview.twoSum(nums, target);
        System.out.println(Arrays.toString(res));
    }

    public static int[] TwoSum(int[] nums, int target) {

        int arr[] = new int[2];

        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {

            int rem = target - nums[i];

            if (hashMap.containsKey(rem)) {
                arr[0] = hashMap.get(rem);
                arr[1] = i;

            }
            hashMap.put(nums[i], i);
        }
        return arr;
    }

    public static int firstUniqChar(String s) {

        if (s == null || s.length() == 0) {
            return -1;
        }
        int[] freq = new int[26];

        // First pass: count frequency
        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = 0; i < s.length(); i++) {

            if (freq[s.charAt(i) - 'a'] == 1) {
                return i;
            }

        }

        return -1;
    }

    public static boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        for (int count : freq) {
            if (count != 0) {
                return false;
            }
        }

        return true;
    }

    public static void moveZeroes(int[] nums) {
        int left = 0;
        for (int right = 0; right < nums.length; right++) {
            if (nums[right] != 0) {
                int temp = nums[left];
                nums[left] = nums[right];
                nums[right] = temp;
                left++;
            }
            System.out.println(Arrays.toString(nums));
        }

    }

    public static void rotate(int[] nums, int k) {
        int n = nums.length;
        k = k % n;

        reverse(nums, 0, n - 1);
        reverse(nums, 0, k - 1);
        reverse(nums, k, n - 1);
    }

    public static void reverse(int[] nums, int left, int right) {
        int n = nums.length;
        while (left < right) {
            int temp = nums[right];
            nums[right] = nums[left];
            nums[left] = temp;
            left++;
            right--;
            System.out.println(Arrays.toString(nums));
        }
    }

    public static boolean searchMatrix(int[][] matrix, int target) {

        int m = matrix.length;
        int n = matrix[0].length;

        int targetRow = 0;
        for (int i = 0; i < m; i++) {
            if (target >= matrix[i][0] && target <= matrix[i][n - 1]) {
                targetRow = i;
                break;
            }
        }

        for (int j = 0; j < n; j++) {
            if (target == matrix[targetRow][j]) {
                return true;
            }

        }
        return false;

    }

    public static boolean containsDeplicate(int[] nums) {

        HashSet<Integer> set = new HashSet<>();

        for (int num : nums) {

            if (!set.contains(num)) {
                set.add(num);
            } else {
                return true;
            }
        }

        return false;

    }

    public static boolean validAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            freq[s.charAt(i) - 'a']++;
            freq[t.charAt(i) - 'a']--;
        }

        System.out.println(Arrays.toString(freq));

        for (int i = 0; i < freq.length; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }

        return true;
    }

    public static int[] twoSum(int[] nums, int target) {

        int rem = 0;
        int[] arr = new int[2];
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            rem = target - nums[i];
            if (hashMap.containsKey(rem)) {
                arr[0] = i;
                arr[1] = hashMap.get(rem);
            } else {
                hashMap.put(nums[i], i);
            }
        }

        return arr;
    }

}
