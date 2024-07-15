import java.io.*;
import java.util.Arrays;

public class Main {

    private static int LIS(int[] arr){
        int[] tmp = new int[arr.length];
        int maxLen = 0;

        tmp[maxLen++] = arr[1];
        for (int i = 2; i < arr.length; i++){
            int idx = Arrays.binarySearch(tmp, 0, maxLen, arr[i]);

            if (idx < 0){
                idx = - idx - 1;
            }
            tmp[idx] = arr[i];
            maxLen = Math.max(maxLen, idx + 1);
        }
        return maxLen;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        for (int i = 1; i <= N; i++){
            arr[i] = Integer.parseInt(br.readLine());
        }

        System.out.println(N - LIS(arr));
    }

}
