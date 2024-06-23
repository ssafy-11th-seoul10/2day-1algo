import java.util.TreeMap;

class Solution {

    public int longestSubarray(int[] nums, int limit) {
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int left = 0;
        int max = 0;

        for (int right = 0; right < nums.length; ++right) {
            map.put(nums[right], map.getOrDefault(nums[right], 0) + 1);

            while (map.lastKey() - map.firstKey() > limit) {
                map.put(nums[left], map.get(nums[left]) - 1);
                if (map.get(nums[left]) == 0) {
                    map.remove(nums[left]);
                }
                left++;
            }
            max = Math.max(max, right - left + 1);
        }

        return max;
    }
}
