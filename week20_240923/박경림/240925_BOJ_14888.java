import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int num[];
    static int[] op = new int[4];
    static int max = -1_000_000_000, min = 1_000_000_000;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        num = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            num[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < 4; i++) {
            op[i] = Integer.parseInt(st.nextToken());
        }
        dfs(0, num[0]);
        System.out.println(max);
        System.out.println(min);
    }
    
    static void dfs(int idx, int sum) {
        if (idx == n - 1) {
            max = Math.max(max, sum);
            min = Math.min(min, sum);
            return;
        }
        
        if (op[0] > 0) {
            op[0]--;
            dfs(idx + 1, sum + num[idx + 1]);
            op[0]++;
        } 
        if (op[1] > 0) {
            op[1]--;
            dfs(idx + 1, sum - num[idx + 1]);
            op[1]++;
        }
        if (op[2] > 0) {
            op[2]--;
            dfs(idx + 1, sum * num[idx + 1]);
            op[2]++;
        } 
        if (op[3] > 0) {
            op[3]--;
            dfs(idx + 1, sum / num[idx + 1]);
            op[3]++;
        }
    }
}
