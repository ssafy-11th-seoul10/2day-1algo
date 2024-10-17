import java.io.*;
import java.util.*;

public class Main {

    private static boolean isReverseOrder = false;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());
        TreeMap<Integer, TreeSet<Integer>> iceCreams = new TreeMap<>();
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++){
            int amount = Integer.parseInt(st.nextToken());

            iceCreams.putIfAbsent(amount, new TreeSet<>());
            iceCreams.get(amount).add(i);
        }

        while (M-- > 0){
            TreeSet<Integer> indices = iceCreams.lastEntry().getValue();

            if (isReverseOrder){
                sb.append(indices.pollLast()).append('\n');
            } else {
                sb.append(indices.pollFirst()).append('\n');
            }

            if (iceCreams.lastKey() % 7 == 0){
                isReverseOrder = !isReverseOrder;
            }

            if (indices.isEmpty()){
                iceCreams.pollLastEntry();
            }
        }

        System.out.print(sb);
    }

}
