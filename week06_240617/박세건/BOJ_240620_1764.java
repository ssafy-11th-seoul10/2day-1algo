import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N, M;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        Set<String> set = new HashSet<>();
        for (int i = 0; i < N; i++) {
            set.add(bufferedReader.readLine());
        }
        List<String> stringList = new ArrayList<>();
        for (int i = 0; i < M; i++) {
            String tmp = bufferedReader.readLine();
            if (set.contains(tmp)) {
                stringList.add(tmp);
            }
        }
        Collections.sort(stringList);
        System.out.println(stringList.size());
        for (String tmp : stringList) {
            System.out.println(tmp);
        }
    }
}
