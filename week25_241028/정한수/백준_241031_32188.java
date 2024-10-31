import java.io.*;
import java.util.*;

public class Main {

    private static final int RED_PORTAL = 0, BLUE_PORTAL = 1, CELL = 2;
    private static final int INF = 1_000_000_000;

    private static class Cell {
        int type, cost;
        int start, end;

        public Cell(int type, int cost, int start) {
            this.type = type;
            this.cost = cost;
            this.start = start;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        Cell[] line = new Cell[N];

        for (int i = 0; i < N; i++){
            line[i] = new Cell(CELL, INF, i);
        }
        line[0].cost = 0;

        for (int i = 0; i < C; i++){
            st = new StringTokenizer(br.readLine());
            int type = Integer.parseInt(st.nextToken());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            line[start].type = type;
            line[start].start = start;
            line[start].end = end;
        }

        System.out.println(getMinTime(line, N));
    }

    private static int getMinTime(Cell[] line, int N){
        Deque<Cell> dq = new ArrayDeque<>();

        dq.addLast(line[0]);
        while(!dq.isEmpty()){
            Cell cell = dq.removeFirst();

            if (cell.type != CELL){
                Cell next = line[cell.end];

                if (cell.cost < next.cost) {
                    next.cost = cell.cost;
                    dq.addFirst(next);
                }
            }

            if (cell.start == N - 1){
                return cell.cost;
            }

            if (cell.type != RED_PORTAL){
                Cell next = line[cell.start + 1];

                if (cell.cost + 1 < next.cost) {
                    next.cost = cell.cost + 1;
                    dq.addLast(next);
                }
            }
        }

        return -1;
    }

}
