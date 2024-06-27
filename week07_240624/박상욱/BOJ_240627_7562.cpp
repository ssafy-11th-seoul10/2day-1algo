#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int visit[300][300] = { 0, };

struct knight{
	int x, y, cnt;
};
int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	

	int T;
	cin >> T;

	int dx[8] = { 1,-1,1,-1,2,2 ,-2,-2};
	int dy[8] = { 2,2,-2,-2,1,-1,1,-1};

	for (int t = 0; t < T; t++) {
		int l;
		
		for (int i = 0; i < 300; i++) {
			for (int j = 0; j < 300; j++) {
				visit[i][j] = 0;
			}
		}

		int kx, ky, mx, my;

		cin >> l;
		cin >> kx >> ky;
		cin >> mx >> my;

		visit[kx][ky] = 1;
		queue<knight>q;
		q.push({ kx,ky,0 });

		while (!q.empty()) {
			int x = q.front().x;
			int y = q.front().y;
			int cnt = q.front().cnt;
			q.pop();

			if (x == mx && y == my) {
				cout << cnt << "\n";
				break;
			}

			for (int k = 0; k < 8; k++) {
				int tx = x + dx[k];
				int ty = y + dy[k];

				if (tx >= 0 && tx < l && ty >= 0 && ty < l) {
					if (!visit[tx][ty]) {
						visit[tx][ty] = 1;
						q.push({ tx,ty,cnt + 1 });
					}
				}
			}
		}
	}

	return 0;
}

