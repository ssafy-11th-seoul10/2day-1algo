/******************************************************************************

                            Online Java Compiler.
                Code, Compile, Run and Debug java program online.
Write your code in this editor and press "Run" button to execute it.

*******************************************************************************/

import java.util.*;
import java.io.*;

public class Main
{
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static StringBuilder sb = new StringBuilder();
    static StringTokenizer st = null;
    
	public static void main(String[] args) throws IOException {
	    
	    int N = Integer.parseInt(br.readLine());
	    
	    st = new StringTokenizer(br.readLine());
	    
	    int[] arr = new int[N];
	    
	    for(int i=0;i<N;i++){
	        arr[i] = Integer.parseInt(st.nextToken());
	    }
	    
	    Arrays.sort(arr);
	    
	    int x = Integer.parseInt(br.readLine());
	    
	    int i = 0;
	    int j = N-1;
	    
	    int answer = 0;
	    while(i<j){
	        if(arr[i] + arr[j] == x){
	            answer++;
	        }
	        
	        if(arr[i] + arr[j] > x){
	            j--;
	        }
	        else{
	            i++;
	        }
	    }
	    
	    sb.append(answer);
	    
		System.out.println(sb);
	}
}