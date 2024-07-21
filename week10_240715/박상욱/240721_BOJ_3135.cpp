#include <bits/stdc++.h>

using namespace std;

int channel[5] = { 0, };

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int A, B;
	cin >> A >> B;

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		cin >> channel[i];
	}
	
	int ans = abs(B - A);

	for (int i = 0; i < N; i++) {
		ans = min(ans, abs(B - channel[i]) + 1);
	}

	cout << ans << "\n";

	return 0;
}

