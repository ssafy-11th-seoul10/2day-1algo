package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ4659 {

    static char[] empo = {'a', 'e', 'i', 'o', 'u'};

    public static boolean check(char ch) {
        for(char c : empo) {
            if(ch == c)
                return true;
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {
            String data = br.readLine();

            if(data.equals("end"))
                break;

            // 반복하되, e,o 제외 2번 연속 이상일 시 break 한다.
            char alpha = 0; int cnt = 0;
            int DepoCnt = 0; int EmpoCnt = 0;

            boolean isConti = true; boolean isEmpo = false;

            for(int i = 0; i < data.length(); i++) {

                if(i == 0) {
                    alpha = data.charAt(i);
                    cnt = 1;
                }

                else {
                    if(alpha == data.charAt(i))
                        cnt++;
                    else {
                        alpha = data.charAt(i);
                        cnt = 1;
                    }
                }

                if(check(alpha)) {
                    if(!isEmpo)
                        isEmpo = true;
                    DepoCnt = 0;
                    EmpoCnt++;
                }
                else {
                    EmpoCnt = 0;
                    DepoCnt++;
                }

                // 종료 조건 -> 연속 2개 이상
                if(cnt >= 2) {
                    if ((alpha == 'e' || alpha == 'o')) {
                        if(cnt > 2)
                            isConti = false;
                    }
                    else
                        isConti = false;
                }

                // 종료 조건 -> 자음 또는 모음 연속 3개
                if(DepoCnt >= 3 || EmpoCnt >= 3) {
                    isConti = false;
                }

                if(!isConti)
                    break;
            }

            // 정답 출력
            StringBuilder sb = new StringBuilder();
            if(isEmpo && isConti)
                sb.append("<").append(data).append("> is acceptable.");
            else
                sb.append("<").append(data).append("> is not acceptable.");

            System.out.println(sb);
        }

    }
}
