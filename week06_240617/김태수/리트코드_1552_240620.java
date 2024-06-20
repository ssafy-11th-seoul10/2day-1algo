import java.util.Arrays;

class Solution {
    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int left = 0;
        int right = position[position.length - 1];

        while (left <= right) {
            int mid = (left + right) / 2;

            if (can(position, m, mid)) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }

        return right;
    }

    private boolean can(int[] position, int m, int mid) {
        int count = 1;
        int pre = position[0];

        for (int i = 1; i < position.length; i++) {
            if (position[i] - pre >= mid) {
                count++;
                pre = position[i];
            }
        }

        return count >= m;
    }
}
