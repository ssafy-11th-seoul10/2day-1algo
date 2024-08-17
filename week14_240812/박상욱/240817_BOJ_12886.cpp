#include<bits/stdc++.h>

using namespace std;

struct Stone {
	int a, b, c;
};

//이미 바꿔놓은 돌이라면 반복 X
int ck[1501][1501] = { 0, };

int main() {

	int A, B, C;
	cin >> A >> B >> C;

	//더이상 돌을 옮기지 못하는 경우

	queue<Stone>q;

	q.push({ A,B,C });

	while (!q.empty()) {
		Stone s = q.front();
		q.pop();

		//모든 돌의 크기가 같은 경우
		if (s.a == s.b && s.b == s.c) {
			std::cout << 1 << "\n";
			return 0;
		}

		//A,B
		if (s.a != s.b) {
			if (s.a > s.b) {
				//X==0인 경우 옮겨도 변화가 없음
				if (s.b > 0) {
					if (!ck[s.a][s.b]) {
						q.push({ s.a - s.b,s.b * 2,s.c });
						ck[s.a][s.b] = 1;
					}
					
				}
			}
			else{
				//X==0인 경우 옮겨도 변화가 없음
				if (s.a > 0) {
					if (!ck[s.b][s.a]) {
						ck[s.b][s.a] = 1;
						q.push({ s.a * 2,s.b - s.a,s.c });
					}
				}
			}
		}

		//B,C
		if (s.b != s.c) {
			if (s.b > s.c) {
				//X==0인 경우 옮겨도 변화가 없음
				if (s.c > 0) {
					if (!ck[s.b][s.c]) {
						ck[s.b][s.c] = 1;
						q.push({ s.a,s.b - s.c,s.c * 2 });
					}
				}
			}
			else {
				//X==0인 경우 옮겨도 변화가 없음
				if (s.b > 0) {
					if (!ck[s.c][s.b]) {
						ck[s.c][s.b] = 1;
						q.push({ s.a,s.b * 2,s.c - s.b });
					}
				}
			}
		}

		//A,C
		if (s.a != s.c) {
			if (s.a > s.c) {
				//X==0인 경우 옮겨도 변화가 없음
				if (s.c > 0) {
					if (!ck[s.a][s.c]) {
						ck[s.a][s.c] = 1;
						q.push({ s.a - s.c,s.b,s.c * 2 });
					}
				}
			}
			else {
				//X==0인 경우 옮겨도 변화가 없음
				if (s.a > 0) {
					if (!ck[s.c][s.a]) {
						ck[s.c][s.a] = 1;
						q.push({ s.a * 2,s.b,s.c - s.a });
					}
				}
			}
		}
	}


	std::cout << 0 << "\n";

	return 0;
}