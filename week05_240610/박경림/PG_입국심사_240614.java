class Solution {
    public long solution(int n, int[] times) {
        long answer = Long.MAX_VALUE;
        
        int time = 0;
        for (int i = 0; i < times.length; i++) {
            time = Math.max(time, times[i]);
        }
        long max = n * (long) time;
        long min = 0;
        while (min <= max) {
            long mid = (min + max) / 2;
            long cnt = 0;
            for (int i = 0; i < times.length; i++) {
                cnt += (mid / (long) times[i]);
                if (cnt >= n) break;
            }
            
            if (cnt >= n) {
                answer = mid;
                max = mid - 1; 
            } else {
                min = mid + 1;
            }
        }
        
        return answer;
    }
}
