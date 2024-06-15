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

    vector<int>docs;

    int answer = 0;

    for (int i = 0; i < N; i++) {
        int temp;
        cin >> temp;
        docs.push_back(temp);
    }

    sort(docs.begin(), docs.end());

    int k = 0;
    for (int i = 0; i < N; i++) {
        while (k < docs[i]) {
            int up = N - i;
            int down = i;
            if (up >= k && down <= k)answer = k;
            k++;
        }
        if (k == docs[i]) {
            int up = N - i;
            int down = i;
            if (up >= k && down <= k)answer = k;
            k++;
        }
    }

    cout << answer << "\n";

	return 0;
}

