#include<bits/stdc++.h>

using namespace std;

int change(int B, int num) {
	string str = "";
	while (num / B > 0) {
		int m = num % B;
		num /= B;
		str += (char)(m);
	}

	str += (char)(num);

	//cout << str <<  "\n";
	int s = 0;
	int e = str.length() - 1;

	int flag = 1;
	while (s < e) {
		if (str[s++] != str[e--]) {
			flag = 0;
			break;
		}
	}
	return flag;
}

int main() {

	int T;
	cin >> T;

	for (int t = 0; t < T; t++) {
		int num;
		cin >> num;

		//
		int flag = 0;
		for (int i = 2; i <= 64; i++) {
			flag = change(i, num);
			if (flag)break;
		}
		cout << flag << "\n";
		
	}

	return 0;
}