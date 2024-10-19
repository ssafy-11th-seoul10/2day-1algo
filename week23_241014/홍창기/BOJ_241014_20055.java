import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_241014_20055 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int n2 = n * 2;
        int k = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine(), " ");
        int[] durability = new int[n2];
        int[] robot = new int[n2];

        for (int i = 0; i < n2; i++) {
            durability[i] = Integer.parseInt(st.nextToken());
        }

        int s = 0;
        int e = n - 1;
        int stage = 0;

        while (k > 0) {
            // 벨트를 돌린다.
            s = (s - 1 + n2) % n2;
            e = (e - 1 + n2) % n2;

            // 마지막 자리에 로봇이 존재하면 제거한다.
            if (robot[e] == 1) {
                robot[e] = 0;
            }

            // 로봇을 이동한다.
            int ni = e;
            int i = (e - 1 == -1 ? n2 - 1 : e - 1);

            while (i != s) {
                if (robot[i] == 1 && robot[ni] == 0 && durability[ni] > 0) {
                    robot[i] = 0;
                    robot[ni] = 1;

                    if (--durability[ni] == 0) {
                        k--;
                    }
                }

                ni = i;
                i = (i - 1 == -1 ? n2 - 1 : i - 1);
            }

            // 마지막 자리에 로봇이 존재하면 제거한다.
            if (robot[e] == 1) {
                robot[e] = 0;
            }

            // 처음 자리에 로봇을 올린다.
            if (durability[s] > 0) {
                robot[s] = 1;

                if (--durability[s] == 0) {
                    k--;
                }
            }

            stage++;
        }

        System.out.println(stage);
        br.close();
    }

}
