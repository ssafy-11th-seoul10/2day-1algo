package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ17265 {

    static int N;
    static char[][] graph;
    static boolean[][] visited;

    public static boolean inRange(int x, int y) {
        return (0 <= x && x < N) && (0 <= y && y < N);
    }

    static char[] number = {'0', '1', '2', '3', '4', '5'};
    static char[] oper = {'+', '-', '*'};

    static int maxVal = -100000;
    static int minVal = 100000;

    public static int getNumber(int a, int b, char op) {
        if(op == '+')
            return a + b;
        else if (op == '-')
            return a - b;
        else if(op == '*')
            return a * b;
        else
            return -1000000;
    }

    public static boolean isNum(char tmp) {
        for(int i = 0; i < number.length; i++)
            if(number[i] == tmp)
                return true;
        return false;
    }

    public static void dfs(int x, int y, int val, char oper) {

        if(x == N - 1 && y == N - 1) {

            int res = getNumber(val, graph[x][y] - '0', oper);

            minVal = Math.min(minVal, res);
            maxVal = Math.max(maxVal, res);

            return;
        }

        if(x == 0 && y == 0) {
            dfs(x + 1, y, graph[0][0] - '0', '/');
            dfs(x, y + 1, graph[0][0] - '0', '/');
        }

        else {
            // 숫자 -> 계산
            if(isNum(graph[x][y])) {
                int res = getNumber(val, graph[x][y] - '0', oper);

                if(inRange(x + 1, y))
                    dfs(x + 1, y, res, '/');
                if(inRange(x, y+ 1))
                    dfs(x, y + 1, res, '/');
            }
            // oper -> 연산자 삽입
            else {
                char getOper = graph[x][y];

                if(inRange(x + 1, y))
                    dfs(x + 1, y, val, getOper);
                if(inRange(x, y+ 1))
                    dfs(x, y + 1, val, getOper);
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine());
        graph = new char[N][N];
        visited = new boolean[N][N];

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for(int j = 0; j < N; j++)
                graph[i][j] = st.nextToken().charAt(0);
        }

        dfs(0, 0, 0, '/');

        System.out.println(maxVal + " " + minVal);
    }
}
