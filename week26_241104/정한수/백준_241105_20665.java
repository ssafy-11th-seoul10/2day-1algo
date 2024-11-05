import java.io.*;
import java.util.*;

public class Main {

    private static class ReservationTime implements Comparable<ReservationTime> {
        int user, mode, time, length;

        public ReservationTime(int user, int mode, int time, int length) {
            this.user = user;
            this.mode = mode;
            this.time = time;
            this.length = length;
        }

        @Override
        public int compareTo(ReservationTime rt) {
            if (time == rt.time){
                if (mode != rt.mode) {
                    return mode - rt.mode;
                }
                return length - rt.length;
            }
            return time - rt.time;
        }
    }

    private static final Map<Integer, Integer> seatIndices = new HashMap<>();
    private static final int INF = 1_000_000_000;

    private static int HHMMToMin(String HHMM){
        int hhmm = Integer.parseInt(HHMM);
        return hhmm / 100 * 60 + hhmm % 100;
    }

    private static void leaveSeat(int[] seats, ReservationTime rTime){
        int idx = seatIndices.get(rTime.user);
        seatIndices.remove(rTime.user);
        seats[idx] = 0;
    }

    private static void takeSeat(int[] seats, ReservationTime rTime){
        Set<Map.Entry<Integer, Integer>> seatIndicesSet = seatIndices.entrySet();
        int[] dists = new int[seats.length];

        Arrays.fill(dists, INF);
        for (Map.Entry<Integer, Integer> seatEntry : seatIndicesSet){
            int dist = 0, idx = seatEntry.getValue();
            for (int i = idx; i > 0; i--){
                dists[i] = Math.min(dists[i], dist++);
            }

            dist = 0;
            for (int i = idx; i < seats.length; i++){
                dists[i] = Math.min(dists[i], dist++);
            }
        }

        int max = 0, maxIdx = 0;
        for (int i = 1; i < seats.length; i++){
            if (max < dists[i]){
                max = dists[i];
                maxIdx = i;
            }
        }
        seatIndices.put(rTime.user, maxIdx);
        seats[maxIdx] = rTime.user;
    }

    private static int getMaxUseTime(List<ReservationTime> reservations, int N, int P){
        int[] seats = new int[N + 1];
        int useTime = 0;

        if (!reservations.isEmpty()) {
            useTime = reservations.get(0).time - 9 * 60;
        }

        for (int i = 0; i < reservations.size(); i++){
            if (i > 0 && seats[P] == 0){
                useTime += reservations.get(i).time - reservations.get(i - 1).time;
            }

            if (reservations.get(i).mode == 1){
                takeSeat(seats, reservations.get(i));
            } else {
                leaveSeat(seats, reservations.get(i));
            }
        }
        if (seats[P] == 0 && !reservations.isEmpty()){
            useTime += 21 * 60 - reservations.get(reservations.size() - 1).time;
        }
        return useTime;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());
        int P = Integer.parseInt(st.nextToken());
        List<ReservationTime> reservations = new ArrayList<>();

        for (int i = 0; i < T; i++){
            st = new StringTokenizer(br.readLine());
            int start = HHMMToMin(st.nextToken()), end = HHMMToMin(st.nextToken());
            if (start == end){
                continue;
            }
            reservations.add(new ReservationTime(i + 1, 1, start, end - start));
            reservations.add(new ReservationTime(i + 1, 0, end, end - start));
        }
        Collections.sort(reservations);
        System.out.println(getMaxUseTime(reservations, N, P));
    }
    
}
