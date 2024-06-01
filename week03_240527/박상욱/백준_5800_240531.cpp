#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

long long int DP[31][31] = { 0, };

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	
    int N;
    cin >> N;

    for (int i = 0; i < N; i++) {
        int num;
        cin >> num;
        vector<int>score;
        for (int j = 0; j < num; j++) {
            int temp;
            cin >> temp;
            score.push_back(temp);
        }

        sort(score.begin(), score.end());

        int M = score[num - 1];
        int m = score[0];
        int dist = 0;

        for (int j = 1; j < num; j++) {
            dist = max(abs(score[j - 1] - score[j]), dist);
        }

        cout << "Class " << i + 1 << "\n";
        cout << "Max " << M << ", " << "Min " << m << ", " << "Largest gap " << dist << "\n";
    }

	return 0;
}