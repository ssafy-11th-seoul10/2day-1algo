#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int DP[21][21] = { 0, };
int arr[12] = { 0, 1, 4, 6, 8, 9, 10, 12, 14, 15, 16, 18 };

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	DP[0][0] = 1;
	DP[1][1] = 1;
	for (int i = 1; i <= 20; i++) {
		DP[i][0] = DP[i][1] = 1;
		for (int j = 1; j <= i; j++) {
			DP[i][j] = DP[i - 1][j - 1] + DP[i - 1][j];
		}
	}

	double A, B;
	cin >> A >> B;

	A /= 100;
	B /= 100;

	double sA = 0, sB = 0;

	//두 팀 모두 소수가 아닌 골을 넣을 확률
	for (int i = 0; i < 12; i++) {
		//nCr * a^r * (1-a)^n-r

		sA += (double)DP[18][arr[i]] * pow(A, arr[i])* pow(1. - A, 18 - arr[i]);
		sB += (double)DP[18][arr[i]] * pow(B, arr[i]) * pow(1. - B, 18 - arr[i]);
	}

	cout << 1 - (sA * sB);

	return 0;
}

