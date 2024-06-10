class Solution {
    public int longestPalindrome(String s) {
        char[] alpha = new char[91];

        for (int i = 0; i < s.length(); i++) {
            alpha[s.charAt(i) - 'A']++;
        }

        boolean hasOdd = false;
        int count = 0;

        for (char a : alpha) {
            if (a >= 2 && a % 2 == 0) {
                count += a;
            } else if (a >= 2) {
                count += a - 1;
                hasOdd = true;
            } else if (a == 1) {
                hasOdd = true;
            }
        }
        return count + (hasOdd ? 1 : 0);
    }
}
