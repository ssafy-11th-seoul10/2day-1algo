import java.util.Deque;
import java.util.LinkedList;

class Solution {
    public int longestSubarray(int[] nums, int limit) {
        Deque<Integer> minDeque = new LinkedList<>();
        Deque<Integer> maxDeque = new LinkedList<>();
        int start = 0;
        int maxLength = 0;

        for (int end = 0; end < nums.length; end++) {
            while (!minDeque.isEmpty() && nums[minDeque.peekLast()] > nums[end]) {
                minDeque.pollLast();
            }
            minDeque.addLast(end);

            while (!maxDeque.isEmpty() && nums[maxDeque.peekLast()] < nums[end]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(end);

            while (nums[maxDeque.peekFirst()] - nums[minDeque.peekFirst()] > limit) {
                start++;
                if (minDeque.peekFirst() < start) {
                    minDeque.pollFirst();
                }
                if (maxDeque.peekFirst() < start) {
                    maxDeque.pollFirst();
                }
            }

            maxLength = Math.max(maxLength, end - start + 1);
        }

        return maxLength;
    }
}