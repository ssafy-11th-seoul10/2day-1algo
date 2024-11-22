import java.io.*;
import java.util.*;

// 정리된 박스 외의 모든 카드는 쓰레기통(조커 박스)에 모두 넣어 해결
public class Main {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        int[] extraBoxes = new int[M];    // extraCards[i]: i번 색상이 가장 낮은 번호의 색상인 정리가 필요한 박스 개수
        int[] standardBoxes = new int[M]; // standardCards[i]: i번 색상으로 정리된 박스 개수(최대 1개)

        for (int i = 0; i < N; i++){
            st = new StringTokenizer(br.readLine());
            int lowestColorIndex = -1;
            boolean isStandard = false;

            for (int j = 0; j < M; j++){
                if (Integer.parseInt(st.nextToken()) > 0){
                    if (lowestColorIndex < 0) {
                        lowestColorIndex = j;
                        isStandard = true;
                    } else {
                        isStandard = false;
                        break;
                    }
                }
            }

            if (lowestColorIndex < 0){
                continue;
            }

            if (isStandard && standardBoxes[lowestColorIndex] == 0){
                standardBoxes[lowestColorIndex]++;
            } else {
                extraBoxes[lowestColorIndex]++;
            }
        }

        int moveCount = 0;
        for (int cnt : extraBoxes){
            moveCount += cnt;
        }

        System.out.println(Math.max(moveCount - 1, 0));
    }

}
