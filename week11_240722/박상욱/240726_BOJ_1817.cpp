#include <bits/stdc++.h>

using namespace std;

int N, M;
int cnt = 0;
vector<int>w;

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	cin >> N >> M;
	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		w.push_back(num);
	}

	int weight = 0;
	for (int i = 0; i < N; i++) {
		if (weight + w[i] > M) {
			cnt++;
			weight = w[i];
		}
		else {
			weight += w[i];
		}
	}

	if (weight > 0)cnt++;
	cout << cnt << "\n";

	return 0;
}

