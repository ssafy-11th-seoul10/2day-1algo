import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class 백준_240721_1302 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new HashMap<>();

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());

            String s = st.nextToken();
            if (!map.containsKey(s)) {
                map.put(s, 1);
            } else {
                map.put(s, map.get(s) + 1);
            }
        }

        PriorityQueue<String> pq = new PriorityQueue<>(((o1, o2) -> {
            if (map.get(o1) != map.get(o2)) {
                return map.get(o2) - map.get(o1);
            } else {
                return o1.compareTo(o2);
            }
        }));

        for (String s : map.keySet()) {
            pq.add(s);
        }

        sb.append(pq.poll());
        System.out.println(sb);

    }
}
