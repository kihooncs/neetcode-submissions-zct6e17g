class Solution {
    public int compress(char[] chars) {
        StringBuilder s = new StringBuilder();
        int i = 0;

        while (i < chars.length) {
            char c = chars[i];
            int j = i + 1;
            while (j < chars.length && c == chars[j]) {
                j++;
            }
            s.append(c);
            if (j - i > 1) {
                s.append(String.valueOf(j - i));
            }
            i = j;
        }

        for (i = 0; i < s.length(); i++) {
            chars[i] = s.charAt(i);
        }
        return s.length();
    }
}