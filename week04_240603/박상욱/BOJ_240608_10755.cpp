#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int set[100001] = { 0, };

int getParent(int x) {
	if (x == set[x]) {
		return x;
	}
	else {
		return set[x] = getParent(set[x]);
	}
}

int G, P;

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> G >> P;

	for (int i = 1; i <= G; i++) {
		set[i] = i;
	}

	int cnt = 0;
	int flag = 1;
	for (int i = 1; i <= P; i++) {
		int num;
		cin >> num;

		if (flag) {
			num = getParent(num);

			//도킹 가능
			if (num != 0) {
				cnt++;
				set[num] = num - 1;
			}
			else {
				flag = 0;
			}
		}

	}
    
	cout << cnt << "\n";

	return 0;
}