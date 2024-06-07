import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static int N, M;
    private static int answer = -1;

    public static void main(String[] args) throws IOException {
        Map<Integer, Integer> countMap = new HashMap<>();
        N = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());

        for (int i = 0; i < N; i++) {
            int tmp = Integer.parseInt(stringTokenizer.nextToken());
            if (countMap.containsKey(tmp)) {
                countMap.put(tmp, countMap.get(tmp) + 1);
            } else {
                countMap.put(tmp, 1);
            }
        }
        M = Integer.parseInt((bufferedReader.readLine()));
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 0; i < M; i++) {
            int tmp = Integer.parseInt(stringTokenizer.nextToken());
            stringBuilder.append(countMap.getOrDefault(tmp, 0)).append(" ");
        }
        System.out.println(stringBuilder.toString());
    }
}
