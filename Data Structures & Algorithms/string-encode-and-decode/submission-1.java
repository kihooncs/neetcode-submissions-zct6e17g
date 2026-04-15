class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for (String s : strs) {
            sb.append(s.length()).append('%').append(s);
        }
        return sb.toString();
    }

    public List<String> decode(String s) {
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < s.length()) {
            // read length until '%'
            int len = 0;
            while (i < s.length() && s.charAt(i) != '%') {
                len = len * 10 + (s.charAt(i) - '0');
                i++;
            }
            // skip '%'
            i++;
            // extract the next 'len' characters
            int start = i;
            int end = i + len;
            res.add(s.substring(start, end));
            i = end;
        }
        return res;
    }
}