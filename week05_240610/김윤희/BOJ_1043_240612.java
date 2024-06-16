import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_1043 {

    static int N, M;
    static boolean[] check;
    static List<int[]> list;

    public static void main(String[] args) throws Exception{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int K = Integer.parseInt(st.nextToken());

        HashSet<Integer> set = new HashSet<>();
        for(int i = 0; i < K; i++) {
            set.add(Integer.parseInt(st.nextToken()));
        }

        check = new boolean[M];
        list = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int p = Integer.parseInt(st.nextToken());
            int[] per = new int[p];
            for(int j = 0; j < p; j++) {
                per[j] = Integer.parseInt(st.nextToken());
                if (set.contains(per[j])){
                    check[i] = true;
                }
            }
            list.add(per);
            if (check[i]){
                for(int j = 0; j < p; j++) {
                    if (!set.contains(per[j])){
                        set.add(per[j]);
                    }
                }
            }
        }

        while(true) {
            boolean aa = false;
            for(int i = 0; i < M; i++) {
                if (!check[i]){
                    int[] a = list.get(i);
                    for(int j = 0; j < a.length; j++) {
                        if (set.contains(a[j])){
                            check[i] = true;
                            aa = true;
                            break;
                        }
                    }
                    if (check[i]){
                        for(int j = 0; j < a.length; j++) {
                            if (!set.contains(a[j])){
                                set.add(a[j]);
                            }
                        }
                    }
                }
            }
            if (!aa) break;
        }

        int result = 0;
        for(int i = 0; i < M; i++) {
            if (!check[i]){
                result++;
            }
        }

        System.out.println(result);
    }
}
