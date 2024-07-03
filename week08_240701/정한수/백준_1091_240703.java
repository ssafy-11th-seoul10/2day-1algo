import java.io.*;
import java.util.*;

public class Main {

    private static int[] P, S;

    private static boolean isEnd(int[] cards){
        for (int i = 0; i < cards.length; i++){
            if (P[cards[i]] != i % 3){
                return false;
            }
        }
        return true;
    }

    private static int getMaxNumOfCases(){
        BitSet check = new BitSet(S.length);
        int numberOfCases = 1;

        for (int i = 0; i < S.length; i++){
            if (check.get(i)) continue;
            int cnt = 1;

            check.set(i);
            for (int j = S[i]; j != i; j = S[j]){
                check.set(j);
                cnt++;
            }
            numberOfCases *= cnt;
        }
        return numberOfCases;
    }

    private static void shuffle(int[] cards){
        BitSet check = new BitSet(cards.length);

        for (int i = 0; i < cards.length; i++){
            if (check.get(i)){
                continue;
            }

            int preCard = cards[i], tmpCard = -1;
            check.set(i);
            for (int cur = S[i]; cur != i; cur = S[cur]){
                check.set(cur);
                tmpCard = cards[cur];
                cards[cur] = preCard;
                preCard = tmpCard;
            }
            cards[i] = preCard;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int[] cards = new int[N];

        for (int i = 0; i < N; i++){
            cards[i] = i;
        }

        StringTokenizer st = new StringTokenizer(br.readLine());
        P = new int[N];
        for (int i = 0; i < N; i++) {
            P[i] = Integer.parseInt(st.nextToken());
        }

        st = new StringTokenizer(br.readLine());
        S = new int[N];
        for (int i = 0; i < N; i++) {
            S[i] = Integer.parseInt(st.nextToken());
        }

        if (isEnd(cards)){
            System.out.println(0);
            return;
        }

        int maxCases = getMaxNumOfCases();

        for (int i = 1; i <= maxCases; i++){
            shuffle(cards);
            if (isEnd(cards)){
                System.out.println(i);
                return;
            }
        }
        System.out.println(-1);
    }
    
}
