package Array.medium;

public class LongestRepeatingCharacterReplacement424 {
    public static void main(String[] args) {

        int res = LongestRepeatingCharacterReplacement424.characterReplacement("ABAB", 0);
        System.out.println(res);
    }

    public static int characterReplacement(String s, int k) {
        int[] occurances = new int[26];
        int left = 0, right = 0;
        int ans = 0;
        int maxOccurance = 0;

        for (right = 0; right < s.length(); right++) {
            maxOccurance = Math.max(maxOccurance, ++occurances[s.charAt(right) - 'A']);
            if (right - left + 1 - maxOccurance > k) {
                occurances[s.charAt(left) - 'A']--;
                left++;
            }

            ans = Math.max(ans, right - left + 1);
        }

        return ans;
    }
}

// You are given a string s and an integer k. You can choose any character of
// the string and change it to any other uppercase English character. You can
// perform this operation at most k times.

// Return the length of the longest substring containing the same letter you can
// get after performing the above operations.
