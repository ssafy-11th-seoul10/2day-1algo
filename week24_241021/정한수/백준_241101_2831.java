import java.io.*;
import java.util.*;

public class Main {

    private static int N;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<Integer> tallPreferredMen = new ArrayList<>();
        List<Integer> tallPreferredWomen = new ArrayList<>();
        List<Integer> shortPreferredMen = new ArrayList<>();
        List<Integer> shortPreferredWomen = new ArrayList<>();
        N = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (height > 0){
                tallPreferredMen.add(height);
            } else {
                shortPreferredMen.add(height);
            }
        }

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            int height = Integer.parseInt(st.nextToken());

            if (height > 0){
                tallPreferredWomen.add(height);
            } else {
                shortPreferredWomen.add(height);
            }
        }

        Collections.sort(tallPreferredMen);
        Collections.sort(tallPreferredWomen);
        Collections.sort(shortPreferredMen);
        Collections.sort(shortPreferredWomen);

        System.out.println(combination(tallPreferredMen, shortPreferredWomen) + combination(tallPreferredWomen, shortPreferredMen));
    }

    private static int combination(List<Integer> tallPreferred, List<Integer> shortPreferred){
        int cnt = 0;
        int tallL = 0, shortR = shortPreferred.size() - 1;

        while (tallL < tallPreferred.size() && shortR >= 0){
            if (tallPreferred.get(tallL) + shortPreferred.get(shortR) < 0){
                cnt++;
                tallL++;
                shortR--;
            } else {
                shortR--;
            }
        }
        return cnt;
    }

}
