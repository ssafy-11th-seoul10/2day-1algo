package baekjoon;

import java.util.*;
import java.io.*;

public class BOJ12891 {

    static int S, P;
    static String DNA;
    static Map<Character, Integer> acgt = new HashMap<>();
    static Map<Character, Integer> window = new HashMap<>();

    public static boolean check() {
        for(char dna : new char[] {'A', 'C', 'G', 'T'}){
            if(acgt.get(dna) == 0)
                continue;
            if(window.get(dna) < acgt.get(dna)) {
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        S = Integer.parseInt(st.nextToken());
        P = Integer.parseInt(st.nextToken());

        DNA = br.readLine();

        st = new StringTokenizer(br.readLine());

        for(char dna : new char[] {'A', 'C', 'G', 'T'}){
            acgt.put(dna, Integer.parseInt(st.nextToken()));
            window.put(dna, 0);
        }

        // Sliding Window
        int answer = 0;

        for(int i = 0; i < P; i++) {
            window.put(DNA.charAt(i), window.get(DNA.charAt(i)) + 1);
        }

        if(check()) answer++;

        for(int next = P; next < S; next++) {
            int prev = next - P;

            window.put(DNA.charAt(prev), window.get(DNA.charAt(prev)) - 1);
            window.put(DNA.charAt(next), window.get(DNA.charAt(next)) + 1);
            if(check()) answer++;
        }

        System.out.println(answer);
    }
}
