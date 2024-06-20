import java.util.*;

class LeetCode_240620_1552 {

    public int maxDistance(int[] position, int m) {
        Arrays.sort(position);

        int low = 1;
        int high = 1000000000;

        while (low + 1 < high) {
            int mid = (low + high) / 2;
            int cnt = 0;
            int pos = -1000000000;

            while (true) {
                int idx = lowerBound(position, pos + mid);

                if (idx >= position.length) {
                    break;
                }

                pos = position[idx];
                cnt++;
            }

            if (cnt >= m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return low;
    }

    int lowerBound(int[] arr, int val) {
        int low = -1;
        int high = arr.length;

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= val) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

}
