import java.io.*;
import java.util.*;

public class Main {
    static int N;
    static List<Integer> list = new ArrayList<>();

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for(int i=0;i<N;i++){
            int now = Integer.parseInt(st.nextToken());
            if(list.isEmpty()){
                list.add(now);
                continue;
            }

            if(list.get(list.size()-1) < now){
                list.add(now);
                continue;
            }
            int s = 0;
            int e = list.size() - 1;

            while(s < e){
                int mid = (s + e) / 2 ;

                // 시간 초과 유의 할 것
                if(list.get(mid) <= now){
                    s = mid + 1;
                }
                else{
                    e = mid;
                }
            }
            list.set(s, now);
        }

        System.out.println(list.size());
    }
}
