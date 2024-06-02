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

	long long int N;

	cin >> N;
	
	long long int cnt = 0;
	while (cnt * cnt <= N) {
		cnt++;
	}
	cnt--;

	cout << cnt << "\n";

	return 0;
}