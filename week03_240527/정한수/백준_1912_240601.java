import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine()), maxSum, minSum;
        StringTokenizer st = new StringTokenizer(br.readLine());
        int[] arr = new int[N];

        minSum = maxSum = arr[0] = Integer.parseInt(st.nextToken());
        for (int i = 1; i < N; i++) {
            arr[i] = arr[i - 1] + Integer.parseInt(st.nextToken());
            maxSum = Math.max(maxSum, Math.max(arr[i], arr[i] - minSum));
            minSum = Math.min(minSum, arr[i]);
        }

        System.out.println(maxSum);
    }

}
