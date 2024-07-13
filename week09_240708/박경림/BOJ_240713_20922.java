import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int arr[] = new int[n];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Map<Integer, Integer> map = new HashMap<>();
        int result = 0;
        int start = 0;
        int end = 0;

        while (start < n) {
            while (end < n) {
                if (map.getOrDefault(arr[end], 0) + 1 > k) {
                    break;
                } else {
                    map.put(arr[end], map.getOrDefault(arr[end], 0) + 1);
                }
                end++;
            }
            result = Math.max(result, end - start);
            map.put(arr[start], map.get(arr[start]) - 1);
            start++;
        }
        System.out.println(result);
    }
}
