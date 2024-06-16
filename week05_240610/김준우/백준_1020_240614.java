import java.io.*;
import java.util.*;



class Main {
	static String n;
	static boolean overflow = false;
	static int[] data = new int[] {6, 2, 5, 5, 4, 5, 6, 3, 7, 5}; 
	static HashMap<Integer, Integer>[] tb = new HashMap[10];
	
	public static void makeTable() {
		for (int i = 0; i < 10; i++) {
			for (int j = i+1; j < 10; j++) {
				int key = - data[i] + data[j];
				if (!tb[i].containsKey(key)) {
					tb[i].put(key, j);
				}
			}
		}
	}
	
	public static int getSumString(String str) {
		int sum = 0;
		for (int i = 0; i < str.length(); i++) {
			char ch = str.charAt(i);
			sum += data[ch - '0'];
		}
		return sum;
	}
	
	public static String makeZeroString(int n) {
		char[] chars = new char[n];
		for (int i = 0; i < n; i++) {
			chars[i] = '0';
		}
		return String.valueOf(chars);
	}
	
	public static int isPossibleInSameDigit(String m, int dest_sum) {
		int gap = dest_sum - getSumString(m);
		
		if (m.length() == 1) {
			if (tb[Integer.parseInt(m)].containsKey(gap)) {
				return  tb[Integer.parseInt(m)].get(gap);
			}
			else {
				return -1;
			}
		}
		int sum = 0;
		long lm = Long.parseLong(m);
		long div = 10;
		for (int i = 1; i < m.length(); i++) {
			sum += data[m.charAt(i) - '0'];
		}
		sum += gap;
		int min = (m.length() - 1) * 2 - sum;
		int max = (m.length() - 1) * 7 - sum;
		int first = m.charAt(0) - '0';
		int nxt = 1;
		while (first + nxt < 10) {
			if (data[first] - data[first + nxt] >= min && data[first] - data[first + nxt] <= max) {
				return first + nxt;
			} else {
				nxt++;
			}
		}
		return -1;
	}
	
	public static String BottomUp(String n, int dest_sum) {
		// value_of_n - gap = value_of_destination
//		System.out.println("---- bottom up start ----");
//		System.out.println("n : " + n);
//		System.out.println("dest_sum : " + dest_sum);
		
		int gap = dest_sum - getSumString(n);
		int size = 1;
		String m = n.substring(n.length() - size);
		int ipisd = isPossibleInSameDigit(m, getSumString(m) + gap);
		while (size++ < n.length() && ipisd < 0) {
			m = n.substring(n.length() - size);
			ipisd = isPossibleInSameDigit(m, getSumString(m) + gap);
		}
		
//		System.out.println("size : " +  (n.length() - size + 1));
//		System.out.println("m : " + m);
//		System.out.println("ipisd : " + ipisd);
		if (ipisd > 0) {
			char[] mm = m.toCharArray();
			int before = mm[0] - '0';
			mm[0] = (char) (ipisd + '0');
			m = String.valueOf(mm);
			
//			System.out.println("m : " + m);

			if (m.length() > 1) {
				String zero_string = makeZeroString(m.length()-1);
				String substr;
				if (getSumString(m.charAt(0) + zero_string) == dest_sum - getSumString(n.substring(0, n.length() - m.length()))) {
					substr = m.charAt(0) + zero_string;
				}
				else {
					substr = BottomUp( m.charAt(0) + zero_string, dest_sum - getSumString(n.substring(0, n.length() - m.length())));
				}
				char[] nn = n.toCharArray();
				char[] ss = substr.toCharArray();
				for (int i = 0; i < substr.length(); i++) {
					nn[nn.length - 1 - i] = ss[ss.length - 1 - i];
				}
				return String.valueOf(nn);
			}
			else {
				char[] nn = n.toCharArray();
				char[] ss = m.toCharArray();
				for (int i = 0; i < m.length(); i++) {
					nn[nn.length - 1 - i] = ss[ss.length - 1 - i];
				}
				return String.valueOf(nn);
			}
		}
		else {
			overflow = true;
			if (dest_sum == getSumString(makeZeroString(n.length()))) {
				return makeZeroString(n.length());
			}
			return BottomUp(makeZeroString(n.length()), dest_sum);
		}
	}
	
	
	public static void main(String args[]) throws IOException {
		System.setIn(new FileInputStream("res/input.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//		StringTokenizer st = new StringTokenizer(br.readLine());
//		StringBuilder sb = new StringBuilder();
		n = br.readLine();
		for (int i = 0; i < 10; i++) {
			tb[i] = new HashMap<>();
		}
		
		makeTable();
		
//		for (int i = 0; i < 10; i++) {
//			System.out.println("i : " + i);
//			for(Integer key : tb[i].keySet()) {
//				System.out.println("key : " + key + ", value : " + tb[i].get(key));
//			}
//		}
		
		long l = Long.parseLong(BottomUp(n, getSumString(n)));
		long ln = Long.parseLong(n);
		long ans = l - ln;
		if (overflow) {
			ans += Math.pow(10, (double)n.length());
		}
		
		System.out.println(ans);
		
//		System.out.println(isPossibleInSameDigit("88"));
		
		
		
	}
}