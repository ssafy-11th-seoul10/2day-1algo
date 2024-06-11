Java의 startsWith("asdf"), endsWith("asdf") 메서드 기억
  -> "asdf"로 시작하는지, "asdf"로 끝나는지 boolean 리턴

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    private static StringTokenizer stringTokenizer;
    private static StringBuilder stringBuilder = new StringBuilder();


    public static void main(String[] args) throws IOException {

        String[] word = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
        String inputValue = bufferedReader.readLine();
        int answer = 0;
        for (int i = 0; i < inputValue.length(); i++) {
            int nextIndex = 0;
            for (String tmp : word) {
                if (inputValue.startsWith(tmp, i)) {
                    nextIndex = tmp.length() - 1;
                    break;
                }
            }
            answer++;
            i += nextIndex;
        }
        System.out.println(answer);
    }
}
