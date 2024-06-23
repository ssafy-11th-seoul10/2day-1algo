import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

class Solution {
    public int numberOfSubarrays(int[] nums, int k) {
        List<Integer> list = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 2 == 1) {
                list.add(i);
            }
        }

        int left = 0;
        int result = 0;

        int leftCount;
        int rightCount;

        for (int i = k - 1; i < list.size(); i++) {
            if (left == 0) {
                leftCount = list.get(left) + 1;
            } else {
                leftCount = list.get(left) - list.get(left - 1);
            }

            if (i == list.size() - 1) {
                rightCount = nums.length - list.get(i);
            } else {
                rightCount = list.get(i + 1) - list.get(i);
            }

            left++;
            result += rightCount * leftCount;
        }

        return result;
    }
}
