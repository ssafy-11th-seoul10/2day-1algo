import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_240711_29814 {

    static class Homework {
        int d, p;

        Homework(int d, int p) {
            this.d = d;
            this.p = p;
        }
    }

    static Comparator<Homework> homeworkComparator = new Comparator<Homework>() {

        @Override
        public int compare(Homework o1, Homework o2) {
            return o2.d - o1.d;
        };

    };

    static Comparator<Integer> descIntegerComparator = new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
            return o2 - o1;
        };

    };

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int n = Integer.parseInt(st.nextToken());
        int c = Integer.parseInt(st.nextToken());

        Homework[] homeworks = new Homework[n];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine(), " ");
            int d = Integer.parseInt(st.nextToken());
            int t = Integer.parseInt(st.nextToken());
            int p = Integer.parseInt(st.nextToken());

            homeworks[i] = new Homework(d - t + 1, p);
        }

        Arrays.sort(homeworks, homeworkComparator);
        PriorityQueue<Integer> points = new PriorityQueue<Integer>(descIntegerComparator);
        PriorityQueue<Integer> pointsSelected = new PriorityQueue<Integer>(descIntegerComparator);

        int i = 0;

        for (int d = n; d >= 1; d--) {
            while (i < n && homeworks[i].d == d) {
                points.offer(homeworks[i].p);
                i++;
            }

            if (!points.isEmpty()) {
                pointsSelected.offer(points.poll());
            }
        }

        int scoreSum = 0;
        int botCnt = 0;

        while (!pointsSelected.isEmpty() && scoreSum < c) {
            scoreSum += pointsSelected.poll();
            botCnt++;
        }

        if (scoreSum < c) {
            System.out.println("I'm sorry professor Won!");
        } else {
            System.out.println(botCnt);
        }

        br.close();
    }

}
