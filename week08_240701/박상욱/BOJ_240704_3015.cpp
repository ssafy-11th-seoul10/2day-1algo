#include <bits/stdc++.h>

using namespace std;

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	cin >> N;

	vector<long long int>num;
	stack<long long int>st;
	map<long long int, int>count;

	vector<string>str;

	for (int i = 0; i < N; i++) {
		int height;
		cin >> height;
		num.push_back(height);
	}

	long long int cnt = 0;
	for (int i = 0; i < N; i++) {

		long long int height = num[i];

		//자신보다 키가 작은 사람 다 스택에서 제거
		while (!st.empty()) {
			if (st.top() >= height) {
				break;
			}

			count[st.top()]--;
			st.pop();
			
			cnt++;
		}

		if (!st.empty()) {
			if (st.top() == height) {
				cnt+=count[height];

				//뒤에 더 큰 키가 있는 경우 1 더해주기
				if (st.size() > count[height]) {
					cnt++;
				}
			}
			else {
				cnt ++;
			}
			
		}
		if (count.find(height) == count.end()) {
			count.insert({ height,1 });
		}
		else {
			count[height]++;
		}
		st.push(height);
		
	}

	cout << cnt << "\n";

	
	return 0;
}