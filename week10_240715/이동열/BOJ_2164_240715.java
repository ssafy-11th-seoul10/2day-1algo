package boj;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayDeque;
import java.util.Deque;

public class BOJ2164 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Deque<Integer> deque = new ArrayDeque<>();
        for (int i = 1; i <=N; i++) {
            deque.add(i);
        }
        while (deque.size()>1){
            deque.pollFirst();
            deque.addLast(deque.pollFirst());
        }
        System.out.println(deque.pollFirst());
    }
}
