class Solution {
    public int findDuplicate(int[] nums) {
        int slow = 0;
        int fast = 0;
        do {
            slow = nums[slow];
            fast = nums[nums[fast]];
        } while (slow != fast);

        int head = 0;

        while (head != slow) {
            head = nums[head];
            slow = nums[slow];
        }
        return head;
    }
}
