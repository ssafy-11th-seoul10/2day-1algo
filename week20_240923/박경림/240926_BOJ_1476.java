import java.io.*;
import java.util.*;

public class Main {
    private static int E, S, M;
    
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        E = Integer.parseInt(st.nextToken());
        S = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        int year = 1;
        while (true) {
            if ((year % 15 == E || (E == 15 && year % 15 == 0)) &&
                (year % 28 == S || (S == 28 && year % 28 == 0)) &&
                (year % 19 == M || (M == 19 && year % 19 == 0))) {
                break;
            }
            year++;
        }
        System.out.println(year);
    }
}
