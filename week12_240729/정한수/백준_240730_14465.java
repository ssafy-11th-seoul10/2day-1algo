import java.io.*;
import java.util.*;

public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, curRepair = 0, minRepair = 100_000;
        boolean[] isBroken = new boolean[N + 1];

        for (int i = 0; i < B; i++){
            int sign = Integer.parseInt(br.readLine());
            isBroken[sign] = true;
        }

        while (r < K){
            if (isBroken[r++]) curRepair++;
        }

        while (r <= N){
            if (isBroken[l++]) curRepair--;
            if (isBroken[r++]) curRepair++;
            minRepair = Math.min(minRepair, curRepair);
        }

        System.out.println(minRepair);
    }

}
