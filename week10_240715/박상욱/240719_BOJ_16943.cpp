#include<bits/stdc++.h>

using namespace std;

int visit[10] = { 0, };
int arr[10] = { 0, };
int A, B, N=0;
int C = -1;

void BruteForce(int cnt, int num) {
	if (cnt == N) {
		if (num < B && num > C) {
			C = num;
		}
		return;
	}
	for (int i = 0; i < N; i++) {
		if (visit[i])continue;
		if (num * 10 + arr[i] > 0) {
			visit[i] = 1;
			BruteForce(cnt + 1, num * 10 + arr[i]);
			visit[i] = 0;
		}
	}
}

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	
	cin >> A >> B;
	while (A > 0) {
		arr[N++] = A % 10;
		A /= 10;
	}
	BruteForce(0,0);
	
	cout << C << "\n";

	return 0;
}