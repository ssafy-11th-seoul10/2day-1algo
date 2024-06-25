import java.io.*;
import java.util.*;

public class Main {
    static int N, M, S, T;
    static boolean canReach;
    static List<List<Integer>> oGraph = new ArrayList<>();
    static List<List<Integer>> rGraph = new ArrayList<>();
    static boolean[] sVisited = new boolean[100001];
    static boolean[] srVisited = new boolean[100001];
    static boolean[] eVisited = new boolean[100001];
    static boolean[] erVisited = new boolean[100001];

    // static void bfs(int s, int e, boolean[] visited, List<List<Integer>> graph){
    //     Queue<Integer> q = new LinkedList<>();
    //     q.add(s);

    //     while(!q.isEmpty()){
    //         int v = q.poll();

    //         if(v == e){
    //             canReach = true;
    //             continue;
    //         }

    //         if(visited[v]) continue;
    //         visited[v] = true;

    //         for(int i=0;i<graph.get(v).size();i++){
    //             int w = graph.get(v).get(i);

    //             if(visited[w]) continue;
    //             q.add(w);
    //         }
    //     }
    // }

    static void dfs(int v, int e, boolean[] visited, List<List<Integer>> graph){
        if(v == e){
            return;
        }
        if(visited[v]) return;
        visited[v] = true;

        for(int i=0;i<graph.get(v).size();i++){
            int w = graph.get(v).get(i);

            if(visited[w]) continue;
            dfs(w, e, visited, graph);
        }
    }



    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        for(int i=0;i<N;i++){
            oGraph.add(new ArrayList<Integer>());
            rGraph.add(new ArrayList<Integer>());
        }

        for(int i=0;i<M;i++){
            st = new StringTokenizer(br.readLine());
            int a, b;
            a = Integer.parseInt(st.nextToken()) - 1;
            b = Integer.parseInt(st.nextToken()) - 1;

            oGraph.get(a).add(b); // 단방향
            rGraph.get(b).add(a); // 단방
        }

        st = new StringTokenizer(br.readLine());
        S = Integer.parseInt(st.nextToken()) - 1;
        T = Integer.parseInt(st.nextToken()) - 1;

        // 순방향, 역방향으로 검사해서 같은 부분 있는게
        dfs(S, T, sVisited, oGraph);
        dfs(T, -1, srVisited, rGraph);
        for(int i=0; i<N;i++){
            if(sVisited[i] == srVisited[i]) continue;
            else sVisited[i] = false;
        }

        dfs(T, S, eVisited, oGraph);
        dfs(S, -1, erVisited, rGraph);
        for(int i=0; i<N;i++){
            if(eVisited[i] == erVisited[i]) continue;
            else eVisited[i] = false;
        }

        int ans = 0;
        for(int i=0; i<N;i++){
            if(eVisited[i] == sVisited[i] && sVisited[i]) ans++;
        }

        System.out.println(ans);
    }
}