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

	while (1) {
		string str;
		cin >> str;

		int flag = 0;

		if (str == "end")break;


		for (int i = 0; i < str.length(); i++) {
			//모음 1개 반드시 포함
			if (str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') {
				flag = 1;
			}
			if (i >= 1 && str[i] == str[i - 1]) {
				if (!(str[i] == 'e' || str[i] == 'o')) {
					flag = 0;
					break;
				}
			}
			if (
				(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') &&
				i >= 2 &&
				(str[i - 1] == 'a' || str[i - 1] == 'e' || str[i - 1] == 'i' || str[i - 1] == 'o' || str[i - 1] == 'u') &&
				(str[i - 2] == 'a' || str[i - 2] == 'e' || str[i - 2] == 'i' || str[i - 2] == 'o' || str[i - 2] == 'u')
				) {
				flag = 0;
				break;
			}
			if (
				!(str[i] == 'a' || str[i] == 'e' || str[i] == 'i' || str[i] == 'o' || str[i] == 'u') &&
				i >= 2 &&
				!(str[i - 1] == 'a' || str[i - 1] == 'e' || str[i - 1] == 'i' || str[i - 1] == 'o' || str[i - 1] == 'u') &&
				!(str[i - 2] == 'a' || str[i - 2] == 'e' || str[i - 2] == 'i' || str[i - 2] == 'o' || str[i - 2] == 'u')
				) {
				flag = 0;
				break;
			}
		}
		
		if (flag) {
			cout << "<" << str << ">" << " " << "is acceptable.\n";
		}
		else {
			cout << "<" << str << ">" << " " << "is not acceptable.\n";
		}

		
		
		
		//같은 글자가 연속 X , 단 ee, oo는 허용
	}

	return 0;
}