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
		
	int N;

	cin >> N;

	int cnt = 0;
	int idx = 0;
	for (int i = 1; i <= N; i++) {
		int tempCnt = 2;

		int first = N;
		int second = i;
		while (first - second >= 0) {
			int temp = first - second;
			first = second;
			second = temp;
			tempCnt++;
		}
		if (cnt < tempCnt) {
			cnt = tempCnt;
			idx = i;
		}
	}

	cout << cnt << "\n";

	int first = N;
	int second = idx;

	cout << first << " ";

	while (first - second >= 0) {
		int temp = first - second;
		first = second;
		second = temp;
		cout << first << " ";
	}
	cout << second << " ";

	return 0;
}