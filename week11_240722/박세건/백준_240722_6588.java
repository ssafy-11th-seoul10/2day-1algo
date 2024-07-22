import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main {
    private static StringTokenizer st;
    private static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    private static StringBuilder sb = new StringBuilder();

    private static List<Integer> primeList = new ArrayList<>();
    private static boolean[] isNotPrime = new boolean[1111111];

    public static void main(String[] args) throws Exception {
        settingPrime();
//        System.out.println(primeList);
        while (true) {
            int x = Integer.parseInt(br.readLine());
            if (x == 0) {
                break;
            }
            if (findAnswer(x) == false) {
                sb.append("Goldbach's conjecture is wrong.").append("\n");
            }
//            int idx = idxByBinarySearch(x);
//            if (findAnswer(idx, x) == false) {
//                sb.append("Goldbach's conjecture is wrong.").append("\n");
//            }
        }
        System.out.println(sb);
    }

    private static boolean findAnswer(int x) {
        for (int i = 2; i <= x / 2; i++) {
            if (!isNotPrime[i] && !isNotPrime[x - i]) {
                sb.append(x).append(" = ").append(i)
                        .append(" + ").append(x - i).append("\n");
                return true;
            }
        }
        return false;
    }

    private static boolean findAnswer(int endIdx, int target) {
//        System.out.println(endIdx);
        int startIdx = 0;
        while (startIdx <= endIdx) {
            int sum = primeList.get(startIdx) + primeList.get(endIdx);
            if (sum == target) {
                sb.append(target).append(" = ").append(primeList.get(startIdx))
                        .append(" + ").append(primeList.get(endIdx)).append("\n");
                return true;
            }
            if (sum > target) {
                endIdx--;
            } else {
                startIdx++;
            }
        }
        return false;
    }

    private static int idxByBinarySearch(int x) {
        int startIdx = 0;
        int endIdx = primeList.size();
        while (startIdx < endIdx) {
//            System.out.println(startIdx + " " + endIdx);
            int midIdx = (startIdx + endIdx) / 2;
            if (x < primeList.get(midIdx)) {
                endIdx = midIdx - 1;
            } else if (x > primeList.get(midIdx)) {
                startIdx = midIdx + 1;
            } else {
                return midIdx - 1;
            }
        }
        return startIdx - 1;
    }

    private static void settingPrime() {
        for (int i = 2; i <= 1000; i++) {
            if (isNotPrime[i] == false) {
                for (int j = i * i; j <= 1000000; j += i) {
                    isNotPrime[j] = true;
                }
            }
        }
        for (int i = 2; i <= 1000000; i++) {
            if (isNotPrime[i] == false) {
                primeList.add(i);
            }
        }
    }


}
