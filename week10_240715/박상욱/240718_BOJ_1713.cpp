#include<bits/stdc++.h>

using namespace std;

struct Photo{
	int number;
	int recommend;
	int t;
};

bool compare(Photo &p1, Photo &p2) {
	return p1.number < p2.number;
}

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N, R;
	cin >> N >> R;

	vector<Photo>p(N);
	for (int i = 0; i < N; i++) {
		p[i] = { 0,0,0 };
	}

	for (int i = 1; i <= R; i++) {
		int num;
		cin >> num;

		//넣을 칸
		int idx = -1;
		//없는 경우 제거할 칸
		int idxRm = -1;
		int cnt = 10000;
		int t = 10000;

		for (int j = 0; j < N; j++) {
			if (p[j].number == 0)idx = j;
			if (p[j].number == num) {
				idx = j;
				break;
			}
			if (p[j].recommend < cnt) {
				idxRm = j;
				cnt = p[j].recommend;
				t = p[j].t;
			}
			else if (p[j].recommend == cnt && p[j].t < t) {
				idxRm = j;
				cnt = p[j].recommend;
				t = p[j].t;

			}
		}

		if (idx >= 0) {
			//이미 게시된 사진
			if (p[idx].number == num) {
				p[idx].recommend++;
			}
			//새로 게시하는 경우
			else {
				p[idx].number = num;
				p[idx].recommend = 1;
				p[idx].t = i;
			}
		}
		//삭제하는 경우
		else {
			p[idxRm].number = num;
			p[idxRm].recommend = 1;
			p[idxRm].t = i;
		}

	}
	
	sort(p.begin(), p.end(), compare);

	for (int i = 0; i < N; i++) {
		if (p[i].number > 0) {
			cout << p[i].number << " ";
		}
		
	}

	return 0;
}