import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        long m = Integer.parseInt(st.nextToken());
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Long.parseLong(br.readLine());
        }

        Arrays.sort(arr);

        int i = 0;
        int j = 1;
        long result = Long.MAX_VALUE;

        while (i < n && j < n) {
            long diff = arr[j] - arr[i];
            if (diff >= m) {
                result = Math.min(result, diff);
                i++;
            } else j++;
        }
        System.out.println(result);
    }
}
