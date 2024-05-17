import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11000_240517 {

    static class Pair implements Comparable<Pair> {
        int s, e;

        Pair(int s, int e) {
            this.s = s;
            this.e = e;
        }

        @Override
        public int compareTo(Pair p) {
            return this.s - p.s;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        int n = Integer.parseInt(br.readLine());
        Pair[] pairs = new Pair[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int s = Integer.parseInt(st.nextToken());
            int e = Integer.parseInt(st.nextToken());
            pairs[i] = new Pair(s, e);
        }

        Arrays.sort(pairs);
        PriorityQueue<Integer> pqMinTop = new PriorityQueue<Integer>();
        int maxSize = 0;

        for (int i = 0; i < n; i++) {
            while (!pqMinTop.isEmpty() && pqMinTop.peek() <= pairs[i].s) {
                pqMinTop.poll();
            }

            pqMinTop.offer(pairs[i].e);
            maxSize = Math.max(maxSize, pqMinTop.size());
        }

        System.out.println(maxSize);
        br.close();
    }

}
