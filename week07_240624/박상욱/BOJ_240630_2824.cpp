#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>
#include<map>

using namespace std;

int visit[40001] = { 0, };
vector<int> prime;

map<int,int> primeA;
map<int, int> primeB;

void divide(int num, char c) {
	for (int i = 0; i < prime.size(); i++) {
		int cnt = 0;
		//나누어 떨어질 때
		while (num % prime[i] == 0) {
			num /= prime[i];
			cnt++;
		}

		if (cnt != 0) {
			//A
			if (c == 'A') {
				primeA[prime[i]] += cnt;
			}
			else {
				primeB[prime[i]] += cnt;
			}
		}

		
	}

	if (num > 1) {
		if (c == 'A') {
			if (primeA.find(num) == primeA.end()) {
				primeA.insert({ num,1 });
			}
			else {
				primeA[num]++;
			}
		}
		else {
			if (primeB.find(num) == primeB.end()) {
				primeB.insert({ num,1 });
			}
			else {
				primeB[num]++;
			}
		}
	}
}

int main() {

	for (int i = 2; i <= 40000; i++) {
		if (visit[i]==0) {
			prime.push_back(i);
			primeA.insert({ i,0 });
			primeB.insert({ i,0 });
			for (int j = i*2; j <= 40000; j += i) {
				visit[j] = 1;
			}
		}
	}

	int N;

	cin >> N;

	vector<int>A;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		A.push_back(num);
	}

	int M;

	cin >> M;

	vector<int>B;

	for (int i = 0; i < M; i++) {
		int num;
		cin >> num;
		B.push_back(num);
	}

	for (int i = 0; i < N; i++) {
		divide(A[i], 'A');
	}

	for (int i = 0; i < M; i++) {
		divide(B[i], 'B');
	}

	long long int answer = 1;
	int flag = 0;

	for (auto it = primeB.begin(); it != primeB.end(); it++) {
		//A와 B 모두 존재하는 경우
		if (primeA.find(it->first) != primeA.end() && primeA[it->first] > 0 && primeB[it->first] > 0) {

			int cnt = min(it->second, primeA[it->first]);

			while (cnt > 0) {
				answer *= it->first;
				//9자리 넘어가는지 체크
				if (answer >= 1000000000) {
					flag = 1;
				}
				answer %= 1000000000;
				cnt--;
			}
		}
	}

	if (flag) {
		int zero = 9;
		if (answer == 0)zero--;
		int temp = answer;
		while (temp > 0) {
			temp /= 10;
			zero--;
		}

		for (int i = 0; i < zero; i++) {
			cout << 0;
		}
	}
	
	cout << answer << "\n";

	return 0;
}

