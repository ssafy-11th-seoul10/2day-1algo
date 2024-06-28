// https://lotuslee.tistory.com/38
// 접근 -> 쌩구현, 재귀로 모든 경우 계산 -> 시간초과
// 핵심 로직 : 길이가 같은 문자열 배열의 각 { A, C, G, T }가 나온 횟수 계산
// 그 중, 가장 많은 횟수를 가진 문자를 결과 문자열의 문자로 설정하며 진행하는 "Greedy"!
// "구현" 유형에 매몰되어, Greedy한 규칙을 도출하지 못해서 틀린 것 같다. 유연하게 사고하는게 필요!

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ1969 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());    // 입력받을 수
        int M = Integer.parseInt(st.nextToken());    // 문자열 길이

        char[][] DNA = new char[N][M];

        String result = "";        // DNA를 출력할 변수
        int cnt = 0;    // 합을 출력할 변수

        int i, j;

        for (i = 0; i < N; i++) {
            String str = br.readLine();        // 문자열을 입력받고

            for (j = 0; j < M; j++) {
                DNA[i][j] = str.charAt(j);    // 입력받은 문자열을 char로 변환하여 저장
            }
        }

        for (i = 0; i < M; i++) {
            int[] arr = new int[4];    // A C G T를 담을 배열 생성
            for (j = 0; j < N; j++) {
                if (DNA[j][i] == 'A') {
                    arr[0]++;
                } else if (DNA[j][i] == 'C') {
                    arr[1]++;
                } else if (DNA[j][i] == 'G') {
                    arr[2]++;
                } else {
                    arr[3]++;
                }                    // 각 알파벳의 수를 카운트
            }

            int max = arr[0];
            int index = 0;

            for (j = 1; j < 4; j++) {
                if (arr[j] > max) {
                    max = arr[j];    // 가장 많이 사용된 알파벳을 찾고
                    index = j;    // 그 인덱스를 저장한다.
                }
            }

            if (index == 0) {    // 저장된 인덱스에 따라 result에 이어 붙인다
                result += 'A';
            } else if (index == 1) {
                result += 'C';
            } else if (index == 2) {
                result += 'G';
            } else {
                result += 'T';
            }
        }

        for (i = 0; i < N; i++) {
            for (j = 0; j < M; j++) {
                if (result.charAt(j) != DNA[i][j]) {    // result와 DNA 배열을 비교하고
                    cnt++;    // 문자가 다를 경우 cnt ++
                }
            }
        }
        System.out.println(result);
        System.out.println(cnt);
    }
}
