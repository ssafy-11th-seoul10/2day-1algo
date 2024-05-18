import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_20551_240518 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Arrays.sort(arr);

        for (int i = 0; i < m; i++) {
            int d = Integer.parseInt(br.readLine());
            sb.append(lowerBound(arr, d)).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

    static int lowerBound(int[] arr, int val) {
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

        if (high == arr.length || arr[high] != val) {
            return -1;
        }

        return high;
    }

}
