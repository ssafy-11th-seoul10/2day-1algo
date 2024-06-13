#include <bits/stdc++.h>
using namespace std;

int main() {
	int t; cin >> t;
	while(t--){
		int n, m; cin >> n >> m;
		vector<int> a, b;
		for(int i = 0 ; i < n ; i ++){
			int k; cin >> k;
			a.push_back(k);
		}
		for(int i = 0 ; i < m ; i ++){
			int k; cin >> k;
			b.push_back(k);
		}
		sort(a.begin() , a.end());
		sort(b.begin(), b.end());
		long long ans = 0;
		for(int i = 0 ; i < a.size(); i ++){
			ans += (int)(lower_bound(b.begin(), b.end(), a[i]) - b.begin());
		}
		cout << ans << endl;
	}
}
