import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();
    private static int N;


    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(bufferedReader.readLine());
        List<Integer> inputList = new ArrayList<>();
        Set<Integer> set = new TreeSet<>();
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(stringTokenizer.nextToken());
            inputList.add(x);
            set.add(x);
        }
        Map<Integer, Integer> map = new HashMap<>();
        int idx = 0;
        for (Integer x : set) {
            map.put(x, idx);
            idx++;
        }
        for (Integer x : inputList) {
            stringBuilder.append(map.get(x)).append(" ");
        }
        System.out.println(stringBuilder);

    }
}
