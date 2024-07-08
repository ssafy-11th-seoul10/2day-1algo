#include<iostream>
#include<cmath>
#include<vector>
#include<algorithm>

using namespace std;

int p[50];
vector<int>crain;
vector<pair<int,int>>box;

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		crain.push_back(num);
	}

	
	sort(crain.begin(), crain.end());
	reverse(crain.begin(), crain.end());

	int M;
	cin >> M;
	for (int i = 0; i < M; i++) {
		int num;
		cin >> num;
		box.push_back({ num,1 });
	}

	for (int i = 0; i < N; i++) {
		p[i] = M - 1;
	}

	sort(box.begin(), box.end());

	int t = 0;

	
	while (1) {

		int flag = 0;
		for (int i = 0; i < N; i++) {

			while (p[i] >= 0 && (box[p[i]].second == 0 || box[p[i]].first > crain[i])) {
				p[i]--;
			}

			if (p[i] >= 0 && box[p[i]].second>0) {
				flag = 1;
				box[p[i]].second--;
				M--;
			}
		}

		if (flag == 0) {
			break;
		}
		t++;
	}
	
	if (M > 0) {
		cout << -1 << "\n";
	}
	else {
		cout << t << "\n";
	}

	return 0;
}