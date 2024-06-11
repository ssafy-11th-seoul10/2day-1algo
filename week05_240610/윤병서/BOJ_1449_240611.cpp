#include <bits/stdc++.h>
using namespace std;

int main() {
	int n,l; cin >> n >> l;
	int a[1001], ans = 0;
	bool chk[1001] = {};
	for(int i = 0 ; i < n ; i ++){
		cin >> a[i];
	}
	sort(a, a + n);
	for(int i = 0 ; i < n ; i ++){
		if(!chk[a[i]]){
			for(int j = a[i] ; j < a[i] + l ; j ++){
				chk[j] = true;
			}
			ans ++;
		}
	}
	cout << ans;
}
