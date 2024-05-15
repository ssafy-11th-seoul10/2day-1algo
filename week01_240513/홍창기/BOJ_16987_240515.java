import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_16987_240515 {

    static int n;
    static int[] s; // 내구도
    static int[] w; // 무게
    static int maxBrokenEggCount;

    static void recur(int depth) {
        if (depth == n) {
            // 깨진 계란의 개수를 구한다.
            int brokenEggCount = 0;

            for (int i = 0; i < n; i++) {
                if (s[i] <= 0) {
                    brokenEggCount++;
                }
            }

            // 깨진 계란의 개수 최댓값을 업데이트한다.
            maxBrokenEggCount = brokenEggCount > maxBrokenEggCount ? brokenEggCount : maxBrokenEggCount;
            return;
        }

        if (s[depth] <= 0) {
            // 현재 손에 들고 있는 계란이 깨졌다면 다음 계란으로 넘어간다.
            recur(depth + 1);
        } else {
            // 현재 손에 들고 있는 계란이 깨지지 않았다면 깨지지 않은 나머지 계란 중 하나를 선택한다.
            boolean flagNextRecur = false;

            for (int i = 0; i < n; i++) {
                if (i == depth || s[i] <= 0) {
                    continue;
                }

                s[depth] -= w[i];
                s[i] -= w[depth];
                recur(depth + 1);
                flagNextRecur = true;
                s[i] += w[depth];
                s[depth] += w[i];
            }

            // 나머지 계란이 모두 깨진 상태여서 다음 재귀가 실행되지 않았다면 재귀를 실행한다.
            if (!flagNextRecur) {
                recur(depth + 1);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        n = Integer.parseInt(br.readLine());
        s = new int[n]; // 내구도
        w = new int[n]; // 무게

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            s[i] = Integer.parseInt(st.nextToken());
            w[i] = Integer.parseInt(st.nextToken());
        }

        recur(0);
        System.out.println(maxBrokenEggCount);
        br.close();
    }

}
