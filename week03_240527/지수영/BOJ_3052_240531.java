package ws0530;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class BOJ3052 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		
		List<Integer> nums = new ArrayList<Integer>();
		
		for (int i = 0; i < 10; i++) {
			int left = Integer.parseInt(br.readLine())%42;
			if(!nums.contains(left)) {
				nums.add(left);
			}
		}
		System.out.println(nums.size());
	}

}
