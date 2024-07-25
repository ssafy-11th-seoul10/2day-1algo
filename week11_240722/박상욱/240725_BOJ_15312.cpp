#include<bits/stdc++.h>

using namespace std;

int arr[26] = { 3, 2, 1, 2, 3, 3, 2, 3, 3, 2, 2, 1, 2, 2, 1, 2, 2, 2, 1, 2, 1, 1, 1, 2, 2, 1 };
int ans[4001] = { 0, };

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	string s1, s2;
	
	cin >> s1 >> s2;

	int len = s1.length();

	int j = 0;
	for (int i = 0; i < len; i++) {
		ans[j++] = arr[(s1[i] - 'A')];
		ans[j++] = arr[(s2[i] - 'A')];
	}

	len *= 2;

	while (len > 2) {
		for (int i = 0; i < len-1; i++) {
			ans[i] = (ans[i] + ans[i + 1]) % 10;
		}
		len--;
	}

	cout << ans[0] << ans[1] << "\n";

	return 0;
}