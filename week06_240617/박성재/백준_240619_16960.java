import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class 백준_240619_16960 {
    static int n;
    static int m;
    static int[] count;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(st.nextToken()); // 스위치 수
        m = Integer.parseInt(st.nextToken()); // 램프 수

        ArrayList<Integer>[] list = new ArrayList[n + 1];
        count = new int[m + 1];

        for (int i = 1; i <= n; i++) {
            st = new StringTokenizer(br.readLine());

            list[i] = new ArrayList<>();
            int len = Integer.parseInt(st.nextToken());

            for (int j = 0; j < len; j++) {
                int num = Integer.parseInt(st.nextToken());
                list[i].add(num);
                count[num]++;
            }
        }

        boolean flag = false;
        for (int i = 1; i <= n; i++) {
            ArrayList<Integer> now = list[i];
            for (int j = 0; j < now.size(); j++) {
                int num = now.get(j);
                count[num]--;
            }

            if (check()) {
                sb.append(1).append("\n");
                System.out.println(sb);
                return;
            }
            for (int j = 0; j < now.size(); j++) {
                int num = now.get(j);

                count[num]++;
            }
        }
        sb.append(0).append("\n");
        System.out.println(sb);
    }

    static boolean check() {
        for (int i = 1; i <= m; i++) {
            if (count[i] < 1)
                return false;
        }

        return true;
    }
}
