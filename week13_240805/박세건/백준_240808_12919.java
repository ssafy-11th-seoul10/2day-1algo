S를 T로 만드는데에 필요한 A와 B의 개수를 판단해서 비교
  -> 시간초과
T를 S로 만들 수 있는지 확인
  -> 통과

=> S를 T로 만드는 과정은 안되는 경우라도 끝까지 재귀, T를 S로 만드는 과정은 미리 판단하고 종료 가능



import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;

    public static void main(String[] args) throws Exception {
        String x = br.readLine();
        String y = br.readLine();
        boolean answer = DFS(y, x);
        System.out.println((answer) ? 1 : 0);
    }

    private static boolean DFS(String cur, String y) {
//        System.out.println(cur + " " + y);
        if (cur.length() == y.length()) {
            if (cur.equals(y)) {
                return true;
            } else {
                return false;
            }
        }
        if (cur.charAt(cur.length() - 1) == 'A') {
            if (DFS(cur.substring(0, cur.length() - 1), y)) {
                return true;
            }
        }
        if (cur.charAt(0) == 'B') {
            if (DFS(new StringBuilder(cur.substring(1)).reverse().toString(), y)) {
                return true;
            }
        }
        return false;
    }

}
