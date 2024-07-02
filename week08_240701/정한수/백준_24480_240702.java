import java.io.*;
import java.util.*;

public class Main {

    private static int[] orders;
    private static int order = 1;

    private static int readInt() throws IOException{
        int c, n = 0;

        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static void dfs(PriorityQueue<Integer>[] adj, BitSet visited, int cur){
        visited.set(cur);
        orders[cur] = order++;

        while(!adj[cur].isEmpty()){
            int next = adj[cur].remove();

            if (visited.get(next)){
                continue;
            }
            dfs(adj, visited, next);
        }
    }

    public static void main(String[] args) throws IOException {
        int N = readInt(), M = readInt(), R = readInt();
        StringBuilder sb = new StringBuilder();
        PriorityQueue<Integer>[] adj = new PriorityQueue[N + 1];
        BitSet visited = new BitSet();

        for (int i = 1; i <= N; i++){
            adj[i] = new PriorityQueue<>(Comparator.reverseOrder());
        }

        for (int i = 0; i < M; i++){
            int a = readInt(), b = readInt();
            adj[a].add(b);
            adj[b].add(a);
        }

        orders = new int[N + 1];
        dfs(adj, visited, R);

        for (int i = 1; i <= N; i++){
            sb.append(orders[i]).append('\n');
        }
        System.out.println(sb);
    }

}
