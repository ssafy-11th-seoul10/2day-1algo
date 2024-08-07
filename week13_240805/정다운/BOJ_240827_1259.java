package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1259 {


    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while (true) {

            String tmp = br.readLine();

            if(tmp.equals("0"))
                break;

            int cnt = tmp.length() / 2;
            boolean isPell = true;

            for(int i = 0; i < cnt; i++) {

                char head = tmp.charAt(i);
                char tail = tmp.charAt( tmp.length() - 1 - i );

                if(head != tail) {
                    isPell = false;
                    break;
                }
            }

            if(isPell)
                System.out.println("yes");
            else
                System.out.println("no");
        }

    }

}
