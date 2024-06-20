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

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {

		int A, B;
		cin >> A >> B;

        long long int ans = (long long int)A * B;

		if (B > A) {
			
            long long int temp = A;
			A = B;
			B = temp;
		}

		while ( B != 0) {
			int C = A % B;

			A = B;
			B = C;
		}
		

		cout << ans / (long long int)A << "\n";
	}

	

	return 0;
}