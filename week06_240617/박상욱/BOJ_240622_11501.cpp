#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
		
	int T;
	cin >> T;

	for (int t = 0; t < T; t++) {
		vector<int>arr;
		int N;
		cin >> N;

		for (int i = 0; i < N; i++) {
			int temp;
			cin >> temp;
			arr.push_back(temp);
		}

		int i = N - 1, j=N-2;
		long long int ans = 0;
		while (j>=0) {
			if (arr[i] <= arr[j]) {
				int val = arr[i];
				while (i > j) {
					ans += val - arr[i];
					i--;
				}
			}
			j--;
		}
		int val = arr[i];
		while (i >= 0) {
			if (val >= arr[i]) {
				ans += val - arr[i];
				i--;
			}
		}

		cout << ans << "\n";
	}
	

	return 0;
}