package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ1380 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        String[] students;
        int[] checkList;

        int n = Integer.parseInt(br.readLine());
        int number = 1;
        //System.out.println("inital size : " + n);

        while (n != 0) {

            students = new String[n + 1];
            checkList = new int[n + 1];

            // 학생이름
            for (int i = 1; i <= n; i++)
                students[i] = br.readLine();

            while (true) {
                st = new StringTokenizer(br.readLine());
                int cnt = Integer.parseInt(st.nextToken());

                if (!st.hasMoreTokens()) {
                    n = cnt;
                    break;
                } else {
                    char flag = st.nextToken().charAt(0);
                    checkList[cnt]++;
                }
            }

            for (int i = 1; i < checkList.length; i++) {
                if (checkList[i] == 1) {
                    System.out.println(number + " " + students[i]);
                    break;
                }
            }

            //System.out.println("size" + n);
            number++;
        }
    }
}
