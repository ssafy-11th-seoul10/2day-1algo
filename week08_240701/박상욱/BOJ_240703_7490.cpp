#include<iostream>
#include<string>

using namespace std;

int calc(string str) {
	int ans = 0;

	int temp = 0;

	char op = '0';
	for (int i = 0; i < str.length(); i++) {
		if (str[i] >= '0' && str[i] <= '9') {
			temp *= 10;
			temp += (str[i] - '0');
		}
		else {
			if (str[i] == ' ') {
				continue;
			}
			else if (op == '0') {
				ans = temp;
				temp = 0;

				op = str[i];
			}
			else if (op == '+') {
				ans += temp;
				temp = 0;
				
				op = str[i];
			}
			else if (op == '-') {
				ans -= temp;
				temp = 0;

				op = str[i];
			}
		}
	}

	if (op == '+' || op=='0') {
		ans += temp;
		temp = 0;
	}
	else if (op == '-') {
		ans -= temp;
		temp = 0;
	}

	return ans;
}

void BruteForce(int idx, string str) {
	if (idx == str.length()-1){
		if (calc(str) == 0) {
			cout << str << "\n";
		}
	}
	else {
		string temp1(str);
		string temp2(str);
		string temp3(str);

		BruteForce(idx + 2, temp1.insert(idx + 1, " "));
		BruteForce(idx + 2, temp2.insert(idx + 1, "+"));
		BruteForce(idx + 2, temp3.insert(idx + 1, "-"));
	}
}

int main() {
	int T;
	cin >> T;

	for (int t = 0; t < T; t++) {
		int num;
		cin >> num;

		string str = "";

		for (int i = 1; i <= num; i++) {
			str += (i + '0');
		}

		BruteForce(0, str);
		cout << "\n";
	}

	return 0;
}