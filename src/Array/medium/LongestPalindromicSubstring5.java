package Array.medium;

public class LongestPalindromicSubstring5 {
    public static void main(String[] args) {
        String res = LongestPalindromicSubstring5.longestPalindrome("babad");
        System.out.println(res);
    }

    public static String longestPalindrome(String s) {

        int start = 0;
        int end = s.length();
        String result = "";

        while (start < end) {
            if (s.charAt(start) == s.charAt(end - 1)) {
                // Check for palindrome
                for (int i = start, j = end - 1; i < j; i++, j--) {
                    if (s.charAt(i) != s.charAt(j)) {
                        break;
                    } else {
                        String reversed = reversedString(s.substring(i, j));
                        System.out.println(reversed);
                    }
                }

            }
            end--;
        }
        return result;
    }

    public static String reversedString(String s) {
        String reversed = "";
        for (int i = s.length() - 1; i >= 0; i--) {
            reversed += s.charAt(i);
        }
        return reversed;
    }
}
