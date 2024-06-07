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

	priority_queue<int>pq;

	//다솜이 표
	int cnt;
	cin >> cnt;

	int answer = 0;

	for (int i = 1; i < N; i++) {
		int temp;
		cin >> temp;
		pq.push(temp);
	}

	while (!pq.empty() && pq.top() >= cnt) {
		answer++;
		cnt++;
		int temp = pq.top();
		pq.pop();
		temp--;
		pq.push(temp);
	}

	cout << answer << "\n";

	return 0;
}