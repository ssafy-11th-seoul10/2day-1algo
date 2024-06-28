- 다익스트라는 BFS와 비슷한 방식으로 진행
- 최솟값을 유지시키면서 진행
- 어떤 값을 초기화시키며 진행해야할지를 생각
  
-------------------------------------
  
import java.util.*;
import java.io.*;

class Solution {
    List<int[]>[] connectInfo;
    int N;
    boolean[] isSummits;
    public int[] solution(int n, int[][] paths, int[] gates, int[] summits) {
        setting(n,paths,summits);
        int summitAnswer=0;
        int minAnswer=11111111;
        return startClimb(summits,gates);
    }
    
    private int[] startClimb(int[] summits, int[] gates){
        int summitResult=0;
        int minResult=11111111;
        Queue<int[]> queue=new LinkedList<>();
        int[] visited=new int[N+1];
        for(int i=0;i<=N;i++){
            visited[i]=11111111;
        }
        for(int i=0;i<gates.length;i++){
            queue.add(new int[] {gates[i],0});
            visited[gates[i]]=0;
        }

        while(!queue.isEmpty()){
            int cur=queue.peek()[0];
            int maxDistance=queue.poll()[1];
            //System.out.println(cur+" "+maxDistance);
            if(isSummits[cur]){
                if(minResult>maxDistance){
                    summitResult=cur;
                    minResult=maxDistance;
                }else if(minResult==maxDistance){
                    summitResult=Math.min(summitResult,cur);
                }   
                continue;
            }
            for(int i=0;i<connectInfo[cur].size();i++){
                int destination=connectInfo[cur].get(i)[0];
                int distance=Math.max(connectInfo[cur].get(i)[1],maxDistance);
                if(visited[destination]>distance){
                    visited[destination]=distance;
                    queue.add(new int[] {destination,distance});
                }
            }
        }
        return new int[] {summitResult,minResult};
    }
    
    private void setting(int n,int[][] paths, int[] summits){
        N=n;
        isSummits=new boolean[N+1];
        for(int i=0;i<summits.length;i++){
            isSummits[summits[i]]=true;
        }
        connectInfo=new List[N+1];
        for(int i=0;i<=N;i++){
            connectInfo[i]=new ArrayList<int[]>();
        }
        for(int i=0;i<paths.length;i++){
            for(int j=0;j<paths[0].length;j++){
                 connectInfo[paths[i][0]].add(new int[] {paths[i][1],paths[i][2]});
                connectInfo[paths[i][1]].add(new int[] {paths[i][0],paths[i][2]});
            }
        }
    }
}
