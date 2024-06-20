import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 백준_240620_15656 {
    static int[] arr;
    static int n;
    static int m;
    static StringBuilder sb;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n];

        st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            arr[i] = num;
        }
        Arrays.sort(arr);

        backtrack(0, "");
        System.out.println(sb);
    }

    static void backtrack(int depth, String s) {
        if (depth == m) {
            sb.append(s).append("\n");
            return;
        }

        for (int i = 0; i < n; i++) {
            if (depth == 0) {
                backtrack(depth + 1, s + arr[i]);
            } else {
                backtrack(depth + 1, s + " " + arr[i]);
            }
        }
    }
}
