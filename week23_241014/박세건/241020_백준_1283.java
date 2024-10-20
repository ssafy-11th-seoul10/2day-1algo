import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static StringBuilder sb = new StringBuilder();
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

    private static int N;

    private static List<String>[] inputStrings;

    public static void main(String[] args) throws IOException {
        N = Integer.parseInt(br.readLine());
        boolean[] isUsed = new boolean[26];

        inputStrings = new List[N];
        for (int i = 0; i < inputStrings.length; i++) {
            inputStrings[i] = new ArrayList<>();
        }
        for (int i = 0; i < N; i++) {
            String inputString = br.readLine();
            st = new StringTokenizer(inputString);
            boolean isFind = false;
            List<String> tmp = new ArrayList<>();
            while (st.hasMoreTokens()) {
                String cur = st.nextToken();
                char firstChar = cur.charAt(0);
                if (!isFind && isUsedChar(isUsed, firstChar)) {
                    isFind = true;
                    cur = changeResult(cur, firstChar, 0);
                }
                tmp.add(cur);
            }
            if (!isFind) {
                tmp.clear();
                for (int j = 0; j < inputString.length(); j++) {
                    char curChar = inputString.charAt(j);
                    if (isUsedChar(isUsed, curChar)) {
                        inputString = changeResult(inputString, curChar, j);
                        break;
                    }
                }
                st = new StringTokenizer(inputString);
                while (st.hasMoreTokens()) {
                    tmp.add(st.nextToken());
                }
            }

            for (int j = 0; j < tmp.size(); j++) {
                inputStrings[i].add(tmp.get(j));
            }
        }
        for (int i = 0; i < inputStrings.length; i++) {
            for (int j = 0; j < inputStrings[i].size(); j++) {
                System.out.print(inputStrings[i].get(j) + " ");
            }
            System.out.println();
        }
    }

    private static String changeResult(String cur, char curChar, int idx) {
        StringBuilder tmpSb = new StringBuilder(cur);
        tmpSb.deleteCharAt(idx);
        tmpSb.insert(idx, "[" + curChar + "]");
        cur = tmpSb.toString();
        return cur;
    }

    private static boolean isUsedChar(boolean[] isUsed, char curChar) {
        if ('A' <= curChar && curChar <= 'Z') {
            if (!isUsed[curChar - 'A']) {
                isUsed[curChar - 'A'] = true;
                return true;
            }
        } else if ('a' <= curChar && curChar <= 'z') {
            if (!isUsed[curChar - 'a']) {
                isUsed[curChar - 'a'] = true;
                return true;
            }
        }
        return false;
    }

}
