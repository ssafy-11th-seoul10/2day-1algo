import java.io.*;
import java.util.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;

        while ((c = System.in.read()) > 32 && Character.isDigit(c)){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static int readTimeAsMs() throws IOException{
        final int[] weight = {60 * 60 * 1000, 60 * 1000, 1000, 1};
        int idx = 0, ms = 0;

        for(int i = 0; i < 4; i++){
            ms += readInt() * weight[idx++];
        }
        return ms;
    }

    public static void main(String[] args) throws IOException {
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(o -> o[1]));
        int N = readInt(), maxSize = 0;
        int[][] buses = new int[N][];

        for (int i = 0; i < N; i++){
            buses[i] = new int[]{readTimeAsMs(), readTimeAsMs()};
        }

        Arrays.sort(buses, Comparator.comparingInt(bus -> bus[0]));
        for (int i = 0; i < N; i++){
            while (!pq.isEmpty() && pq.element()[1] <= buses[i][0]){
                pq.remove();
            }
            pq.add(buses[i]);
            maxSize = Math.max(maxSize, pq.size());
        }

        System.out.println(maxSize);
    }

}
