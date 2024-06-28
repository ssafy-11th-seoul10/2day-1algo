import java.util.*;
import java.io.*;

class Solution {
    int[][] map;
    int[] dix={-1,0,1,0};
    int[] diy={0,1,0,-1};
    int N,M;
    int answer=0;
    public int solution(int[][] land) {
                List<Integer> mapper=new ArrayList<>();

        mapper.add(0);
        N=land.length;
        M=land[0].length;
        map=land;

        setting(mapper);
        for(int j=0;j<M;j++){
            Set<Integer> set=new HashSet<>();
            int sum=0;
            for(int i=0;i<N;i++){
                set.add(map[i][j]);
            }
            for(Integer x:set){
                sum+=mapper.get(x);
            }
            answer=Math.max(sum,answer);
        }
        return answer;
    }
    
    private void setting(List<Integer> mapper){
        int number=0;
        boolean[][] visited=new boolean[N][M];
        for(int i=0;i<N;i++){
            for(int j=0;j<M;j++){
                if(map[i][j]==1&&visited[i][j]==false){
                    number++;
                    visited[i][j]=true;
                    mapper.add(groupingOil(i,j,visited,number));
                }
            }
        }
    }
    
    private int groupingOil(int cx,int cy,boolean[][] visited,int number){
        Queue<int[]> queue=new LinkedList<>();
        queue.add(new int[] {cx,cy});
        int cnt=0;
        while(!queue.isEmpty()){
            int x=queue.peek()[0];
            int y=queue.poll()[1];
            cnt++;
            map[x][y]=number;
            for(int i=0;i<4;i++){
                int dx=x+dix[i];
                int dy=y+diy[i];
                if(dx<0||dx>=N||dy<0||dy>=M)
                    continue;
                if(map[dx][dy]==0){
                    continue;
                }
                if(visited[dx][dy]==true)
                    continue;
                visited[dx][dy]=true;
                queue.add(new int[] {dx,dy});
            }  
        }
        return cnt;
    }
}
