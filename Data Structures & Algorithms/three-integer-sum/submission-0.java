class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < nums.length - 2; i++) {
            int first = nums[i];
            if (first > 0) break;
            int left = i + 1;
            int right = nums.length - 1;
            if (i > 0 && first == nums[i - 1]) {
                continue;
            }
            while (left < right) {
                int second = nums[left];
                int third = nums[right];
                int sum = first + second + third;
                if (sum == 0) {
                    // add to result
                    result.add(new ArrayList<>(List.of(first, second, third)));
                    left++;
                    right--;
                    while (left < right && nums[left] == nums[left - 1]) {
                        left++;
                    }
                } else if (sum < 0) {
                    left++;
                } else { // sum > 0
                    right--;
                }
            }
        }
        return result;
        // [-4, -1, -1, -1, 0, 1, 2, 2]
        //
    }
}
