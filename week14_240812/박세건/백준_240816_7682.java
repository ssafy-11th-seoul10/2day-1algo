import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static int N, M;

    private static int[][] winPosition = {
            {0, 1, 2},
            {3, 4, 5},
            {6, 7, 8},
            {0, 3, 6},
            {1, 4, 7},
            {2, 5, 8},
            {0, 4, 8},
            {2, 4, 6},
    };

    public static void main(String[] args) throws Exception {
        while (true) {
            String input = br.readLine();
            if (input.equals("end")) {
                break;
            }
            int[] countOX = findCount(input);
            if (!(countOX[0] - countOX[1] == 0 || countOX[0] - countOX[1] == -1)) {
                sb.append("invalid").append("\n");
                continue;
            }
            boolean isOWin = countOX[0] - countOX[1] == 0;
            if (isWinnerValid(isOWin, input, countOX)) {
                sb.append("valid").append("\n");
            } else {
                sb.append("invalid").append("\n");
            }
        }
        System.out.println(sb.toString());
    }

    private static boolean isWinnerValid(boolean isOWin, String input, int[] countOX) {
        boolean isRealOWin = false;
        boolean isRealXWin = false;
        for (int i = 0; i < 8; i++) {
            if (input.charAt(winPosition[i][0]) == 'X' &&
                    input.charAt(winPosition[i][1]) == 'X' &&
                    input.charAt(winPosition[i][2]) == 'X') {
                isRealXWin = true;
                break;
            }
        }
        for (int i = 0; i < 8; i++) {
            if (input.charAt(winPosition[i][0]) == 'O' &&
                    input.charAt(winPosition[i][1]) == 'O' &&
                    input.charAt(winPosition[i][2]) == 'O') {
                isRealOWin = true;
                break;
            }
        }
//        System.out.println(isOWin + " " + isRealOWin + " " + isRealXWin);
        if (isOWin == isRealOWin && isOWin != isRealXWin) {
            return true;
        }
        if (!isRealOWin && !isRealXWin) {
            if (countOX[0] + countOX[1] == 9) {
                return true;
            }
        }
        return false;
    }

    private static int[] findCount(String input) {
        int cntO = 0, cntX = 0;
        for (int i = 0; i < input.length(); i++) {
            char cur = input.charAt(i);
            if (cur == 'O') {
                cntO++;
            } else if (cur == 'X') {
                cntX++;
            }
        }
        return new int[]{cntO, cntX};
    }
}
