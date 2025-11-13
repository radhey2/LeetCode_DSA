package Array.medium;

import java.util.HashSet;

public class LongestSubstringWithoutRepeatingCharacters3 {
    public static void main(String[] args) {

        int res = LongestSubstringWithoutRepeatingCharacters3.lengthOfLongestSubstring("qrsvbspk");
        System.out.println(res);
    }

    public static int lengthOfLongestSubstring(String s) {

        HashSet<Character> hashset = new HashSet<Character>();
        int ans = hashset.size();
        int left = 0;
        int right = 0;

        if (s.length() == 0) {
            return 0;
        } else if (s.isBlank()) {
            return 1;
        }

        for (right = 0; right < s.length(); right++) {

            char currentChar = s.charAt(right);
            while (hashset.contains(currentChar)) {
                // Remove the character at the left pointer's position
                hashset.remove(s.charAt(left));
                // Move the left pointer one step to the right
                left++;
            }

            // At this point, the current character (currentChar) is guaranteed to be unique
            // 2. Expand the window
            hashset.add(currentChar);

            // 3. Update the maximum length found so far
            // The length of the current window is right - left + 1
            ans = Math.max(ans, right - left + 1);

        }

        return Math.max(ans, hashset.size());

    }
}
