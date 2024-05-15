#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);


	int x;
	cin >> x;

	int l = 64;
	int cnt = 1;

	while (l > x) {
		l /= 2;
		if(l<x){
			cnt++;
			x -= l;
		}
		else if(l==x){
			break;
		}
	}

	cout << cnt << "\n";

	

	return 0;
}
