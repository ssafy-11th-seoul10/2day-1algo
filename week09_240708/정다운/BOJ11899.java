package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ11899 {

    static String data;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        data = br.readLine();

        Queue<Character> stack = new ArrayDeque<>();
        int cnt = 0;

        for(int i = 0; i < data.length(); i++) {

            char tmp = data.charAt(i);

            if(!stack.isEmpty()) {
                if(tmp == ')')
                    if(stack.peek() == '(')
                        stack.poll();
                    else
                        cnt++;
                else
                    stack.add(tmp);
            }
            else {
                if (tmp == ')')
                    cnt++;
                else
                    stack.add(tmp);
            }
        }

        // 남은 스택 원소 개수 -> cnt++
        cnt += stack.size();

        System.out.println(cnt);
    }
}
