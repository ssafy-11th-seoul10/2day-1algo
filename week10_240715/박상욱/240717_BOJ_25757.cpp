#include<bits/stdc++.h>

using namespace std;

set<string>name;

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	char k; int K;

	cin >> N >> k;
	if (k == 'Y')K = 1;
	if (k == 'F')K = 2;
	if (k == 'O')K = 3;

	for (int i = 0; i < N; i++) {
		string str;
		cin >> str;
		if (name.find(str) == name.end()) {
			name.insert(str);
		}
	}

	cout << name.size() / K;
	

	return 0;
}