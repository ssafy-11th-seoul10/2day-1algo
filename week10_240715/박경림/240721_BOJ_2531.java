import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int d = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(br.readLine());
        }

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < k; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
        }
        int result = map.size() + (map.containsKey(c) ? 0 : 1);

        for (int i = 0; i < n - 1; i++) {
            if (map.get(arr[i]) == 1) {
                map.remove(arr[i]);
            } else {
                map.put(arr[i], map.get(arr[i]) - 1);
            }

            map.put(arr[(i + k) % n], map.getOrDefault(arr[(i + k) % n], 0) + 1);

            result = Math.max(result, map.size() + (map.containsKey(c) ? 0 : 1));
        }

        System.out.println(result);
    }
}
