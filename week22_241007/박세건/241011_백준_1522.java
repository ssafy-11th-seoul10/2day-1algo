import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static int N;
    private static int answer = 0;


    public static void main(String[] args) throws IOException {
        String input = br.readLine();
        int answer = input.length();
        int aCnt = 0, bCnt = 0;
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == 'a')
                aCnt++;
            else
                bCnt++;
        }
        StringBuilder targetSb = new StringBuilder();
        for (int i = 0; i < aCnt; i++) {
            targetSb.append('a');
        }
        for (int i = 0; i < bCnt; i++) {
            targetSb.append('b');
        }
        for (int i = 0; i < input.length(); i++) {
            int cnt = 0;
            for (int j = 0; j < input.length(); j++) {
                if (input.charAt(j) != targetSb.charAt(j)) {
                    cnt++;
                }
            }
            answer = Math.min(answer, cnt / 2);
            targetSb.append(targetSb.charAt(0)).deleteCharAt(0);
        }
        System.out.println(answer);

    }

}
