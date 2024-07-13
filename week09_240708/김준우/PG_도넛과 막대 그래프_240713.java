import java.util.*;


class Solution {
    static int E;
    static int[] Arrows = new int[1_000_001];
    static int[] Srrows = new int[1_000_001];
    static int[] Recv = new int[1_000_001];
    static int sNode;
    static List<int[]> sEdges = new ArrayList<int[]>();
    public int[] solution(int[][] edges) {
        
        int[] answer = new int[4];

        E = edges.length;
        for (int i = 0; i < E; i++) {
            int s = edges[i][0];
            if (Arrows[s] > 0) {
                Srrows[s] = edges[i][1];
            } else { 
                Arrows[s] = edges[i][1];
            }
            Recv[edges[i][1]]++;
        }
        for (int i = 0; i < 1_000_001; i++) {
            if (Srrows[i] > 0 && Recv[i] == 0){ 
                sNode = i; break;
            }
        }
        for (int i = 0; i < E; i++) { 
            int s = edges[i][0];
            if (s == sNode) {
                sEdges.add(edges[i]);
            }
        }
        
        
        for (int[] ed : sEdges) {
            boolean isEight = false;
            int start = ed[1];
            int now = start;
            while (Arrows[now] > 0) {
                int nxt = 0;
                if (Srrows[now] > 0) {
                    isEight = true;
                    nxt = Srrows[now];
                    Srrows[now] = -1;
                } else if (Arrows[now] > 0) {
                    nxt = Arrows[now];
                    Arrows[now] = -1;
                }
                now = nxt;
            }
            if (isEight) {
                answer[3]++;
            } else if (Arrows[now] == -1) {
                answer[1]++;
            } else {
                answer[2]++;
            }
        }
        answer[0] = sNode;
        return answer;
    }
}