package PG;

class PG_없는숫자더하기_240822 {
    public int solution(int[] numbers) {
        int answer = 45;
        for (int number : numbers) {
            answer -= number;
        }
        return answer;
    }
}