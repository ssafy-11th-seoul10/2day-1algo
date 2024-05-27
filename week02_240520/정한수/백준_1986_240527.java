import java.io.*;
import java.util.*;

public class Main {

    private static int N, M;
    private static int[][] board;
    private static int safeZones;

    private static void setUnit(int r, int c){
        if (board[r][c] == 0){
            safeZones--;
        }
        board[r][c] = 2;
    }

    private static void setDangerZone(int r, int c){
        if (r < 0 || c < 0 || r >= N || c >= M){
            return;
        }

        if (board[r][c] == 0){
            board[r][c] = 1;
            safeZones--;
        }
    }

    private static void setQueen(int r, int c){
        setUnit(r, c);
        for (int i = 1; r - i >= 0 && board[r - i][c] != 2; i++)
            setDangerZone(r - i, c);
        for (int i = 1; r + i < N && board[r + i][c] != 2; i++)
            setDangerZone(r + i, c);
        for (int j = 1; c - j >= 0 && board[r][c - j] != 2; j++)
            setDangerZone(r, c - j);
        for (int j = 1; c + j < M && board[r][c + j] != 2; j++)
            setDangerZone(r, c + j);
        for (int n = 1; r - n >= 0 && c - n >= 0 && board[r - n][c - n] != 2; n++)
            setDangerZone(r - n, c - n);
        for (int n = 1; r - n >= 0 && c + n < M && board[r - n][c + n] != 2; n++)
            setDangerZone(r - n, c + n);
        for (int n = 1; r + n < N && c - n >= 0 && board[r + n][c - n] != 2; n++)
            setDangerZone(r + n, c - n);
        for (int n = 1; r + n < N && c + n < M && board[r + n][c + n] != 2; n++)
            setDangerZone(r + n, c + n);
    }

    private static void setKnight(int r, int c){
        setUnit(r, c);
        setDangerZone(r - 2, c - 1);
        setDangerZone(r + 2, c - 1);
        setDangerZone(r - 2, c + 1);
        setDangerZone(r + 2, c + 1);
        setDangerZone(r - 1, c - 2);
        setDangerZone(r + 1, c - 2);
        setDangerZone(r - 1, c + 2);
        setDangerZone(r + 1, c + 2);
    }

    private static void setPawn(int r, int c){
        setUnit(r, c);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        List<int[]> queens = new ArrayList<>();
        int num;

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        board = new int[N][M];
        safeZones = N * M;

        //Queen
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int j = 0; j < num; j++){
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            queens.add(new int[]{r, c});
        }
        //Knight
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int j = 0; j < num; j++){
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            setKnight(r, c);
        }
        //Pawn
        st = new StringTokenizer(br.readLine());
        num = Integer.parseInt(st.nextToken());
        for (int j = 0; j < num; j++){
            int r = Integer.parseInt(st.nextToken()) - 1;
            int c = Integer.parseInt(st.nextToken()) - 1;
            setPawn(r, c);
        }

        for (int[] queen : queens){
            setQueen(queen[0], queen[1]);
        }

        System.out.println(safeZones);
    }

}
