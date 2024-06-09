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

	string str;
	int cnt = 0;
	cin >> str;

	int num = 0;

	if (str.length() > 1) {
		for (int i = 0; i < str.length(); i++) {
			num += str[i] - '0';
		}
		cnt++;
	}
	else {
		num = str[0] - '0';
	}
	

	while (num >= 10) {
		int temp = 0;
		while (num > 0) {
			temp += num % 10;
			num /= 10;
		}
		num = temp;
		cnt++;
	}

	cout << cnt << "\n";

	if (num % 3 == 0) {
		cout << "YES" << "\n";
	}
	else cout << "NO" << "\n";

	return 0;
}