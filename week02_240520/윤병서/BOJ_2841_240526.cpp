#include <bits/stdc++.h>
using namespace std;

int main() {
	int n,p; cin >> n >> p;
	int ans = 0;
	vector<stack<int>> v(7);
	for(int i = 0 ; i < n ; i ++){
		int a, b; cin >> a >> b;
		while(!v[a].empty() && v[a].top() > b){
			v[a].pop();
			ans ++;
		}
		
		if(!v[a].empty() && v[a].top() == b){
			continue;
		}
		
		v[a].push(b);
		ans ++;
	}
	cout << ans;
}
