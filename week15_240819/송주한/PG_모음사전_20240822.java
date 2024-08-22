package PG;

public class PG_모음사전_20240822 {

	 public int solution(String word) {
	        int answer = 1;
	        boolean t = true;
	        String check= "A";
	        while(true){
	            if(check.equals(word)){
	                break;
	            }
	            answer++;
	            int n = check.length();
	            if(n<5){
	                check += "A";
	            }else if(n==5){
	                char last = check.charAt(4);
	                char[] point = check.toCharArray();
	                check = fun(last , point , n);
	            }
	        }
	        return answer;
	    }
	    static String fun(char last,char[] point, int n){
	        if(last=='A'){
	            point[n-1] = 'E';
	            String str = "";
	            for(int i=0;i<n;i++){
	                str += point[i];
	            }
	            return str;
	        }else if(last=='E'){
	            point[n-1] = 'I';
	            String str = "";
	            for(int i=0;i<n;i++){
	                str += point[i];
	            }
	            return str;                    
	        }else if(last=='I'){
	            point[n-1] = 'O';
	            String str = "";
	            for(int i=0;i<n;i++){
	                str += point[i];
	            }
	            return str;                    
	        }else if(last=='O'){
	            point[n-1] = 'U';
	            String str = "";
	            for(int i=0;i<n;i++){
	                str += point[i];
	            }
	            return str;                    
	        }else if(last=='U'){
	            last = point[n-2];
	            return fun (last , point , n-1);
	        }
	        return "";
	    }
}
