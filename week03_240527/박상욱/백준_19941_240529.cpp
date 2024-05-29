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
	int K;
	int cnt = 0;

	queue<int> H;

	string str;

	cin >> N >> K >> str;

	//햄버거 위치와 사람 위치를 갱신
	for (int i = 0; i < N; i++) {
		if (str[i] == 'H') {
			H.push(i);
		}
	}

	for (int i = 0; i < N; i++) {
		//사람인 경우
		if (str[i] == 'P') {
			while (!H.empty() && i - H.front() > K) {
				H.pop();
			}
			if (!H.empty() && abs(i - H.front()) <= K) {
				cnt++;
				H.pop();
			}
		}
	}
	cout << cnt << "\n";

	return 0;
}
