#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int DP[31][31] = { 0, };

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	int N, K;
	cin >> N >> K;

	DP[1][1] = 1;
	for (int i = 2; i <= N; i++) {
		for (int j = 1; j <= i; j++) {
			DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
		}
	}

	cout << DP[N][K];

	return 0;
}