package baekjoon;

import java.io.*;

public class BOJ1439 {

    static String S;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        S = br.readLine();

        int zero_cnt = 0; int one_cnt = 0;
        boolean isZero = false;

        for(int i = 0; i < S.length(); i++) {

            char ch = S.charAt(i);

            if(ch == '0') {
                if(!isZero) {
                    isZero = true;
                    zero_cnt++;
                }
            }

            else {
                // 시작점이 1인 경우
                if(i == 0)
                    one_cnt++;

                if(isZero) {
                    isZero = false;
                    one_cnt++;
                }
            }
        }

        if((zero_cnt == 1 && one_cnt == 0) || (zero_cnt == 0 && one_cnt == 1))
            System.out.println(0);
        else
        {
            if(zero_cnt < one_cnt)
                System.out.println( zero_cnt );
            else
                System.out.println( one_cnt );
        }
    }
}
