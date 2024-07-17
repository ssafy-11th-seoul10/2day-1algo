package baekjoon;

import java.io.*;
import java.util.*;

public class BOJ1038 {

    static int N;
    static List<int[]> arr;
    static boolean total_f = true;

    static int[] digits;
    static boolean[] visited;

   public static void permutation(int depth) {

        if(depth == digits.length){
            arr.add(Arrays.copyOf(digits, digits.length));
//            System.out.println("ppop " + Arrays.toString(arr.get(arr.size()-1)));

            if(arr.size() > N)
                total_f = false;
            return;
        }

        for(int i = 0; i < 10; i++) {
            if(visited[i])
                continue;

            if(digits[depth - 1] > i) {
                    visited[i] = true;
                    digits[depth] = i;

                    permutation(depth + 1);

                    if(!total_f) // N 길이라면, 더 이상 진행 못하게 막기..
                        return;

                    visited[i] = false;
            }
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine()); // 1 ~ 1백만(1초)
        arr = new ArrayList<>();
        arr.add(new int[]{0});

        int leng = 1;

        outer : while(total_f) {

            if(leng > 10) // 987 654 321 0 => leng = 10
                break;

//            System.out.println("gpdkdns " + leng);
            digits = new int[leng];
            visited = new boolean[10];

            for(int i = 1; i < 10; i++) {
                digits[0] = i;
//                System.out.println("digit 길이  " + leng + " 배열 길이 : " + arr.size());

                if(leng == 1)
                    arr.add(new int[] {i});
                else {
                    permutation(1);
                    if(!total_f)
                        break outer;
                }
            }

            leng++;
        }

//        for(int[] s : arr)
//            System.out.println(Arrays.toString(s));
        if(!total_f) {

            int[] tmpList = arr.get(N);
            char[] resList = new char[tmpList.length];
            for(int idx = 0; idx < resList.length; idx++)
                resList[idx] = (char)(tmpList[idx] + '0');

            System.out.println(String.valueOf(resList));
        }
        else
            System.out.println(-1);
    }
}
