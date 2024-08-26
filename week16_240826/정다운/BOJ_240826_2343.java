package baekjoon;

import java.util.*;
import java.io.*;
// https://turtle8760.tistory.com/93
// 이분탐색의 범위를 잘 구해야하는 문제 => 블루레이의 크기

// 제일 극단적인 오른쪽 극값 = 모든 레슨을 다 더한 크기 => 블루레이 1개로 다 처리
// 제일 극단적인 왼쪽 극값 = 레슨마다 블루레이를 1개식 담기 => N개의 블루레이
// 위 범위에서 이분탐색 계산을 해야 한다.

public class BOJ2343 {

    static int N, M;
    static int[] lesson;
    static int left, right;

    public static long binSearch(long left, long right) {
        while(left <= right) {
            long sum = 0;
            long mid = (left+right)/2;
            int count = 1;

            for (int i = 0; i < N; i++) {
                sum += lesson[i];
                if(sum > mid) { // 만약 기타 음원 합이 블루레이 크기를 넘으면
                    sum = lesson[i]; // 다음 블루레이에 음원 담기
                    count ++; // 블루레이 갯수 더하기
                }
            }
            //필요한 블루레이 갯수가 M보다 작거나 같으면
            if(count <= M) {
                right = mid - 1;
            }
            //총 필요한 블루레이 개수가 M보다 크다면
            else {
                left = mid +1;
            }
        }
        return left;
    }

    public static void main(String[] args) throws IOException{

        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        //ex) {1,2,3,4,5,6,7,8,9}
        //강의 수 N , 블루레이 갯수 M , 각 강의의 길이 배열 lesson 초기화
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        lesson = new int[N];

        st = new StringTokenizer(br.readLine()," ");
        int sum = 0;

        for (int i = 0; i < N; i++) {
            lesson[i] = Integer.parseInt(st.nextToken());
            sum += lesson[i];
            left = Math.max(left, lesson[i]); //9
        }
        right = sum;  //45

        System.out.println(binSearch(left,right));
    }

}
