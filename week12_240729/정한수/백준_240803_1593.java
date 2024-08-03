import java.io.*;
import java.util.*;

public class Main {

    private static class Word {
        private final Map<Character, Integer> map = new HashMap<>();

        public Word(String w){
            for (int i = 0; i < w.length(); i++){
                char c = w.charAt(i);
                map.put(c, map.getOrDefault(c, 0) + 1);
            }
        }

        public boolean equals(Map<Character, Integer> map){
            return this.map.equals(map);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<Character, Integer> map = new HashMap<>();
        StringTokenizer st = new StringTokenizer(br.readLine());
        String W = br.readLine(), S = br.readLine();
        Word word = new Word(W);
        int g = Integer.parseInt(st.nextToken()), s = Integer.parseInt(st.nextToken());
        int l = 0, r = 0, cnt = 0;


        while (r < g){
            char c = S.charAt(r++);
            map.put(c, map.getOrDefault(c, 0) + 1);
        }

        if (word.equals(map)){
            cnt++;
        }

        while (r < s){
            char rc = S.charAt(r++);
            char lc = S.charAt(l++);

            map.put(rc, map.getOrDefault(rc, 0) + 1);
            map.put(lc, map.get(lc) - 1);
            if (map.get(lc) == 0){
                map.remove(lc);
            }

            if (word.equals(map)){
                cnt++;
            }
        }

        System.out.println(cnt);
    }

}
