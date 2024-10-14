import java.io.*;
import java.util.Arrays;

public class Main {

    private static char[][] ladder;
    private static int N, K, hideLine;

    private static void swap(char[] arr, int i, int j) {
        char tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    private static String getWrongStatusResult(){
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < K - 1; i++){
            sb.append('x');
        }
        return sb.toString();
    }

    private static char[] getStartStatus(){
        char[] newCharArray = new char[K];

        for (int i = 0; i < K; i++){
            newCharArray[i] = (char)('A' + i);
        }
        return newCharArray;
    }

    //3번째 줄 전후 상태를 비교해 빈 사다리 구함
    private static String getBlankLadder(char[] upStatus, char[] downStatus) {
        char[] blankLadder = new char[K - 1];

        Arrays.fill(blankLadder, '*');
        for (int i = 0; i < K - 1; i++){
            // 위 아래 상태가 다를 때
            if (upStatus[i] != downStatus[i]){
                // 뒤 문자와 위치 교환된 상태가 아닌 경우 '불가능한 상황'
                if (upStatus[i] != downStatus[i + 1] || upStatus[i + 1] != downStatus[i]){
                    return null;
                }
                blankLadder[i++] = '-';
            }
        }
        return new String(blankLadder);
    }

    private static String getSolution(char[] startStatus, char[] finalStatus){
        // 처음 상태에서 3번째 줄 앞까지 진행
        for (int i = 0; i < hideLine; i++){
            for (int j = 0; j < K - 1; j++){
                if(ladder[i][j] == '-'){
                    swap(startStatus, j, j + 1);
                    j++;
                }
            }
        }

        // 마지막 상태에서 3번째 줄 뒤까지 진행
        for (int i = N - 1; i > hideLine; i--){
            for (int j = 0; j < K - 1; j++){
                if(ladder[i][j] == '-'){
                    swap(finalStatus, j, j + 1);
                    j++;
                }
            }
        }

        String solution = getBlankLadder(startStatus, finalStatus);
        if (solution == null){
            return getWrongStatusResult();
        }
        return solution;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        K = Integer.parseInt(br.readLine());
        N = Integer.parseInt(br.readLine());
        char[] startStatus = getStartStatus();
        char[] finalStatus = br.readLine().toCharArray();

        ladder = new char[N][];
        for (int i = 0; i < N; i++){
            ladder[i] = br.readLine().toCharArray();
            if (ladder[i][0] == '?'){
                hideLine = i;
            }
        }

        System.out.println(getSolution(startStatus, finalStatus));
    }
    
}
