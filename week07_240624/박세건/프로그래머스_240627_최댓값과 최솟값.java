import java.io.*;
import java.util.*;

class Solution {
    private BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    private StringTokenizer st;
    private StringBuilder sb=new StringBuilder();
    public String solution(String s) throws Exception{
        String answer = "";
        st=new StringTokenizer(s);
        int max=Integer.MIN_VALUE;
        int min=Integer.MAX_VALUE;
        while(st.hasMoreTokens()){
            int x= Integer.parseInt(st.nextToken());
            max=Math.max(x,max);
            min=Math.min(x,min);
        }
        sb.append(min).append(" ").append(max);
        return sb.toString();
    }
}
