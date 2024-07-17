import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_20040_240717 {

    static int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }

    static void union(int x, int y) {
        x = find(x);
        y = find(y);
        if(x==y){
            possible = true;
            return;
        }
        if (x > y) {
            parent[x] = y;
        } else{
            parent[y] = x;
        }

    }

    static boolean possible;
    static int[] parent;

    public static void main(String[] args) throws IOException {


        //union-find를 진행하면서 union 전에 parent가 같다면 union 이후 사이클이 생성된 것
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer stk = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(stk.nextToken());
        int m = Integer.parseInt(stk.nextToken());
        parent = new int[n+1];
        for (int i = 1; i <= n; i++) {
            parent[i] = i;
        }

        int answer = 0;
        possible = false;

        for (int i = 0; i < m; i++) {
            stk = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(stk.nextToken());
            int b = Integer.parseInt(stk.nextToken());
            if(!possible){
                answer++;
                union(a, b);
            }
        }
        if(possible) System.out.println(answer);
        else System.out.println(0);

    }
}
