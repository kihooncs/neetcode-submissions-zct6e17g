class Solution {
    public int[] topKFrequent(int[] nums, int k) {
       Map<Integer, Integer> count = new HashMap<>();
       List<Integer>[] freqList = new List[nums.length + 1];
       for (int n : nums) {
        count.putIfAbsent(n, 0);
        count.put(n, count.get(n) + 1);
       }
       for (Integer n : count.keySet()) {
        int freq = count.get(n);
        if (freqList[freq] == null) {
            freqList[freq] = new ArrayList<>();
        }
        freqList[freq].add(n);
       }
       int[] res = new int[k];
       int index = 0;
       for (int i = freqList.length - 1; i > 0 && index < k; i--) {
        if (freqList[i] != null) {
            for (Integer n : freqList[i]) {
                res[index++] = n;
                if (index == k) {
                    return res;
                }
            }
        }
       }
       return res;
    }
}
