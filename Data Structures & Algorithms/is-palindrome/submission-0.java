class Solution {
    public boolean isPalindrome(String s) {
        s = s.toLowerCase();
        int left = 0; 
        int right = s.length() - 1;
        while (left < right) {
            char leftChar = s.charAt(left);
            char rightChar = s.charAt(right);
            if (!isAlphaNum(leftChar)) {
                left++;
                continue;
            }
            
            if (!isAlphaNum(rightChar)) {
                right--;
                continue;
            }

            if (leftChar != rightChar) {
                return false;
            } else {
                left++;
                right--;
            }
        }
        return true;
    }

    private boolean isAlphaNum(char c) {
        return (('a' <= c && c <= 'z') ||
                ('A' <= c && c <= 'Z') ||
                ('0' <= c && c <= '9'));
    }
}
