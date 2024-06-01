package ws0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ2577 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int total = 1;
		for(int i = 0; i < 3; i++) {
			total *= Integer.parseInt(br.readLine());	
		}
		int[] nums = new int[10];
		while(total > 0) {
			nums[total%10]++;
			total /= 10;
		}
		for(int i : nums) {
			System.out.println(i);
		}
	}

}
