import java.util.*;
import java.io.*;

public class Main {
    static int N;
    
    static class Info implements Comparable<Info>{
        int idx;
        int age;
        String name;

        Info(int idx, int age, String name){
            this.idx = idx;
            this.age = age;
            this.name = name;
        }

        @Override
        public int compareTo(Info a){
            if(this.age == a.age){
                return this.idx - a.idx;
            }
            return this.age - a.age;
        }

        public String toString(){
            return this.age + " " + this.name + "\n";
        }
    }
    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = null;
        StringBuilder sb = new StringBuilder();
        
        N = Integer.parseInt(br.readLine());
        Info[] infos = new Info[N];
        
        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());
            int age = Integer.parseInt(st.nextToken());
            String name = st.nextToken();
            
            infos[i] = new Info(i, age, name);
        }
        
        Arrays.sort(infos);

        for(Info i : infos){
            sb.append(i.toString());
        }
        System.out.println(sb);
    }
}