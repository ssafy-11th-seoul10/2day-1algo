#include<bits/stdc++.h>

using namespace std;

int B[101][101];

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, M;
	cin >> N >> M;

	const int INF = INT_MAX;

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			B[i][j] = 1000000;
			if (i == j)B[i][j] = 0;
		}
	}
	for (int i = 0; i < M; i++) {
		int a, b;
		cin >> a >> b;

		B[a][b] = 1;
		B[b][a] = 1;
	}
	for (int k = 1; k <= N; k++) {

	for (int i = 1; i <= N; i++) {
		for (int j = 1; j <= N; j++) {
			B[i][j] = min(B[i][j], B[i][k] + B[k][j]);
		}
	}
	}
	
	int a = 101, b = 101;
	int sum = INT_MAX;

	//2개 고르기
	for (int i = 1; i <= N; i++){
		for (int j = 1; j <= N; j++) {
			//검사
			int tempSum = 0;
			for (int k = 1; k <= N; k++) {
				tempSum += 2 * min(B[k][i], B[k][j]);
			}
			
			if (tempSum < sum) {
				a = (i>j?j:i);
				b = (i > j ? i : j);
				sum = tempSum;
			}
			else if (tempSum == sum) {
				int mi = (i > j ? j : i);
				int ma = (i > j ? i : j);

				a = (a > mi ? mi : a);
				b = (b > ma ? ma : b);
			}
		}
	}

	cout << a << " " << b << " " << sum;

	return 0;
}
