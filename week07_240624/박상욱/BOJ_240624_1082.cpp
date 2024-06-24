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
		
	int N,M;

	vector<int>p;

	cin >> N;

	for (int i = 0; i < N; i++) {
		int num;
		cin >> num;
		p.push_back(num);
	}

	cin >> M;

	//방 번호
	//그리디

	//첫 번째 숫자는 1 ~ N 사이 못 사면 0
	//두 번째 숫자붜는 0 ~ N 사이
	//가장 적은 금액의 숫자 구매해서 

	int first = 50;
	int second = 50;

	for (int i = 0; i < N; i++)
	{
		if (i > 0) {
			first = min(first, p[i]);
		}
		second = min(second, p[i]);
	}

	//숫자를 못 만드는 경우
	if (first > M) {
		cout << 0 << "\n";
		return 0;
	}

	//최대 길이
	int len = 0;

	int temp = M;
	temp -= first;
	len++;

	len += temp / second;

	temp %= second;

	//temp만큼의 여유 금액 소모하면서 큰 수 찾기
	for (int l = 0; l < len; l++) {
		int maxNum = -1;
		for (int i = N - 1; i >= 0; i--) {
			//첫번째는 0 제외
			if (l == 0) {
				if (i == 0)continue;
				if (p[i] - first <= temp) {
					maxNum = i;
					temp -= p[i] - first;
					break;
				}
			}
			else {
				if (p[i] - second <= temp) {
					maxNum = i;
					temp -= p[i] - second;
					break;
				}
			}
		}
		cout << maxNum;
	}
	cout << "\n";


	return 0;
}