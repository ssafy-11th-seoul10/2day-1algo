import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15652 {

    static int N, M;
    static int[] numbers;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        numbers = new int[M];
        num(1, 0);

        System.out.println(sb);
    }

    static void num(int n, int cnt){
        if (cnt == M){
            for (int i = 0; i < M; i++) {
                sb.append(numbers[i]).append(" ");
            }
            sb.append("\n");
            return;
        }
        for(int i = n; i <= N; i++){
            numbers[cnt] = i;
            num(i, cnt+1);
        }
    }
}
