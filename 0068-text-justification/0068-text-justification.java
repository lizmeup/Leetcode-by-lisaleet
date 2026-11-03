import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int i = 0;
        int n = words.length;

        while (i < n) {
            int j = i + 1;
            int lineLen = words[i].length();

            while (j < n && lineLen + 1 + words[j].length() <= maxWidth) {
                lineLen += 1 + words[j].length();
                j++;
            }

            StringBuilder sb = new StringBuilder();
            int numWords = j - i;
            int numGaps = numWords - 1;

            if (j == n || numWords == 1) {
                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        sb.append(' ');
                    }
                }
                while (sb.length() < maxWidth) {
                    sb.append(' ');
                }
            } else {
                int totalWordLen = 0;
                for (int k = i; k < j; k++) {
                    totalWordLen += words[k].length();
                }

                int totalSpaces = maxWidth - totalWordLen;
                int baseSpaces = totalSpaces / numGaps;
                int extraSpaces = totalSpaces % numGaps;

                for (int k = i; k < j; k++) {
                    sb.append(words[k]);
                    if (k < j - 1) {
                        int spacesToApply = baseSpaces + (k - i < extraSpaces ? 1 : 0);
                        for (int s = 0; s < spacesToApply; s++) {
                            sb.append(' ');
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j;
        }

        return result;
    }
}