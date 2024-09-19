#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
using namespace std;

int arr[100000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n, m;
    cin >> n >> m;

    int low = 0;
    int high = 1000000001;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
        low = arr[i] > low ? arr[i] : low;
    }

    low--;

    while (low + 1 < high) {
        int mid = (low + high) / 2;
        int cur = mid;
        int cnt = 1;

        for (int i = 0; i < n; i++) {
            cur -= arr[i];

            if (cur < 0) {
                cur = mid - arr[i];
                cnt++;
            }
        }

        if (cnt <= m) {
            high = mid;
        }
        else {
            low = mid;
        }
    }

    cout << high << '\n';

    return 0;
}
