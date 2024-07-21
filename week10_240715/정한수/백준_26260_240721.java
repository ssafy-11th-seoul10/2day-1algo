import java.io.*;
import java.util.*;

public class Main {

    private static StringBuilder sb = new StringBuilder();

    private static void postorder(int[] arr, int level, int idx){
        if (level < 0){
            return;
        }

        postorder(arr, level - 1, idx - (1 << level - 1));
        postorder(arr, level - 1, idx + (1 << level - 1));
        sb.append(arr[idx]).append(' ');
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] arr = new int[N + 1];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N; i++){
            int a = Integer.parseInt(st.nextToken());

            if (a < 0){
                i--;
                continue;
            }
            arr[i] = a;
        }
        arr[N] = Integer.parseInt(br.readLine());
        Arrays.sort(arr);

        postorder(arr, Integer.bitCount(N) - 1, N / 2 + 1);
        System.out.println(sb);
    }

}
