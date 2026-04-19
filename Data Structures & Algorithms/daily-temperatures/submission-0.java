class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        // brute force: [30, 38, 30, 36, 35]
        // for each integer, iterate thru array and count temperatures
        // until it sees higher temp
        // time complexity -> O(n^2);
        
        int[] res = new int[temperatures.length];
        Stack<int[]> stack = new Stack<>();
        for (int i = 0; i < temperatures.length; i++) {
            int currTemp = temperatures[i];
            while (!stack.isEmpty() && stack.peek()[0] < currTemp) {
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            stack.push(new int[]{currTemp, i});
        }
        return res;
    }
}
