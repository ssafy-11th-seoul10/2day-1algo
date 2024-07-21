#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0);
	int n, k; cin >> n >> k;
	int a[n + 1];
	int chk[100001] = {};
	queue<int> q;
	int ans = 0;
	for(int i = 0 ; i < n ; i ++){
		cin >> a[i];
		chk[a[i]] ++;
		q.push(a[i]);
		if(chk[a[i]] > k){
			while(chk[a[i]] > k){
				int tmp = q.front();
				chk[q.front()] --;
				q.pop();
			}
		}
		ans = max(ans, (int) q.size());
	}
	cout << ans;
}
