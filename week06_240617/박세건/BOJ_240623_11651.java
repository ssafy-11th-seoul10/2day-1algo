import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        List<int[]> inputList = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            stringTokenizer = new StringTokenizer(bufferedReader.readLine());
            int x = Integer.parseInt(stringTokenizer.nextToken());
            int y = Integer.parseInt(stringTokenizer.nextToken());
            inputList.add(new int[]{x, y});
        }
        Collections.sort(inputList, (a, b) -> {
            if (a[1] == b[1]) {
                return Integer.compare(a[0], b[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        for (int i = 0; i < N; i++) {
            System.out.println(inputList.get(i)[0] + " " + inputList.get(i)[1]);
        }
    }
}
