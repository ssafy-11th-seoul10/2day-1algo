import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class 백준_240825_1436 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(st.nextToken());

        int index = 0;
        int num = 0;

        while (true) {
            num++;

            String numStr = Integer.toString(num);

            if (numStr.contains("666")) {
                index++;

                if (index == n) {
                    sb.append(numStr).append("\n");
                    break;
                }
            }
        }

        System.out.println(sb);
    }
}
