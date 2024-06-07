#include <iostream>
using namespace std;

int main() {
	string a, b;
	getline(cin, a);
	getline(cin, b);
	int ans = 0;
	for(int i = 0 ; i <= (int)(a.size() - b.size()) ; i ++){
		if(a.substr(i, b.size()) == b){
			ans ++;
			i += b.size() - 1;
		}
	}
	cout << ans;
	return 0;
}
