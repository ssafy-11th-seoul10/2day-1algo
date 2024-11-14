package baekjoon;
// https://dy-coding.tistory.com/entry/%EB%B0%B1%EC%A4%80-15663%EB%B2%88-N%EA%B3%BC-M-9-java
import java.util.*;
import java.io.*;

public class BOJ15663 {

    static int N, M;
    static int[] arr;

    static int[] perm;
    static boolean[] visited;

    static Set<String> temp = new HashSet<>();
    static StringBuilder sb;

    public static void permutation(int depth) {

        if(depth == M) {

            sb = new StringBuilder();
            for(int i = 0; i < M; i++)
                sb.append(perm[i]).append(" ");

            String res = sb.toString();

            if(temp.contains(res)) {
                return;
            }

            System.out.println(res);
            temp.add(res);

            return;
        }

        for(int i = 0; i < N; i++) {
            if(visited[i]) continue;

            visited[i] = true;
            perm[depth] = arr[i];

            permutation(depth + 1);

            visited[i] = false;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        arr = new int[N];
        perm = new int[M];
        visited = new boolean[N];

        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++)
            arr[i] = Integer.parseInt(st.nextToken());

        // perm
        Arrays.sort(arr);
        permutation(0);
    }
}
