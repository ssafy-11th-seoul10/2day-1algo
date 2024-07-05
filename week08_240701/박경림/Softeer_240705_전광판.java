import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine());
        StringTokenizer st;
        byte[] num = new byte[10];
        initArr(num);
        // System.out.println(Arrays.toString(num));
        int result = 0;
        StringBuilder sb = new StringBuilder();
        while (t-- > 0) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            result = 0;
            while (a > 0 || b > 0) {
                int al = a % 10;
                int bl = b % 10;
                if (a == 0) {
                    for (int i = 1; i <= 7; i++) {
                        if ((num[bl] & (1 << i)) != 0)
                            result++;
                    }
                } else if (b == 0) {
                    for (int i = 1; i <= 7; i++) {
                        if ((num[al] & (1 << i)) != 0)
                            result++;
                    }
                } else {
                    for (int i = 1; i <= 7; i++) {
                        if ((num[al] & (1 << i)) != (num[bl] & (1 << i))) 
                            result++;
                    }
                }
                a /= 10;
                b /= 10;
            }
            sb.append(result).append("\n");
        }
        System.out.println(sb);
    }

    private static void initArr(byte[] arr) {
        for (int i = 0; i < 10; i++) {
            if (i == 1 || i == 4) continue;
            arr[i] |= (1 << 1);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 1 || i == 2 || i == 3) continue;
            arr[i] |= (1 << 2);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 5 || i == 6) continue;
            arr[i] |= (1 << 3);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 0 || i == 1 || i == 7) continue;
            arr[i] |= (1 << 4);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 1 || i == 3 || i == 4 || i == 5 || i == 7 || i == 9) continue;
            arr[i] |= (1 << 5);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 2) continue;
            arr[i] |= (1 << 6);
        }
        for (int i = 0; i < 10; i++) {
            if (i == 1 || i == 4 || i == 7) continue;
            arr[i] |= (1 << 7);
        }
     }
}
