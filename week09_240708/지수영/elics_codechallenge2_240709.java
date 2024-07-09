import java.util.*;
import java.io.*;

class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int len = Integer.parseInt(st.nextToken());
        int tc = Integer.parseInt(st.nextToken());

        int[] nums = new int[len];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < len; i++){
            nums[i] = Integer.parseInt(st.nextToken());
        }

        for(int t = 0; t < tc; t++){
            st = new StringTokenizer(br.readLine());
            int i = Integer.parseInt(st.nextToken());
            int j = Integer.parseInt(st.nextToken());
            int k = Integer.parseInt(st.nextToken());
            int[] newnums = Arrays.copyOfRange(nums, i-1, j);
            Arrays.sort(newnums);
            sb.append(newnums[k-1]).append("\n");
        }
        System.out.println(sb);
    }
}