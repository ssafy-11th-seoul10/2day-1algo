BFS를 통해서 해결하려 했지만 BFS는 탐색하면서 모든 정보를 기록하면서 진행하기 때문에 메모리 초과가 발생
  이를 해결하기위해서 DFS를 사용해서 탐색후 메모리를 반환하며 메모리를 효율적으로 관리해서 해결

--------------------------------------------------------

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();


    private static int[] dix = {-1, 0, 1, 0};
    private static int[] diy = {0, 1, 0, -1};

    private static char[][] map;
    private static int N, M;
    private static int answer;

    public static void main(String[] args) throws IOException {
        stringTokenizer = new StringTokenizer(bufferedReader.readLine());
        N = Integer.parseInt(stringTokenizer.nextToken());
        M = Integer.parseInt(stringTokenizer.nextToken());
        answer = 0;
        map = new char[N][M];
        for (int i = 0; i < N; i++) {
            String inputTmp = bufferedReader.readLine();
            for (int j = 0; j < M; j++) {
                map[i][j] = inputTmp.charAt(j);
            }
        }
        dfs(0, 0, 1, wordToBinary(map[0][0]));
        System.out.println(answer);
    }

    private static void dfs(int x, int y, int cnt, int visitedWordByBinary) {
        answer = Math.max(answer, cnt);
        for (int i = 0; i < 4; i++) {
            int dx = x + dix[i];
            int dy = y + diy[i];
            if (dx < 0 || dx >= N || dy < 0 || dy >= M) {
                continue;
            }
            int wordByBit = wordToBinary(map[dx][dy]);
            if (!isVisitedWord(visitedWordByBinary, wordByBit)) {
                dfs(dx, dy, cnt + 1, visitedWordByBinary | wordByBit);
            }
        }
    }

    private static int wordToBinary(char word) {
        return 1 << (word - 'A');
    }


    private static boolean isVisitedWord(int visitedWord, int wordByBit) {
        if ((visitedWord & wordByBit) == wordByBit) {
            return true;
        }
        return false;

    }
}
