package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ16922 {

    static int N;
    static int cnt = 0;
    static char[] roman = {'I', 'V', 'X', 'L'};
    static char[] perm;
    static Set<Integer> mySet = new HashSet<>();

    public static int convertNum(char[] data) {

        int num = 0;

        for(char c : data) {
            if(c == 'I')
                num += 1;
            else if(c == 'V')
                num += 5;
            else if(c == 'X')
                num += 10;
            else if(c == 'L')
                num += 50;
            else
                break;
        }

        return num;
    }

    public static void permutation(int depth) {

        if(depth == N) {

            int res = convertNum(perm);
            if(!mySet.contains(res)) {
                mySet.add(res);
                cnt++;
            }

            //System.out.println(res);

            return;
        }

        for(int i = 0; i < 4; i++) {

            perm[depth] = roman[i];
            int pervNum = convertNum(perm);

            if(!mySet.contains(pervNum)) {
                mySet.add(pervNum);
                permutation(depth + 1);
            }

        }

    }

    // 정배 풀이 -> 중복 배열 합 (VVX, VXV, XVV .. ) 같은 값은 제외
    // VXV, XVV 같이, 현재 값보다 작은 로마 숫자는 다음 인덱스에 나오지 않게끔 설정!
    /*
    private static void dfs(int depth, int index, int sum) {
        if (depth == N) {
            if (!isVisited[sum]) {
                isVisited[sum] = true;
                result++;
            }
            return;
        }
        for (int i = index; i < 4; i++) {
            // 중복탐색안되게끔 index 설정
            dfs(depth + 1, i, sum + nums[i]);
        }
    }

     */

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());

        perm = new char[N];

        permutation(0);

        System.out.println(mySet.size() - (N - 1));
    }
}
