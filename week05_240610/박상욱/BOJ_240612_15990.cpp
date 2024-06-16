#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

long long int DP[100001][4] = {0,};

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	DP[1][1] = 1;
	DP[2][2] = 1;
	DP[3][1] = 1;
	DP[3][2] = 1;
	DP[3][3] = 1;

	for (int i = 4; i <= 100000; i++) {
		DP[i][1] = (DP[i - 1][2] + DP[i - 1][3]) % 1000000009;
		DP[i][2] = (DP[i - 2][1] + DP[i - 2][3]) % 1000000009;
		DP[i][3] = (DP[i - 3][2] + DP[i - 3][1]) % 1000000009;
	}

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;

		cout << (DP[num][1] + DP[num][2] + DP[num][3]) % 1000000009 << "\n";
	}

	return 0;
}

