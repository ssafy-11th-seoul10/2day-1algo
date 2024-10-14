import java.io.*;
import java.util.*;

public class Main {

    private static class Node {
        int visitBit;
        int time;

        public Node(int visitBit, int time) {
            this.visitBit = visitBit;
            this.time = time;
        }
    }

    private static int[][] field;
    private static Node[][] dists;
    private static int N, K, minTime;

    private static void floydWarshall() {
        for (int k = 0; k < N; k++) {
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < N; j++) {
                    if (dists[i][j].time > dists[i][k].time + dists[k][j].time){
                        dists[i][j].time = dists[i][k].time + dists[k][j].time;
                        dists[i][j].visitBit = dists[i][k].visitBit | dists[k][j].visitBit;
                    }
                }
            }
        }
    }

    private static void initDists(){
        dists = new Node[N][N];
        for (int i = 0; i < N; i++){
            for (int j = 0; j < N; j++){
                dists[i][j] = new Node((1 << i) | (1 << j), field[i][j]);
            }
        }

        floydWarshall();
    }

    private static void dfs(int visited, int cur, int totalTime){
        if (Integer.bitCount(visited) == N){
            minTime = Math.min(minTime, totalTime);
            return;
        }

        for (int i = 0; i < N; i++){
            if (i != cur && (visited & (1 << i)) == 0){
                int newVisited = visited | dists[cur][i].visitBit;
                dfs(newVisited, i, totalTime + dists[cur][i].time);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        minTime = Integer.MAX_VALUE;
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        field = new int[N][N];
        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < N; j++){
                field[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        initDists();
        dfs(0, K, 0);
        System.out.println(minTime);
    }

}
