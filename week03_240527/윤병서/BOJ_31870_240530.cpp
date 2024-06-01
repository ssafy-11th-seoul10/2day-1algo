#include <bits/stdc++.h>
using namespace std;

int main() {
	int n; cin >> n;
	int a[1001], b[1001];
	for(int i = 0 ; i < n ;i  ++){
		cin >> a[i];
		b[i] = a[i];
	}
	
	int ans1 = 0, ans2 = 1;
	for(int i = 0 ; i < n ; i ++){
		for(int j = 0; j < n - 1; j ++){
			if(a[j] > a[j + 1]){
				int tmp = a[j];
				a[j] = a[j + 1];
				a[j + 1] = tmp;
				ans1 ++;
			}
			if(b[j] < b[j + 1]){
				int tmp = b[j];
				b[j] = b[j + 1];
				b[j + 1] = tmp;
				ans2 ++;
			}
		}
	}
	cout << min(ans1, ans2);
}
