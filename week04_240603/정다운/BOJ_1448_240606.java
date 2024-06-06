import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;

public class BOJ1448 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        for(int i = 0; i < n; i++)
            arr[i] = Integer.parseInt(br.readLine());

        if(n < 3)
            System.out.println(-1);

        else {

            Arrays.sort(arr);
            int result = -1;

            for(int start = n - 1; start > 1; start--) {

                int large = arr[start];
                int small_one = arr[start-1];
                int small_two = arr[start-2];

                if(small_two + small_one > large) {
                    result = small_one + small_two + large;
                    break;
                }
            }

            System.out.println(result);
        }

    }
}
