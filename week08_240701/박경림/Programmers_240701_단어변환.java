import java.util.*;

class Solution {
    private class Node {
        String word;
        int count;
        
        public Node(String word, int count) {
            this.word = word;
            this.count = count;
        }
    }
    
    public int solution(String begin, String target, String[] words) {
        boolean[] visited = new boolean[words.length];
        Queue<Node> q = new ArrayDeque<>();
        q.add(new Node(begin, 0));
        
        while (!q.isEmpty()) {
            Node temp = q.poll();
            if (temp.word.equals(target)) {
                return temp.count;
            }
            
            for (int i = 0; i < words.length; i++) {
                int diff = 0;
                for (int j = 0; j < words[i].length(); j++) {
                    if (temp.word.charAt(j) != words[i].charAt(j)) {
                        diff++;
                    }
                }
                
                if (!visited[i] && diff == 1) {
                    q.add(new Node(words[i], temp.count + 1));
                    visited[i] = true;
                }
            }
        }
        
        return 0;
    }
}
