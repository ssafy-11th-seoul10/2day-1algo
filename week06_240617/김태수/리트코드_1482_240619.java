class Solution {
    public int minDays(int[] bloomDay, int m, int k) {
        int start = 0;
        int end = 0;

        for (int day : bloomDay) {
            end = Math.max(end, day);
        }

        int minDay = -1;

        while (start <= end) {
            int mid = (start + end) / 2;

            if (m <= binary(bloomDay, mid, k)) {
                minDay = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }

        return minDay;
    }

    private int binary(int[] bloomDay, int mid, int k) {
        int set = 0;
        int count = 0;

        for (int b : bloomDay) {
            if (b <= mid) {
                count++;
            } else {
                count = 0;
            }

            if (count == k) {
                set++;
                count = 0;
            }
        }

        return set;
    }
}
