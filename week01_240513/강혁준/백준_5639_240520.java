import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main {

	static class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			super();
			this.value = value;
		}

	}

	static StringBuilder sb = new StringBuilder();

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

		// get input
		String line = "";
		Node pointer = null;
		Node root = null;
		while ((line = br.readLine()) != null) {
			// process
			// 이진 탐색 트리 구성
			// 전위 순회 한 결과
			// D L R
			Node node = new Node(Integer.parseInt(line));
			if (root == null) {
				root = node;
				continue;
			}

			pointer = root;
			while (true) {
				if (node.value < pointer.value) {
					if (pointer.left != null) {
						pointer = pointer.left;
					} else {
						pointer.left = node;
						break;
					}
				} else {
					if (pointer.right != null) {
						pointer = pointer.right;
					} else {
						pointer.right = node;
						break;
					}
				}
			}

		}

		// post order
		post(root);

		// output
		System.out.println(sb);
	}

	public static void post(Node node) {
		if (node.left != null)
			post(node.left);
		if (node.right != null)
			post(node.right);
		sb.append(node.value).append('\n');
	}

}
