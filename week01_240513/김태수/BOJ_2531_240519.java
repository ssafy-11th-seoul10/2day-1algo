import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] info = br.readLine().split(" ");
        int n = Integer.parseInt(info[0]);
        int d = Integer.parseInt(info[1]);
        int k = Integer.parseInt(info[2]);
        int c = Integer.parseInt(info[3]);

        Map<Integer, Integer> eatCount = new HashMap<>();

        int[] eat = new int[n];

        for (int i = 0; i < n; i++) {
            eat[i] = Integer.parseInt(br.readLine());
        }

        // 처음부터 먹기
        eatCount.put(c, 1);
        for (int i = 0; i < k; i++) {
            eatCount.put(eat[i], eatCount.getOrDefault(eat[i], 0) + 1);
        }

        int maxCount = eatCount.size();

        //윈도우 슬라이드
        int left = 0;
        for (int i = k; i <= n + k; i++) {
            int remove = eat[left++ % n];
            int add = eat[i % n];

            eatCount.put(remove, eatCount.get(remove) - 1);
            if (eatCount.get(remove) == 0) {
                eatCount.remove(remove);
            }

            eatCount.put(add, eatCount.getOrDefault(add, 0) + 1);

            maxCount = Math.max(maxCount, eatCount.size());
        }

        System.out.println(maxCount);
    }
}
