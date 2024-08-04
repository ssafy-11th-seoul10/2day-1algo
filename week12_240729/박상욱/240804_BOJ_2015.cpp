#include <bits/stdc++.h>

using namespace std;

long long int prefixSum[200001] = { 0, };
map<long long int, long long int> sum;

long long int N, K;

long long int answer = 0;

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> N >> K;

	for (int i = 1; i <= N; i++) {
		cin >> prefixSum[i];
		prefixSum[i] += prefixSum[i - 1];

		//K인 부분합인 경우
		if (prefixSum[i] == K) {
			answer++;
		}
		//더했을 때 K인 부분합이 있는 경우
		if (sum.find(prefixSum[i]-K) != sum.end()) {
			answer += sum[prefixSum[i]-K];
		}
		//부분합이 존재하는 경우
		//이미 존재하는 부분합 초기화
		if (sum.find(prefixSum[i]) != sum.end()) {
			sum[prefixSum[i]] = sum[prefixSum[i]] + 1;
		}
		else {
			sum[prefixSum[i]] = 1;
		}
	}

	cout << answer << "\n";

	return 0;
}

