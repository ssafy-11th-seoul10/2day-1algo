import java.io.*;
import java.util.*;

public class Main {
    static List<Pair> Steel = new ArrayList<Pair>();

    static class Pair{
        int M, P;

        Pair(int m, int p){
            this.M = m;
            this.P = p;
        }

        public String toString(){
            return "[ " + this.M+ " ,"+ this.P+ " ]";
        }

    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        int W = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            st = new StringTokenizer(br.readLine());

            int m = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            Steel.add(new Pair(m, p));
        }

        Collections.sort(Steel, (o1, o2) -> o2.P - o1.P);

        // for(int i=0;i<N;i++){
        //     sb.append(Steel.get(i).toString());      
        // }

        int answer = 0;

        for(int i=0;i<N;i++){
            if(W == 0) break;
            if(W >= Steel.get(i).M){
                answer += Steel.get(i).M * Steel.get(i).P;
                W -= Steel.get(i).M;
            }else{
                answer += (W)* Steel.get(i).P;
                W = 0;
            }
        }
        sb.append(answer);

        System.out.println(sb);
    }
}
