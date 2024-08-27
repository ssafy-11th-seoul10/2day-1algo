package PG;

public class PG_2개이하로다른비트_240827 {
    public static void main(String[] args) {

        long[] numbers = {16};

        //2^10 -> 10^3
        //최대 10^15 -> 2^50
        //비트 50개 사용
        //1. 가장 왼쪽의 1위치 아래에서 0이 있다면 가장 오른쪽의 0을 1로 바꾼다
        //1-1. 1로 바꾼 위치 아래에 또 1이 존재한다면 가장 왼쪽의 1을 0으로 바꾼다.
        //2. 없다면 가장 왼쪽의 1위치를 0으로, 그 왼쪽 비트를 1로 바꾼다
        long[] answer = new long[numbers.length];
        for (int i = 0; i < numbers.length; i++) {
            long number = numbers[i];
            int left = 0;
            //가장 왼쪽의 1비트 찾기
            for (int j = 50; j >= 0; j--) {
                if ((number & (1L << j)) != 0) {
                    left = j;
                    System.out.println(left);
                    answer[i] = (number ^ (1L << j)) | (1L << (j + 1));
                    break;
                }
            }
            for (int j = 0; j <= left; j++) {
                if ((number & (1L << j)) == 0) {
                    answer[i] = number | (1L << j);
                    for (int k = j-1; k >=0 ; k--) {
                        if ((number & (1L << k)) != 0) {
                            answer[i] ^= (1L << k);
                            break;
                        }
                    }
                    break;
                }
            }

        }
        for (long l : answer) {
            System.out.println("l = " + l);
        }
    }
}
