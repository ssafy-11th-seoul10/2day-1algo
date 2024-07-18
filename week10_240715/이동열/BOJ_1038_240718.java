package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BOJ1038 {

    private static int N, num;
    private static StringBuilder sb = new StringBuilder();
    private static List<Long> lst = new ArrayList<>();

    private static void sol(int len){
        for (int i = 0; i <=9; i++) {
            if(len == 0 || sb.toString().charAt(len-1)-'0'>i){
                sb.append(i);
                lst.add(Long.parseLong(sb.toString()));
                sol(len+1);
                sb.deleteCharAt(len);
            }else{
                return;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        num = 0;
        sol(0);
        Collections.sort(lst);
        if(N<lst.size()) {
            System.out.println(lst.get(N));
        }else{
            System.out.println(-1);
        }
    }
}
