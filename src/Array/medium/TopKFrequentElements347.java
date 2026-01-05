package Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Queue;

public class TopKFrequentElements347 {
    public static void main(String[] args) {
        int[] arr = { 4, 1, -1, 2, -1, 2, 3 };
        int k = 2;
        int[] resultArray = TopKFrequentElements347.topKFrequent2(arr, k);
        System.out.println(Arrays.toString(resultArray));
    }

    public static int[] topKFrequent(int[] nums, int k) {

        // time complexity of this is O(nlogn)

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        int[] resultArray = new int[k];
        // Convert keys to list
        List<Integer> keys = new ArrayList<>(map.keySet());

        // Sort keys by frequency (descending)
        keys.sort((a, b) -> map.get(b) - map.get(a));
        for (int i = 0; i < k; i++) {
            resultArray[i] = keys.get(i);
        }

        System.out.println(map);

        return resultArray;

    }

    public static int[] topKFrequent2(int[] nums, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i])) {
                map.put(nums[i], map.get(nums[i]) + 1);
            } else {
                map.put(nums[i], 1);
            }
        }

        Queue<Integer> queue = new PriorityQueue<>(
                ((a, b) -> map.get(a) - map.get(b)));

        for (Integer integer : map.keySet()) {
            queue.add(integer);
            if (queue.size() > k) {
                queue.poll();
            }
        }

        int[] ans = new int[k];

        for (int i = 0; i < k; i++) {
            ans[i] = queue.poll();
        }

        return ans;

    }
}
