class Solution {
    public int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;
        }

        int prev2 = 1;
        int prev1 = 1;

        for (int i = 1; i < s.length(); i++) {
            int current = 0;
            char curChar = s.charAt(i);
            char prevChar = s.charAt(i - 1);

            if (curChar != '0') {
                current += prev1;
            }

            int twoDigit = (prevChar - '0') * 10 + (curChar - '0');
            if (twoDigit >= 10 && twoDigit <= 26) {
                current += prev2;
            }

            prev2 = prev1;
            prev1 = current;
        }

        return prev1;
    }
}