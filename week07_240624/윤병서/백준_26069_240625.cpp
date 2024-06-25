#include <bits/stdc++.h>
using namespace std;

int main() {
	int n; cin >> n;
	vector<string> v;
	v.push_back("ChongChong");
	while(n--){
		string a, b; cin >> a >> b;
		bool fa = false, fb = false;
		for(int i = 0 ; i < v.size(); i ++){
			if(v[i] == a) fa = true;
			if(v[i] == b) fb = true;
		}
		if(fa == true && fb == false){
			v.push_back(b);
		}
		else if(fa == false && fb == true){
			v.push_back(a);
		}
	}
	cout << v.size();
}
