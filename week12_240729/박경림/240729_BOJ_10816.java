import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        int num1[] = new int[n];
        for (int i = 0; i < n; i++) {
            num1[i] = Integer.parseInt(st.nextToken());
        }

        int m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        int num2[] = new int[m];
        for (int i = 0; i < m; i++) {
            num2[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(num1);

        int result[] = new int[m];
        for (int i = 0; i < m; i++) {
            result[i] = upperBound(num1, num2[i]) - lowerBound(num1, num2[i]);
        }

        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < result.length; i++) {
            sb.append(result[i]).append(" ");
        }
        System.out.println(sb);
    }

    private static int upperBound(int[] nums, int target) {
        int low = -1;
        int high = nums.length;

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (nums[mid] > target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }

    private static int lowerBound(int[] nums, int target) {
        int low = -1;
        int high = nums.length;

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (nums[mid] >= target) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return low;
    }
}
