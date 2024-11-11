import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] tanghuru = new int[n];
        Map<Integer, Integer> fruits = new HashMap<>();
        
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            tanghuru[i] = Integer.parseInt(st.nextToken());
        }
        
        int result = 0;
        int start = 0;
        
        for (int end = 0; end < n; end++) {
            fruits.put(tanghuru[end], fruits.getOrDefault(tanghuru[end], 0) + 1);
            
            while (fruits.size() > 2) {
                fruits.put(tanghuru[start], fruits.get(tanghuru[start]) - 1);
                if (fruits.get(tanghuru[start]) == 0) {
                    fruits.remove(tanghuru[start]);
                }
                start++;
            }
            
            result = Math.max(result, end - start + 1);
        }
        
        System.out.println(result);
    }
}
