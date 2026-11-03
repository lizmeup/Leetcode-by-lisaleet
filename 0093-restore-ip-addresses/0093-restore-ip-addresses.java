import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<>();
        if (s.length() < 4 || s.length() > 12) {
            return result;
        }
        backtrack(s, 0, 0, new StringBuilder(), result);
        return result;
    }

    private void backtrack(String s, int index, int dots, StringBuilder current, List<String> result) {
        if (dots == 4) {
            if (index == s.length()) {
                result.add(current.substring(0, current.length() - 1));
            }
            return;
        }

        int len = current.length();
        for (int i = 1; i <= 3 && index + i <= s.length(); i++) {
            String part = s.substring(index, index + i);
            if (isValid(part)) {
                current.append(part).append('.');
                backtrack(s, index + i, dots + 1, current, result);
                current.setLength(len);
            }
        }
    }

    private boolean isValid(String segment) {
        if (segment.length() > 1 && segment.charAt(0) == '0') {
            return false;
        }
        int val = Integer.parseInt(segment);
        return val >= 0 && val <= 255;
    }
}