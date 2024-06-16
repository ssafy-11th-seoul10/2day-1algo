#include <bits/stdc++.h>
using namespace std;

int main() {
	ios::sync_with_stdio(0); cin.tie(0);
	int n; cin >> n;
	deque<int> q;
	while(n--){
		int a; cin >> a;
		if(a == 1){
			int x; cin >> x;
			q.push_front(x);
		}
		if(a == 2){
			int x; cin >> x;
			q.push_back(x);
		}
		if(a == 3){
			if(q.size() == 0){
				cout << -1;
			} else{
				cout << q.front();
				q.pop_front();
			}
		}
		if(a == 4){
			if(q.size() == 0){
				cout << -1;
			} else{
				cout << q.back();
				q.pop_back();
			}
		}
		if(a == 5){
			cout << q.size();
		}
		if(a == 6){
			if(q.size() == 0) cout << 1;
			else cout << 0;
		}
		if(a == 7){
			if(q.size() == 0) cout << -1;
			else cout << q.front();
		}
		if(a == 8){
			if(q.size() == 0) cout << -1;
			else cout << q.back();
		}
		if(a != 1 && a != 2){
			cout << '\n';
		}
	}
}
