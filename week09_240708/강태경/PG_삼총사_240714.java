class PG_삼총사_240714 {

    static void comb(int start, int depth) {
        if (depth == 3) {
            if(sum==0) answer++;
        }

        for (int i = start; i < arr.length; i++) {
            sum+=arr[i];
            comb(i + 1, depth + 1);
            sum-=arr[i];
        }

    }

    static int[] arr;
    static int sum, answer;

    public int solution(int[] number) {
        arr = number.clone();
        sum = 0;
        answer = 0;

        comb(0, 0);
        return answer;
    }
}