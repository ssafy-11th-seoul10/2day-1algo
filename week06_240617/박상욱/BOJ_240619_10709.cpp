#include<iostream>
#include<string>
#include<vector>
#include<cmath>
#include<algorithm>
#include<climits>
#include<queue>

using namespace std;

string arr[100] = { };

int main() {

	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	int h, w;
	cin >> h >> w;

	for (int i = 0; i < h; i++) {
		cin >> arr[i];
	}

	
	for (int i = 0; i < h; i++) {
		int num = -1;
		for (int j = 0; j < w; j++) {
			if (arr[i][j] == 'c') {
				num = 0;
			}
			else if(num>=0){
				num++;
			}
			cout << num << " ";
		}
		cout << "\n";
	}
	

	return 0;
}