import java.io.*;
import java.util.*;

public class Main {

    private static class Word{
        int[] spells;

        public Word(String word) {
            this.spells = new int[26];

            for (int i = 0; i < word.length(); i++){
                spells[word.charAt(i) - 'a']++;
            }
        }

        @Override
        public int hashCode() {
            return Arrays.hashCode(spells);
        }

        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (!(obj instanceof Word)) return false;
            Word w = (Word)obj;
            return Arrays.equals(this.spells, w.spells);
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Map<String, List<Map<Word, String>>> dictionary = new HashMap<>();
        int N = Integer.parseInt(br.readLine());

        for (int i = 0; i < N; i++){
            String s = br.readLine();
            String key = s.length() == 1 ? s : "" + s.charAt(0) + s.charAt(s.length() - 1);
            Map<Word, String> value = new HashMap<>();

            value.put(new Word(s), s);
            dictionary.putIfAbsent(key, new ArrayList<>());
            dictionary.get(key).add(value);
        }

        int M = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < M; i++){
            String s = st.nextToken();
            List<Map<Word, String>> candidates = dictionary.get(s.length() == 1 ? s : "" + s.charAt(0) + s.charAt(s.length() - 1));

            for (Map<Word, String> candidate : candidates){
                String ans = candidate.get(new Word(s));
                if (ans != null) {
                    sb.append(ans).append(' ');
                    break;
                }
            }
        }

        System.out.println(sb);
    }

}
