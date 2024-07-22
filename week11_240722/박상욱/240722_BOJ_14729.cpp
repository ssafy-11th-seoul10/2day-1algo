#include <bits/stdc++.h>

using namespace std;

priority_queue<double,vector<double>,greater<double>>q;

int main() {
	
	cin.tie(NULL);
	cout.tie(NULL);
	ios_base::sync_with_stdio(false);

	int N;
	cin >> N;

	for (int i = 0; i < N; i++) {
		double temp;
		cin >> temp;
		q.push(temp);
	}

	cout << fixed;
	cout.precision(3);
	for (int i = 0; i < 7; i++) {
		cout << q.top() << "\n";
		q.pop();
	}



	return 0;
}

