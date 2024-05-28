import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_19939_240528 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int min = k * (k + 1) / 2;

        if (n < min) {
            sb.append(-1).append("\n");
        } else {
            int remain = n - min; // 일단 한번 분배
            int answer = k - 1;

            if (remain % k != 0)
                answer++;

            sb.append(answer).append("\n");
        }

        System.out.println(sb);
    }
}
