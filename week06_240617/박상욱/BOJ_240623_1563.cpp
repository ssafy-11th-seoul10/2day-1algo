#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

//연속 결석일, 지각횟수
long long int DP[1001][3][2] = {0,};

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	int N;
	cin >> N;

	DP[1][0][0] = 1;
	DP[1][0][1] = 1;
	DP[1][1][0] = 1;

	//DP
	for (int i = 2; i <= N; i++) {
		DP[i][0][0] = (DP[i - 1][0][0] + DP[i - 1][1][0] + DP[i - 1][2][0]) % 1000000;
		DP[i][0][1] = (DP[i - 1][0][0] + DP[i - 1][1][0] + DP[i - 1][2][0] + DP[i-1][0][1] + DP[i-1][1][1] + DP[i-1][2][1]) % 1000000;

		DP[i][1][0] = (DP[i - 1][0][0]) % 1000000;
		DP[i][1][1] = (DP[i - 1][0][1]) % 1000000;

		DP[i][2][0] = (DP[i - 1][1][0]) % 1000000;
		DP[i][2][1] = (DP[i - 1][1][1]) % 1000000;
	}

	cout << (DP[N][0][0] + DP[N][0][1] + DP[N][1][0] + DP[N][1][1] + DP[N][2][0] + DP[N][2][1])%1000000 << "\n";
	return 0;
}

