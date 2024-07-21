#include <iostream>
using namespace std;

int main() {
	int a, b, n; cin >> a >> b >> n ;
	int ans = abs(a - b);
	for(int i = 0 ; i < n ; i ++){
		int k; cin >> k;
		ans = min(ans, abs(b- k) + 1);
	}
	cout << ans;
}
