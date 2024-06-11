#include<iostream>

using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int len;
		int cnt = 0;
		cin >> len;

		string s1, s2;
		cin >> s1 >> s2;

		//O(n)
		int cntB = 0, cntW = 0;
		for (int j = 0; j < len; j++) {
			if (s1[j] != s2[j]) {
				if (s1[j] == 'B') {
					cntB++;
				}
				else {
					cntW++;
				}
			}
		}

		cnt = min(cntB, cntW) + abs(cntB - cntW);

		cout << cnt << "\n";
	}


	
	return 0;
}
