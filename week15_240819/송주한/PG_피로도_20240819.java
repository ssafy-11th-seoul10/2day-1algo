package PG;

public class PG_피로도_20240819 {

	public static int ans=0;
    public static boolean[] visited;
    public int solution(int k, int[][] dungeons) {
        int answer = -1;
        visited = new boolean[dungeons.length];
        int count =0;
        check(k, dungeons, count);
        answer = ans;
        return answer;
    }
    
    static void check(int k, int[][] dungeons, int count){
        if(count == dungeons.length){
            ans =Math.max(count , ans);
            return;
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(k>=dungeons[i][0] && visited[i]==false){
                visited[i] = true;
                check(k-dungeons[i][1],dungeons,count+1);
                visited[i] = false;
            }
        }
        
        ans = Math.max(count , ans);
        return;
    }
    
}
