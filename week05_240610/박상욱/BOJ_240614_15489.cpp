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

	DP[1][1] = 1;
	for (int i = 2; i <= 30; i++) {
		for (int j = 1; j <= i; j++) {
			DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
		}
	}

	int R, C, W;
	cin >> R >> C >> W;

	int ans = 0;
	for (int i = R; i <= R + W - 1; i++) {
		for (int j = C; j <= C + i - R; j++) {
			ans += DP[i][j];
		}
	}

	cout << ans << "\n";

	return 0;
}

