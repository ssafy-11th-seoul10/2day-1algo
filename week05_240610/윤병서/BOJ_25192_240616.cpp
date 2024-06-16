#include <bits/stdc++.h>
using namespace std;

int main() {
	int n; cin >> n;
	int ans = 0;
	set<string> name;
	while(n --){
		string s; cin >> s;
		if(s == "ENTER"){
			ans += name.size();
			name.clear();
		}
		else{
			name.insert(s);
		}
	}
	ans += name.size();
	cout << ans;
}
