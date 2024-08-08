package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ2578 {

    static int[][] board = new int[5][5];
    static boolean[][] visited = new boolean[5][5];
    static Set<List<Integer>> bingo = new HashSet<>();

    public static void check() {

        // garo
        for(int i = 0; i < 5; i++) {
            boolean f = true;
            List<Integer> list = new ArrayList<>();

            for(int j = 0; j < 5; j++) {
                if (!visited[i][j]) {
                    f = false;
                    break;
                }
                list.add(board[i][j]);
            }
            if(f) {
                bingo.add(list);
            }
        }
        // sero
        for(int j = 0; j < 5; j++) {
            boolean f = true;
            List<Integer> list = new ArrayList<>();

            for(int i = 0; i < 5; i++) {
                if (!visited[i][j]) {
                    f = false;
                    break;
                }
                list.add(board[i][j]);
            }
            if(f) {
                bingo.add(list);
            }
        }
        // daegak 1
        int stx = 0; int sty = 0;
        boolean f = true;
        List<Integer> list = new ArrayList<>();

        for(int i = 0; i < 5; i++) {
            if(!visited[stx][sty]){
                f = false;
                break;
            }
            list.add(board[stx][sty]);
            stx = stx + 1; sty = sty + 1;
        }
        if(f) {
            bingo.add(list);
        }
        // daegak 2
        stx = 0; sty = 4;
        f = true;
        list = new ArrayList<>();
        for(int i = 0; i < 5; i++) {
            if(!visited[stx][sty]){
                f = false;
                break;
            }
            list.add(board[stx][sty]);
            stx = stx + 1; sty = sty - 1;
        }
        if(f)
            bingo.add(list);
    }

    static int cnt = 0; static int bingoCnt = 0;
    static Map<Integer, int[]> map = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
                map.put(board[i][j], new int[] {i, j});
            }
        }

        for(int i = 0; i < 5; i++) {
            st = new StringTokenizer(br.readLine());

            for(int j = 0; j < 5; j++) {

                int[] pos = map.get(Integer.parseInt(st.nextToken()));
                visited[pos[0]][pos[1]] = true;
                check();
                if(bingo.size() >= 3)
                    break;
                cnt++;
            }
        }

        System.out.println(cnt + 1);
    }
}
