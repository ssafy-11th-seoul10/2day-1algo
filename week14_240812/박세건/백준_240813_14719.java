import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;


    public static void main(String[] args) throws Exception {
        List<Integer> list = new ArrayList<>();
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < M; i++) {
            list.add(Integer.parseInt(st.nextToken()));
        }
        int answer = 0;
        for (int i = 1; i <= N; i++) {
            boolean isCounting = false;
            int cnt = 0;
            for (int j = 0; j < M; j++) {
                int height = list.get(j);
                if (height >= i) {
                    if (isCounting) {
//                        System.out.println(height + " " + i + " " + cnt);
                        answer += cnt;
                        cnt = 0;
                    }
                    isCounting = true;
                    continue;
                }
                if (isCounting) {
                    cnt++;
                }
            }
        }
        System.out.println(answer);
    }
}
