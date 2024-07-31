소인수분해를 이용
소인수 분해한 값들중 총 5가 몇번 들어가는 지 확인

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N;

    public static void main(String[] args) throws Exception {
        N = Integer.parseInt(br.readLine());
        int cnt = 0;
        for (int i = 1; i < N + 1; i++) {
            int x = i;
            while (x % 5 == 0) {
                cnt++;
                x /= 5;
            }
        }
        System.out.println(cnt);
    }
}
