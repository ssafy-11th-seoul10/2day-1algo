package programmers;

public class PRO12938 {

    public int[] solution(int n, int s) {
        int[] answer = new int[n];

        // n개로 이루어진 자연수 집합, 합은 s일 때, 곱을 최대로?

        // 분리된 숫자들이 가장 덜 차이나도록 만들기 => Greedy
        // n = 4, s = 18 -> [4, 4, 4, 4] & remainder = 2 => [4, 4, 5, 5] & remainder = 0
        int tmp = s / n; int rmd = s % n;

        for(int i = n-1; i < n; i++)
            answer[i] = tmp;
        // 나머지 분배

        int idx = n - 1;
        while(rmd != 0)  {

            answer[idx]++;
            rmd--;
            idx--;
        }

        return answer;
    }
}
