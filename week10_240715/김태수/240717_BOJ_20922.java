import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLine = br.readLine().split(" ");
        int n = Integer.parseInt(firstLine[0]);
        int k = Integer.parseInt(firstLine[1]);

        int[] arr = new int[n];
        String[] arrStr = br.readLine().split(" ");
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(arrStr[i]);
        }

        int result = 0;

        Map<Integer, Integer> map = new HashMap<>();

        int left = 0;
        int right = 0;

        while (left <= right && right < n) {
            int now = arr[right];
            map.put(now, map.getOrDefault(now, 0) + 1);

            while (map.get(arr[right]) > k) {
                int pre = arr[left++];
                map.put(pre, map.get(pre) - 1);
            }
            right++;
            result = Math.max(result, right - left);
        }

        System.out.println(result);
    }
}
