class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        while (read < chars.length) {
            chars[write] = chars[read];
            write++;
            int second = read + 1;
            while (second < chars.length && chars[read] == chars[second]) {
                second++;
            }
            if (second - read > 1) {
                String count = String.valueOf(second - read);
                for (char c : count.toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
            read = second;
        }
        return write;
    }
}