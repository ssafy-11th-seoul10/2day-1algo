package baekjoon;

import java.io.*;
import java.util.*;

// 결국 메인 로직은 다음과 같음
// 1. 하나의 오리를 구할 시작점 선택
// 2. 그 오리를 끝까지 탐색하며 "quack quack.." 순서를 보장하도록 탐색
// 3. 오리들의 울음소리 길이가 올바른지 체크 (5의 배수 && 0이 아님)

public class BOJ12933 {

    static String ducks;
    static boolean[] visited;
    static List<List<Character>> duckList = new ArrayList<>();
    static int cnt = 0;

    public static void search() {
        // 하나씩 탐색하면서
        // 'q'를 마주치면 새로운 오리에게 할당
        // 다른 문자열이면, 존재하는 오리를 탐색하면서 문자열 할당
        for(int i = 0; i < ducks.length(); i++) {

            char ch = ducks.charAt(i);

            if(duckList.isEmpty() && ch == 'q') {
                visited[i] = true;
                List<Character> du = new LinkedList<>();
                du.add(ch);

                duckList.add(du);
                continue;
            }

            boolean flag = false;

            for(List<Character> duck : duckList) {
                 if(putChar(duck, ch, i)) {
                     flag = true;
                     break;
                 }
            }

            // 만약 기존 오리와 연결 될 수 없고, 그게 'q'라면 -> 새로운 오리 할당
            if(!flag && ch == 'q') {
                visited[i] = true;
                List<Character> du = new LinkedList<>();
                du.add(ch);

                duckList.add(du);
            }
        }

        for(List<Character> duck : duckList) {
            //System.out.println(duck.toString());
            if(check(duck))
                cnt++;
            else {
                cnt = -1;
                break;
            }
        }
    }

    public static boolean putChar(List<Character> duck, char ch, int idx) {

        char last = duck.get(duck.size() - 1);

        if(last == 'q' && ch == 'u') {
            duck.add(ch);
            visited[idx] = true;
            return true;
        }
        else if(last == 'u' && ch == 'a') {
            duck.add(ch);
            visited[idx] = true;
            return true;
        }
        else if(last == 'a' && ch == 'c') {
            duck.add(ch);
            visited[idx] = true;
            return true;
        }
        else if(last == 'c' && ch == 'k') {
            duck.add(ch);
            visited[idx] = true;
            return true;
        }
        else if(last == 'k' && ch == 'q') {
            duck.add(ch);
            visited[idx] = true;
            return true;
        }
        return false;
    }

    public static boolean check(List<Character> duck) {

        int idx = 0;
        char[] arr = new char[5];

        for (Character character : duck) {
            if (idx % 5 == 0 && idx != 0) {
                if (!String.valueOf(arr).equals("quack"))
                    return false;
                idx = 0;
                arr = new char[5];
            }

            arr[idx] = character;
            idx++;
        }

        return String.valueOf(arr).equals("quack");
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        ducks = br.readLine();
        visited = new boolean[ducks.length()];

        search();
        boolean isCorrect = true;

        for(boolean v : visited)
            if(!v) {
                isCorrect = false;
                break;
            }

        if(isCorrect) {
            System.out.println(cnt);
        }
        else
            System.out.println(-1);
    }
}
