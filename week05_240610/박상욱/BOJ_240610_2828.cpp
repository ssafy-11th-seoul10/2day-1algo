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

	int N, M;
	cin >> N >> M;

	int j;
	int pos = 1;
	int cnt = 0;
	cin >> j;

	for (int i = 0; i < j; i++) {
		int apple;
		cin >> apple;

		//담을 수 없다면
		if (!(apple >= pos && apple < pos + M)) {
			//왼쪽이 더 가까운 경우
			if (abs(apple - pos) < abs(apple - (pos + M))) {
				cnt += abs(apple - pos);
				pos -= abs(apple - pos);
				
			}
			else {
				cnt += abs(apple - (pos + M - 1));
				pos += abs(apple - (pos + M - 1));
				
			}
		}
	}

	cout << cnt << "\n";

	return 0;
}