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


	string a = "AAAA";
	string b = "BB";

	string str;
	cin >> str;

	string ans = "";

	int cnt = 0;
	for (int i = 0; i < str.length(); i++) {
		cnt++;
		if (str[i] == '.') {
			ans += ".";
			cnt = 0;
		}
		else if (str[i + 1] == '\0' || str[i + 1] == '.' ) {
			if (cnt > 0) {
				if (cnt % 2 > 0) {
					ans = "-1";
					break;
				}
				else {
					for (int j = 0; j < cnt / 4; j++) {
						ans += a;
					}
					if (cnt % 4 >0) {
						ans += b;
					}
				}
			}
			cnt = 0;
		}

	}

	cout << ans << "\n";

	

	return 0;
}
