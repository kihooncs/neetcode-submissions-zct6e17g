class Solution {
    public int largestRectangleArea(int[] heights) {
        Stack<int[]> s = new Stack<>(); // pair: height, index
        int max = 0;

        for (int i = 0; i < heights.length; i++) {
            int h = heights[i];
            int index = i;
            while (!s.isEmpty() && h < s.peek()[0]) {
                int[] top = s.pop();
                max = Math.max(max, top[0] * (i - top[1]));
                index = top[1];
            }
            s.push(new int[]{h, index});
        }

        while (!s.isEmpty()) {
            int[] next = s.pop();
            max = Math.max(max, next[0] * (heights.length - next[1]));
        }

        return max; 
    }
}
