#include<bits/stdc++.h>

using namespace std;

int arr[1300000] = { 0, };

int main() {

	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	for (int i = 2; i <1300000; i++) {
		if (arr[i] == 0) {
			for (int j = i * 2; j < 1300000; j += i) {
				arr[j] = 1;
			}
		}
	}

	int K;
	cin >> K;

	for(int k=0;k<K;k++) 
	{
		int num;
		cin >> num;
		if (arr[num] == 0) {
			cout << 0 << "\n";
		}
		else {
			int cnt = 2;
			int s = num-1;
			int e = num+1;
			while (arr[s]==1) {
				cnt++;
				s--;
			}
			while (arr[e]==1) {
				cnt++;
				e++;
			}
			cout << cnt << "\n";
		}
	}

	return 0;
}