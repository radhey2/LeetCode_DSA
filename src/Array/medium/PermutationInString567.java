package Array.medium;

public class PermutationInString567 {
    public static void main(String[] args) {
        boolean res = PermutationInString567.checkInclusion("abc", "ababc");
        System.out.println(res);
    }

    public static boolean checkInclusion(String s1, String s2) {

        if (s1.length() > s2.length()) {
            return false;
        }

        int[] fMap1 = new int[26];
        int[] fMap2 = new int[26];

        for (int i = 0; i < s1.length(); i++) {
            fMap1[s1.charAt(i) - 'a']++;
            fMap2[s2.charAt(i) - 'a']++;

        }

        for (int i = 0; i < fMap2.length; i++) {
            if (matches(fMap1, fMap2)) {
                return true;
            }
            fMap2[s2.charAt(i + s1.length()) - 'a']++; // Add new character to the window
            fMap2[s2.charAt(i) - 'a']--; // Remove old character from the window
        }

        return matches(fMap1, fMap2);

    }

    // Helper function to compare two frequency maps
    private static boolean matches(int[] fMap1, int[] fMap2) {
        for (int i = 0; i < 26; i++) {
            if (fMap1[i] != fMap2[i]) {
                return false;
            }
        }
        return true;
    }
}

// Given two strings s1 and s2, return true if s2 contains a permutation of s1,
// or false otherwise.

// In other words, return true if one of s1's permutations is the substring of
// s2.
