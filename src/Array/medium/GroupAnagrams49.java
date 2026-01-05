package Array.medium;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class GroupAnagrams49 {
    public static void main(String[] args) {
        String[] strs = { "eat", "tea", "tan", "ate", "nat", "bat" };
        List<List<String>> res = GroupAnagrams49.groupAnagrams(strs);
        System.out.println(Arrays.asList(res));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {

        if (strs.length == 0) {
            return new ArrayList<>();
        }

        HashMap<String, List<String>> map = new HashMap<>();

        int[] freq = new int[26];

        for (String str : strs) {
            Arrays.fill(freq, 0);
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }

            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < freq.length; i++) {
                // sb.append("#");
                sb.append(freq[i]);
            }

            String key = sb.toString();

            if (!map.containsKey(key)) {
                map.put(key, new ArrayList<>());
            }

            map.get(key).add(str);
        }

        return new ArrayList<>(map.values());

    }

}
