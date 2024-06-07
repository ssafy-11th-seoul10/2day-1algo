import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_12732_240607 {

    static class Train {
        char departureStation;
        int departureTime, arrivalTime;

        Train(char departureStation, String timeInfo) {
            this.departureStation = departureStation;
            this.departureTime = Integer.parseInt(timeInfo.substring(0, 2)) * 60 + Integer.parseInt(timeInfo.substring(3, 5));
            this.arrivalTime = Integer.parseInt(timeInfo.substring(6, 8)) * 60 + Integer.parseInt(timeInfo.substring(9, 11));
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        StringBuilder sb = new StringBuilder();
        int n = Integer.parseInt(br.readLine());

        for (int ni = 1; ni <= n; ni++) {
            int t = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine(), " ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int ab = a + b;

            Train[] trains = new Train[a + b];

            for (int i = 0; i < a; i++) {
                trains[i] = new Train('A', br.readLine());
            }

            for (int i = a; i < ab; i++) {
                trains[i] = new Train('B', br.readLine());
            }

            Arrays.sort(trains, new Comparator<Train>() {

                @Override
                public int compare(Train o1, Train o2) {
                    return o1.departureTime - o2.departureTime;
                }

            });

            int aFirst = 0;
            int bFirst = 0;
            PriorityQueue<Integer> aReturn = new PriorityQueue<Integer>();
            PriorityQueue<Integer> bReturn = new PriorityQueue<Integer>();

            for (int i = 0; i < ab; i++) {
                if (trains[i].departureStation == 'A') {
                    if (!aReturn.isEmpty() && aReturn.peek() <= trains[i].departureTime) {
                        aReturn.poll();
                    } else {
                        aFirst++;
                    }

                    bReturn.offer(trains[i].arrivalTime + t);
                } else {
                    if (!bReturn.isEmpty() && bReturn.peek() <= trains[i].departureTime) {
                        bReturn.poll();
                    } else {
                        bFirst++;
                    }

                    aReturn.offer(trains[i].arrivalTime + t);
                }
            }

            sb.append("Case #").append(ni).append(": ").append(aFirst).append(" ").append(bFirst).append("\n");
        }

        System.out.print(sb);
        br.close();
    }

}
