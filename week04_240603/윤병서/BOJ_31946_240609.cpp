#include <bits/stdc++.h>
using namespace std;

int main() {
	int n, m; cin >> n >> m;
	int mat[n + 1][m + 1];
	for(int i = 0 ; i < n ; i ++){
		for(int j = 0 ; j < m ; j ++){
			cin >> mat[i][j];
		}
	}
	int x; cin >> x;
	
	bool visited[n + 1][m + 1] = {};
	queue<pair <int, int> > q;
	q.push({0, 0});
	visited[0][0] = true;
	while(!q.empty()){
		pair<int, int> tmp = q.front();
        q.pop();
		int cy = tmp.first;
		int cx = tmp.second;
        for(int i = max(0, cy - x); i <= min(cy + x, n - 1); i ++){
            for(int j = max(0, cx - x); j <= min(cx + x, m - 1); j ++){
                if(abs(cy - i) + abs(cx - j) > x) continue;
                if(visited[i][j] == false && mat[0][0] == mat[i][j]){
                    q.push({i, j});
                    visited[i][j] = true;
                }
            }
        }
	}

    if(visited[n - 1][m - 1] == true){
        cout << "ALIVE";
    }
    else cout << "DEAD";
}
