package baekjoon;

import java.util.*;
import java.io.*;

// https://st-lab.tistory.com/277
// 이분탐색 : 무엇을 기준으로 탐색할 것인가?
// 이분탐색 : left, right 갱신 조건을 어떻게 할 것인가?
// 이분탐색 : 나만의 반복문 / 재귀문 틀 구현!

public class BOJ2110 {

    static int N, C;
    static int[] house;

    public static int checkInstall(int dist) {

        int count = 1;
        int lastLocate = house[0]; // 처음 집은 무조건 방문한다고 가정

        for(int i = 1; i < house.length; i++) {

            int locate = house[i];

            if(locate - lastLocate >= dist) { // 인접 거리보다 같거나 크면 설치 가능하다.
                lastLocate = locate; // 가장 최근에 설치한 집 위치를 갱신
                count++; // 개수 증가
            }
        }

        return count;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        C = Integer.parseInt(st.nextToken());

        house = new int[N];

        for(int i = 0; i < N; i++)
            house[i] = Integer.parseInt(br.readLine());

        Arrays.sort(house); // 이분탐색 -> 반드시 정렬!

        // 기준 : 인접한 두 집 간의 거리
        int shortestLeng = 1; // 인접 간 최소 거리가 가질 수 있는 최솟값
        int longestLeng = house[N-1] - house[0] + 1; // 인접 간 최소 거리가 가질 수 있는 최댓값

        // 이분 탐색 -> 인접 두 집 거리를 기준으로 탐색 => Upper bound 탐색
        while(shortestLeng < longestLeng) {

            int midLeng = (shortestLeng + longestLeng) / 2;

            // 해당 최소 거리를 기준으로 공유기를 설치 해 본다.

            // 만약 공유기 설치 댓수가 C 보다 작으면 -> 최소 거리를 좁혀서 댓수를 키운다.
            if(checkInstall(midLeng) < C)
                longestLeng = midLeng;
            // 설치 댓수가 C와 같거나 크다면 -> 최소 거리를 최대한 벌리게 한다.
            else
                shortestLeng = midLeng + 1;
        }

        // Upper bound : 탐색 값을 초과하는 1번째 값을 가리킴
        // 1을 빼줘서, 댓수가 C와 같거나 큰 최소 거리 중 가장 최대한 벌린 길이를 구한다.
        System.out.println(shortestLeng - 1);
    }
}
