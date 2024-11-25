import java.io.*;
import java.util.*;

public class Main {

    private static int[][] field;
    private static int N, M, D;
    private static int allEnemies;

    // 선택된 적군 삭제
    private static void killEnemies(BitSet enemies){
        int enemy = -1;
        while ((enemy = enemies.nextSetBit(enemy + 1)) >= 0) {
            field[enemy / M][enemy % M] = 0;
        }
    }

    // 되돌리기
    private static void undoEnemies(BitSet enemies){
        int enemy = -1;
        while ((enemy = enemies.nextSetBit(enemy + 1)) >= 0) {
            field[enemy / M][enemy % M] = 1;
        }
    }

    // 공격할 적군 선별
    private static void shootEnemies(BitSet enemies, int archer, int turn){
        for (int d = 0; d < D; d++){
            for (int j = Math.max(archer - d, 0); j <= Math.min(archer + d, M - 1); j++){
                int i = Math.max(N - turn - 1 - Math.abs(d - Math.abs(archer - j)), 0);
                if (field[i][j] == 1){
                    enemies.set(i * M + j);
                    return;
                }
            }
        }
    }

    // 궁수 위치가 정해졌을 때의 최대 사살 가능한 적군 수 계산
    private static int simulateCaseOf(int[] archers){
        BitSet enemies = new BitSet(N * M);
        int turn = 0;

        while (turn < N && enemies.cardinality() < allEnemies){
            for (int archer : archers) {
                shootEnemies(enemies, archer, turn);
            }
            killEnemies(enemies);
            turn++;
        }
        undoEnemies(enemies);
        return enemies.cardinality();
    }

    // 모든 경우의 수 고려
    private static int simulateAllCases(){
        int[] archers = new int[3];
        int maxEnemies = 0;

        for (archers[0] = 0; archers[0] < M - 2; archers[0]++) {
            for (archers[1] = archers[0] + 1; archers[1] < M - 1; archers[1]++) {
                for (archers[2] = archers[1] + 1; archers[2] < M; archers[2]++) {
                    int simulatedEnemies = simulateCaseOf(archers);

                    maxEnemies = Math.max(maxEnemies, simulatedEnemies);
                    if (maxEnemies == allEnemies){
                        return allEnemies; // 조기 탈출
                    }
                }
            }
        }
        return maxEnemies;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        allEnemies = 0;
        field = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                field[i][j] = Integer.parseInt(st.nextToken());
                if (field[i][j] == 1){
                    allEnemies++;
                }
            }
        }

        System.out.println(simulateAllCases());
    }
    
}
