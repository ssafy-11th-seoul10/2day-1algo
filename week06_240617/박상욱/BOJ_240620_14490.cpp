#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

string arr[100] = { };

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	string str;

	cin >> str;

	int A, B;

	int idx = 0;
	int temp = 0;

	while (str[idx] != ':') {
		temp *= 10;
		temp += (int)(str[idx] - '0');
		idx++;
	}
	idx++;

	A = temp;

	temp = 0;
	while (str[idx] != '\0') {
		temp *= 10;
		temp += (int)(str[idx] - '0');
		idx++;
	}

	B = temp;

	int ansA = A;
	int ansB = B;

	if (B > A) {
		temp = A;
		A = B;
		B = temp;
	}

	while (A != 0 && B != 0) {
		int C = A % B;
		if (C == 0)break;

		A = B;
		B = C;
	}

	cout << ansA / B << ":" << ansB / B << "\n";

	return 0;
}