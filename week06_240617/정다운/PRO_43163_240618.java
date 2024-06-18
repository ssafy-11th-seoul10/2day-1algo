package programmers;

import java.util.*;
import java.io.*;

public class PRO43163 {

    static class data {
        String word;
        int cnt;

        public data(String word, int cnt) {
            this.word = word;
            this.cnt = cnt;
        }
    }

    static char[] alphabet = {'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
        'o', 'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z'
    };

    public static int bfs(String start, String target, String[] words) {

        Queue<data> queue = new ArrayDeque<>();
        queue.add(new data(start, 0));

        boolean[] visited = new boolean[words.length];

        while (!queue.isEmpty()) {
            data cur_data = queue.poll();

            if(cur_data.word.equals(target))
                return cur_data.cnt;

            // 단어의 한 알파벳에 대해
            for(int word_idx = 0; word_idx < cur_data.word.length(); word_idx++)
                // 알파벳에 대해
                for(int alpha_idx = 0; alpha_idx < alphabet.length; alpha_idx++) {
                    char[] word_arr = cur_data.word.toCharArray();
                    word_arr[word_idx] = alphabet[alpha_idx];

                    // 단어 모음집에 대해
                    for(int words_idx = 0; words_idx < words.length; words_idx++) {
                        String tmp = "";
                        if((tmp = String.valueOf(word_arr)).equals(words[words_idx]) && !visited[words_idx]) {
                            visited[words_idx] = true;
                            queue.add(new data(tmp, cur_data.cnt + 1));
                        }
                    }
                }

        }

        return 0;
    }

    public static int solution(String begin, String target, String[] words) {
        int answer = Integer.MAX_VALUE;

        answer = Math.min(answer, bfs(begin, target, words));

        return answer;
    }

    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        int res = solution(begin, target, words);

        System.out.println(res);
    }
}
