import java.io.*;
import java.util.*;

public class Main {

    private static class MinsikLan implements Comparable<MinsikLan> {

        private static final Map<Character, Character> dictionary;
        static {
            char[] minsikAlphabet = {'a', 'b', 'k', 'd', 'e', 'g', 'h', 'i', 'l', 'm', 'n', '?', 'o', 'p', 'r', 's', 't', 'u', 'w', 'y'};
            int weight = 'a';

            dictionary = new HashMap<>();
            for (char alphabet : minsikAlphabet) {
                dictionary.put(alphabet, (char)weight++);
            }
        }

        String translatedWord;
        String word;

        public MinsikLan(String word) {
            this.word = word;
            this.translatedWord = translate(word);
        }

        private static String translate(String word){
            StringBuilder sb = new StringBuilder();

            for (int i = 0; i < word.length(); i++){
                if (i < word.length() - 1 && word.charAt(i) == 'n' && word.charAt(i + 1) == 'g'){
                    i++;
                    sb.append(dictionary.get('?'));
                } else {
                    sb.append(dictionary.get(word.charAt(i)));
                }
            }
            return sb.toString();
        }

        @Override
        public int compareTo(MinsikLan ml) {
            return translatedWord.compareTo(ml.translatedWord);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int N = Integer.parseInt(br.readLine());
        MinsikLan[] words = new MinsikLan[N];

        for (int i = 0; i < N; i++){
            words[i] = new MinsikLan(br.readLine());
        }

        Arrays.sort(words);
        for (MinsikLan word : words){
            sb.append(word.word).append('\n');
        }

        System.out.print(sb);
    }

}
