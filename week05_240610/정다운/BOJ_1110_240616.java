package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1110 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String getInput = br.readLine();

        char[] num = new char[2];
        num[1] = '0';
        for(int idx = 0; idx < getInput.length(); idx++)
            num[idx] = getInput.charAt(idx);

        char[] tmp = new char[2];
        tmp[0] = num[0]; tmp[1] = num[1];

        int cnt = 0;

        while (true) {

            if((num[0] == tmp[0] && num[1] == tmp[1]) && cnt != 0)
                break;

            int nextNum = (tmp[0] - '0') + (tmp[1] - '0');
            String temp = String.valueOf(nextNum);

            tmp[0] = tmp[1]; tmp[1] = temp.charAt(temp.length() - 1);

            cnt++;
        }

        System.out.println(cnt);
    }
}
