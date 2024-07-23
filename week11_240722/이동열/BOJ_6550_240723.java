package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ6550 {

    private static boolean sol(String s, String t){
        int p1 = 0;
        int p2 = 0;
        boolean flag = false;
        while (p1<s.length() && p2<t.length()){
            if(s.charAt(p1)==t.charAt(p2)){
                p1++;
                p2++;
            }
            else {
                p2++;
            }
            if(p1==s.length()){
                flag=true;
                break;
            }
        }
        return flag;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String line;

        while ((line = br.readLine()) !=null){
            StringTokenizer st = new StringTokenizer(line);
            if(!st.hasMoreTokens()){
                break;
            }
            String s = st.nextToken();
            String t = st.nextToken();
            if(sol(s,t)){
                sb.append("Yes");
            }else{
                sb.append("No");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }

}
