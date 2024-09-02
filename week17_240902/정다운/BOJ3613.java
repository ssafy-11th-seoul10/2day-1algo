package baekjoon;

import java.io.*;

public class BOJ3613 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        String str = br.readLine();

        // 시작이 대문자이거나 _, 마지막이 _ 불가
        if (str.charAt(0) <= '_' || str.charAt(str.length() - 1) == '_') {
            System.out.println("Error!");
            return;
        }

        // __ 불가 _A 불가 A_불가
        boolean upperCase = false; // 만약 대문자가 있다면 c++로만 바꿀 수 있음
        boolean toJava = false; // false라면 c++, true라면 자바로 바꾸기
        char pre = str.charAt(0); // 이전 문자 파악
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);

            if (ch <= 'Z') {
                if (toJava) { // _A로 끝나면 안되므로 _ 나왔는지 판단 (toJava라면 _이 나옴)
                    System.out.println("Error!");
                    return;
                }
                upperCase = true; // 대문자 true 설정
            }

            if (ch == '_') { // 만약 _가 있는데 대문자가 섞여 있다면 불가
                if (upperCase || pre == '_') {
                    System.out.println("Error!");
                    return;
                }
                toJava = true;
            }
            pre = ch;
        }


        if (toJava) { // 자바로 바꿔야 함
            boolean nextUpper = false; // 다음이 대문자가 나와야함
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (nextUpper) {
                    sb.append(String.valueOf(ch).toUpperCase()); // 문자열 대문자로 변경
                    nextUpper = false; // 초기화
                } else {
                    if (str.charAt(i) == '_') nextUpper = true; // 다음 문자열 대문자로 설정
                    else sb.append(ch);
                }
            }
        }
        else { // c++로 바꿔야 함
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch <= 'Z') { // 만약 대문자라면
                    sb.append("_"); // "_소문자"로 바꾸기
                    sb.append(String.valueOf(ch).toLowerCase());
                } else sb.append(ch);
            }
        }

        System.out.println(sb);
    }
}