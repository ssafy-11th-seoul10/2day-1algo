#include<bits/stdc++.h>

using namespace std;

int main() {

	int T;

	cin >> T;

	for (int t = 0; t < T; t++) {
		int K;
		cin >> K;

		vector<string> str;
		for (int k = 0; k < K; k++) {
			string s;
			cin >> s;
			str.push_back(s);
		}

		int cnt = 0;

		for (int i = 0; i < K; i++) {
			for (int j = 0; j < K; j++) {
				int flag = 1;
				if (i == j)continue;
				string temp = str[i] + str[j];

				int s = 0;
				int e = temp.length()-1;

				
				while (s < e) {
					if (temp[s++] != temp[e--]) {
						flag = 0;
						break;
					}
				}

				if (flag) {
					cout << temp << "\n";
					cnt++;
					break;
				}
			}
			if (cnt > 0)break;
		}
		
		if (cnt==0) {
			cout << 0 << "\n";
		}
	}

	return 0;
}