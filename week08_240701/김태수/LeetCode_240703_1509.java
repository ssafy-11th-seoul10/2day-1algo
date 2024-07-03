import java.util.Arrays;

class Solution {

    public int minDifference(int[] nums) {
        int numsSize = nums.length;

        if (numsSize <= 4) {
            return 0;
        }

        Arrays.sort(nums);

        int minDiff = Integer.MAX_VALUE;
        int right = numsSize - 4;

        for (int left = 0; left < 4; left++) {
            minDiff = Math.min(minDiff, nums[right++] - nums[left]);
        }

        return minDiff;
    }
}
