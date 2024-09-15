#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int arr[200000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, c;
    cin >> n >> c;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    sort(arr, arr + n);

    int dist_low = 0;
    int dist_high = 1000000001;

    while (dist_low + 1 < dist_high) {
        int dist_mid = (dist_low + dist_high) / 2;
        int cnt = 0;
        int nxt_pos = arr[0];

        for (int i = 0; i < n; i++) {
            if (arr[i] >= nxt_pos) {
                nxt_pos = arr[i] + dist_mid;
                cnt++;
            }
        }

        if (cnt >= c) {
            dist_low = dist_mid;
        }
        else {
            dist_high = dist_mid;
        }
    }

    cout << dist_low << '\n';

    return 0;
}
