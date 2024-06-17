import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static boolean[] isInValid;
    private static int N, M;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        Set<Integer> hasCards = new HashSet<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            hasCards.add(Integer.parseInt(stringTokenizer.nextToken()));
        }
        M = Integer.parseInt(bufferedReader.readLine());
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < M; i++) {
            if (hasCards.contains(Integer.parseInt(stringTokenizer.nextToken()))) {
                stringBuilder.append(1);
            } else {
                stringBuilder.append(0);
            }
            stringBuilder.append(" ");
        }
        System.out.println(stringBuilder);
    }
}
