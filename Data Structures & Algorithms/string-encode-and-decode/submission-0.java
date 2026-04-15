class Solution {

    public String encode(List<String> strs) {
        // encode with number and delimiter pattern (e.g, 3%ant)
        // number alone is not sufficient as length of string can be double digits
        // for each string in the list, compute the length of string and append length and delimiter to 
        // the beginning of the string
        String result = "";
        for (String str : strs) {
            result += str.length() + "%" + str;
        }
        return result;
    }

    public List<String> decode(String str) {
        // When decoding, we can read the length of the string until we hit the delimiter
        // and fetch the string only from the encoded string and continue
        List<String> res = new ArrayList<>();
        int i = 0;
        while (i < str.length()) {
            // decode (1. compute length, 2. get String)
            int length = 0;
            while (str.charAt(i) != '%') {
                length = length * 10 + (str.charAt(i) - '0');
                i++;
            }
            // i is at delimiter
            String curr = "";
            for (int j = 0; j < length; j++) {
                curr += str.charAt(i + 1 + j);
            }

            // add string to res
            res.add(curr);

            // update index accordingly
            i += length + 1;
        }
        return res;
    }
}
