package Array.medium;

public class LongestSubstringWithAtLeastKRepeatingCharacters395 {
    public static void main(String[] args) {
        int res = LongestSubstringWithAtLeastKRepeatingCharacters395.longestSubstring2("ababacb", 3);
        System.out.println(res);
    }

    public static int longestSubstring(String s, int k) {
        return solve(s, 0, s.length(), k);
    }

    private static int solve(String s, int start, int end, int k) {
        if (end - start < k)
            return 0;

        int[] freq = new int[26];
        for (int i = start; i < end; i++) {
            freq[s.charAt(i) - 'a']++;
        }

        for (int i = start; i < end; i++) {
            if (freq[s.charAt(i) - 'a'] < k) {
                int left = solve(s, start, i, k);
                int right = solve(s, i + 1, end, k);
                return Math.max(left, right);
            }
        }

        // All characters satisfy freq >= k
        return end - start;
    }

    public static int longestSubstring2(String s, int k) {
        int n = s.length();
        int result = 0;

        for (int targetUnique = 1; targetUnique <= 26; targetUnique++) {
            int[] freq = new int[26];
            int left = 0, right = 0;
            int uniqueCount = 0;
            int countAtLeastK = 0;

            while (right < n) {
                // expand window
                int r = s.charAt(right) - 'a';
                System.out.println(r);
                if (freq[r] == 0)
                    uniqueCount++;
                freq[r]++;
                if (freq[r] == k)
                    countAtLeastK++;
                right++;

                // shrink window
                while (uniqueCount > targetUnique) {
                    int l = s.charAt(left) - 'a';
                    if (freq[l] == k)
                        countAtLeastK--;
                    freq[l]--;
                    if (freq[l] == 0)
                        uniqueCount--;
                    left++;
                }

                // valid window
                if (uniqueCount == targetUnique && countAtLeastK == targetUnique) {
                    result = Math.max(result, right - left);
                }
            }
        }

        return result;
    }

}
