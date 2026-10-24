class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> numsPair = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currNum = nums[i];
            int currDiff = target - currNum;
            if (numsPair.containsKey(currDiff)) {
                return new int[]{numsPair.get(currDiff), i};
            }
            numsPair.put(currNum, i);
        }
        return null;
    }
}
