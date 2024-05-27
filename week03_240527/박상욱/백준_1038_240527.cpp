#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

int arr[10] = { 0, };
int N;
vector<long long int>answer;

void BruteForce(long long int num, int j,int M, int idx) {
	for (int i = j; i >=0; i--) {
		if (arr[i] == 0) {
			arr[i] = 1;
			//최종 조합인 경우
			if (idx == M) {
				answer.push_back(num * 10 + i);
			}
			else {
				BruteForce(num * 10 + i,i-1, M, idx + 1);
			}

			arr[i] = 0;
		}
	}
}

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> N;

	//조합에 들어가는 수 
	for (int i = 0; i <= 9; i++)
	{
		BruteForce(0, 9,i, 0);
	}
	
	sort(answer.begin(), answer.end());

	/*
	for (int i = 0; i < answer.size(); i++) {
		cout << answer[i] << "\n";
	}
	*/
	
	if (N >= answer.size()) {
		cout << -1 << "\n";
	}
	else {
		cout << answer[N] << "\n";
	}


	return 0;
}
