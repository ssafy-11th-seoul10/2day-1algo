#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

long long int arr[85] = { 0, };

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
	long long int N;
	cin >> N;

	arr[0] = 0;
	arr[1] = 1;
	arr[2] = 1;
	arr[3] = 2;

	for (long long int i = 4; i <= N; i++) {
		arr[i] = arr[i - 1] + arr[i - 3] + arr[i - 4];
	}

	//cout << arr[N] << " " << arr[N - 1] << "\n";
	cout << arr[N]*2 + (arr[N] + arr[N-1])*2;

	return 0;
}