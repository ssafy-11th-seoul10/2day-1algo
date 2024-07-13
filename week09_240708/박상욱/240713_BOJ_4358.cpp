#include<bits/stdc++.h>

using namespace std;

map<string, int>tree;
vector<pair<string, int>>v;
int cnt;

int main() {
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);
	
	string name;
	while (getline(cin,name)) {
		cnt++;
		if (tree.find(name) != tree.end()) {
			tree[name]++;
		}
		else {
			tree.insert({ name,1 });
		}
	}

	cout << fixed;
	cout.precision(4);
	for (auto it : tree) {
		cout << it.first << " " << (double)(it.second) / cnt * 100 << "\n";
	}
	
	return 0;
}