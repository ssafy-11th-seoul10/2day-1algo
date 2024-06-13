package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class baekjoon_240613_1991 {
	
	public static class Tree {
        String parent;
        Tree left = null;
        Tree right = null;
        
		public Tree(String parent, Tree left, Tree right) {
			this.parent = parent;
			this.left = left;
			this.right = right;
		}
		
		public Tree() {
			
		}
        
    }

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(in.readLine());
		Tree[] node = new Tree[n+1];
		int cnt=0;
		for(int i=0;i<n;i++) {
			StringTokenizer st = new StringTokenizer(in.readLine());
			String parent = st.nextToken();
			String left = st.nextToken();
			String right = st.nextToken();
			for(int j=0;j<=cnt;j++) {
				if(cnt==0) {
					node[0] =new Tree(parent, null,null);
				}
				if(node[j].parent.equals(parent) ) {
					if(!left.equals(".")) {
						node[++cnt] = new Tree(left, null,null);
						node[j].left = node[cnt];
					}
					if(!right.equals(".")) {
						node[++cnt] = new Tree(right, null,null);
						node[j].right = node[cnt];
					}
				}
			}
		}
		preOrder(node[0]);
		System.out.println();
		inOrder(node[0]);
		System.out.println();
		postOrder(node[0]);
		
	}

	private static void postOrder(Tree t) {
		if(t==null)	return;
		postOrder(t.left);
		postOrder(t.right);
		System.out.print(t.parent);
	}

	private static void inOrder(Tree t) {
		if(t==null)	return;
		inOrder(t.left);
		System.out.print(t.parent);
		inOrder(t.right);
	}

	private static void preOrder(Tree t) {
		if(t==null)	return;
		System.out.print(t.parent);
		preOrder(t.left);
		preOrder(t.right);
	}
}
