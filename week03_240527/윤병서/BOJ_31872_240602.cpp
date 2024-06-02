#include <bits/stdc++.h>
using namespace std;
int main(){
	int n, k; cin >> n >> k;
	vector<int> v;
	for(int i = 0 ; i < n ; i ++){
		int  a; cin >> a;
		v.push_back(a);
	}
	sort(v.begin(), v.end());
	
	vector<int> v2;
	v2.push_back(v[0]);
	for(int i = 1 ; i < n ; i ++){
		v2.push_back(v[i] - v[i - 1]);
	}
	sort(v2.begin(), v2.end());
	
	int ans = 0;
	for(int i = 0 ; i < n - k ; i ++){
		ans += v2[i];
	}
	cout << ans;
}
