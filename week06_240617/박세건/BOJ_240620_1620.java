import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N, M;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        Map<String, Integer> map = new HashMap<>();
        String[] strings = new String[N];
        for (int i = 0; i < N; i++) {
            String tmp = bufferedReader.readLine();
            map.put(tmp, i + 1);
            strings[i] = tmp;
        }
        for (int i = 0; i < M; i++) {
            String tmp = bufferedReader.readLine();
            if (tmp.charAt(0) >= '0' && tmp.charAt(0) <= '9') {
                System.out.println(strings[Integer.parseInt(tmp) - 1]);
            } else {
                System.out.println(map.get(tmp));
            }
        }
    }
}
