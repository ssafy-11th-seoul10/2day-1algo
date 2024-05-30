import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2428_240530 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        long ans = 0;

        for (int i = 0; i < n; i++) {
            int low = lowerBound(arr, (arr[i] * 9 - 1) / 10 + 1);
            ans += i - low;
        }

        System.out.println(ans);
        br.close();
    }

    static int lowerBound(int[] arr, int x) {
        int low = -1;
        int high = arr.length;

        while (low + 1 < high) {
            int mid = (low + high) / 2;

            if (arr[mid] >= x) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return high;
    }

}
