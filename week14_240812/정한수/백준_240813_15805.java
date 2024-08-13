import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        int[] parent = new int[N + 1 >> 1];
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        int prev = arr[0];
        parent[prev] = -1;
        for (int i = 1; i < N; i++){
            int cur = arr[i];
            
            if (cur != parent[prev]){
                parent[cur] = prev;
            }
            prev = cur;
        }

        sb.append(N + 1 >> 1).append('\n');
        for (int n : parent){
            sb.append(n).append(' ');
        }
        System.out.println(sb);
    }

}
