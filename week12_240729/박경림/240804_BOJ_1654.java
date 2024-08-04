import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int k = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken()); // 필요한 랜선의 개수
        long[] arr = new long[k];
        for (int i = 0; i < k; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);
        System.out.println(binarySearch(arr, n));
    }

    private static long binarySearch(long[] arr, int target) {
        long low = 1;
        long high = arr[arr.length - 1];
        long mid = 0;
        long result = 0;

        while (low <= high) {
            mid = (low + high) / 2;
            int cnt = 0;

            for (int i = 0; i < arr.length; i++) {
                cnt += (arr[i] / mid);
            }

            if (cnt >= target) {
                result = mid;
                low = mid + 1;
            } else {
                high = mid - 1;
            }
        }

        return result;
    }
}
