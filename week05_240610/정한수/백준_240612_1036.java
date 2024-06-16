import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Main {

    private static class Number implements Comparable<Number>{
        int num;
        BigInteger digit;

        public Number(int num, BigInteger digit) {
            this.num = num;
            this.digit = digit;
        }

        @Override
        public int compareTo(Number n) {
            int compare = -BigInteger.valueOf(35 - this.num).multiply(this.digit)
                    .compareTo(BigInteger.valueOf(35 - n.num).multiply(n.digit));
            return compare == 0 ? n.num - this.num : compare;
        }
    }

    private static final BigInteger THIRTY_SIX = BigInteger.valueOf(36);
    private static final BigInteger ZERO = BigInteger.ZERO;

    private static int convertCharToInt(char c){
        return c <= '9' ? c & 15 : (c & 31) + 9;
    }

    private static char convertIntToChar(int n){
        return (char)(n <= 9 ? n + '0' : n - 10 + 'A');
    }

    private static String convertToDigit36(BigInteger num){
        StringBuilder sb = new StringBuilder();

        if (num.equals(ZERO)){
            return "0";
        }
        while (num.compareTo(ZERO) > 0){
            sb.append(convertIntToChar(num.mod(THIRTY_SIX).intValue()));
            num = num.divide(THIRTY_SIX);
        }
        return sb.reverse().toString();
    }

    private static String getMaxSum(BigInteger[] flattenDigits, int K){
        PriorityQueue<Number> pq = new PriorityQueue<>();
        BigInteger maxSum = ZERO;

        for (int i = 0; i < 36; i++){
            pq.add(new Number(i, flattenDigits[i]));
        }

        while (!pq.isEmpty()){
            Number number = pq.remove();
            maxSum = maxSum.add(BigInteger.valueOf(K-- > 0 ? 35 : number.num).multiply(number.digit));
        }

        return convertToDigit36(maxSum);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BigInteger[] flattenDigits = new BigInteger[36];
        int N = Integer.parseInt(br.readLine()), K;

        Arrays.fill(flattenDigits, ZERO);
        for (int i = 0; i < N; i++){
            String s = br.readLine();
            int len = s.length(), beginIndex = 0;

            while (beginIndex < len && s.charAt(beginIndex) == '0'){
                beginIndex++;
            }

            for (int n = len - 1; n >= beginIndex; n--){
                int num = convertCharToInt(s.charAt(n));
                flattenDigits[num] = flattenDigits[num].add(THIRTY_SIX.pow(len - n - 1));
            }
        }
        K = Integer.parseInt(br.readLine());

        System.out.println(getMaxSum(flattenDigits, K));
    }

}
