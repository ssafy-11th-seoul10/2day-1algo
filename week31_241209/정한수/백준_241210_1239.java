import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    private static int getTheNumberOfDiameters(int[] arr){
        int sum = 0, cnt = 0, tmpIdx = -1;

        // 첫 50%가 되는 지점 탐색
        for (int i = 0; i < N; i++){
            sum += arr[i];
            if (sum == 50){
                cnt++;
                tmpIdx = i;
                break;
            }
        }

        // 지름이 없다면 탈출
        if (tmpIdx < 0){
            return 0;
        }

        // 나머지 지름 탐색
        for (int i = 1; i <= tmpIdx; i++){
            sum = 0;

            for (int j = i; j < N; j++){
                sum += arr[j];
                if (sum == 50){
                    cnt++;
                    break;
                }
            }
        }

        return cnt;
    }

    private static void swap(int[] arr, int a, int b){
        arr[a] ^= arr[b];
        arr[b] ^= arr[a];
        arr[a] ^= arr[b];
    }

    public static boolean getNextPermutation(int[] arr){
        int i = N - 1;

        // 1. 뒤에서부터 오름차순을 처음으로 깨는 지점 찾음
        while(i > 0 && arr[i - 1] >= arr[i]) {
            i--;
        }

        // 이미 내림차순이면 다음 순열 없음
        if (i == 0) {
            return false;
        }

        // 2. 뒷 배열 중 arr[i - 1]보다 큰 가장 작은 수 arr[j] 찾아서 교환
        int j = N - 1;
        while(arr[i - 1] >= arr[j]){
            j--;
        }
        swap(arr, i - 1, j);

        // 3. i - 1 뒷 배열 리버스
        int k = N - 1;
        while(i < k) {
            swap(arr, i++, k--);
        }

        return true;
    }

    private static int getMaxNumberOfDiameters(int[] arr){
        int maxDiameters = 0;

        do {
            maxDiameters = Math.max(maxDiameters, getTheNumberOfDiameters(arr));
        } while (getNextPermutation(arr));
        return maxDiameters;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        N = Integer.parseInt(br.readLine());
        int[] arr = new int[N];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++){
            arr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(arr);
        System.out.println(getMaxNumberOfDiameters(arr));
    }

}
