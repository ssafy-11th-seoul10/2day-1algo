import java.io.*;
import java.util.*;

public class Main {

    private static int getLis(int[] soldiers, int N) {
        int[] lis = new int[N];
        int top = 0;

        for (int soldier : soldiers) {
            int idx = Arrays.binarySearch(lis, 0, top, soldier);

            if (idx < 0){
                idx = -idx - 1;
            }
            lis[idx] = soldier;
            top = Math.max(top, idx + 1);
        }
        return top;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] soldiers = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = N - 1; i >= 0; i--){
            soldiers[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(N - getLis(soldiers, N));
    }

}
