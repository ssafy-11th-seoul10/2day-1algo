import java.io.*;
import java.util.*;

public class Main {

    private static int readInt() throws IOException{
        int c, n = 0;

        while((c = System.in.read()) > 32){
            n = (n << 3) + (n << 1) + (c & 15);
        }
        return n;
    }

    private static int binaryLIS(int[] arr){
        int[] dp = new int[arr.length];
        int size = 1;

        dp[0] = arr[0];
        for (int i = 1; i < arr.length; i++){
            if (dp[size - 1] < arr[i]){
                dp[size++] = arr[i];
                continue;
            }

            int idx = Arrays.binarySearch(dp, 0, size, arr[i]);

            if (idx < 0){
                idx = - idx - 1;
            }
            dp[idx] = arr[i];
        }
        return size;
    }

    public static void main(String[] args) throws IOException {
        int[] boxes = new int[readInt()];

        for (int i = 0; i < boxes.length; i++){
            boxes[i] = readInt();
        }
        System.out.println(binaryLIS(boxes));
    }

}
