public class PG340212 {

    public static long calcTotal(int level, int[] diffs, int[] times) {

        long res = times[0];

        for(int i = 1; i < diffs.length; i++) {
            res += calcTime(level, diffs[i], times[i], times[i-1]);
        }

        return res;
    }

    public static int calcTime(int level, int diff, int time, int time_prev) {
        if(diff <= level)
            return time;
        else {
            int tmp = (time + time_prev) * (diff - level);
            return tmp + time;
        }
    }

    // UpperBound -> Limit보다 적게 시간 걸리면 -> 레벨이 높다
    // 만약 Limit보다 큰 시간을 도출하는 Level가 나오면, 제한 시간 이내에 해결 불가
    // 그것을 결정짓는 경계값을 찾기 -> Limit보다 적게 걸리는 Level get
    public int solution(int[] diffs, int[] times, long limit) {
        int answer = 0;
        int limit_level = Integer.MAX_VALUE;

        int head = 0; int tail = limit_level;

        while(head < tail) {

            int mid = (head + tail) / 2;
            System.out.println(head + " + " + tail + " = " + mid);
            long calc = calcTotal(mid, diffs, times);

            if(calc <= limit){
                tail = mid;
            }
            else {
                head = mid + 1;
            }
        }

        return head == 0? 1 : head;
    }
}