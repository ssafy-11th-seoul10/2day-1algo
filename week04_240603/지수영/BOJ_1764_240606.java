package ws0607;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ1764 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st = new StringTokenizer(br.readLine());
		int NHeard = Integer.parseInt(st.nextToken());
		int NSeen = Integer.parseInt(st.nextToken());
		
		List<String> NHeardSeen = new ArrayList<>();
		
		HashSet<String> notHeard = new HashSet<>();
		
		int size = 0;
		for (int i = 0; i < NHeard; i++) {
			notHeard.add(br.readLine());
		}
		for (int i = 0; i < NSeen; i++) {
			String name = br.readLine();
			if(notHeard.contains(name)) {
				size++;
				NHeardSeen.add(name);
			}
		}
		Collections.sort(NHeardSeen);;
		sb.append(size).append("\n");
		
		for(String name:NHeardSeen) {
			sb.append(name).append("\n");
		}
		System.out.println(sb);
	}

}
