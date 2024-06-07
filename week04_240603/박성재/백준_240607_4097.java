import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class 백준_240607_4097 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n;

        while ((n = Integer.parseInt(br.readLine())) != 0) {
            int[] arr = new int[n];
            int[] section = new int[n];
            for (int i = 0; i < n; i++) {
                int num = Integer.parseInt(br.readLine());
                arr[i] = num;
            }

            section[0] = arr[0];
            int answer = Integer.MIN_VALUE;
            for (int i = 1; i < n; i++) {
                section[i] = Math.max(section[i - 1] + arr[i], arr[i]);
                answer = Math.max(answer, section[i]);
            }

            sb.append(answer).append("\n");
        }
        System.out.println(sb);
    }
}
