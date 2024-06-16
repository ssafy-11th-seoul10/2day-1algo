#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int arr[3];
int min_val = 1000000000;

void recur(int depth, int val) {
    if (depth == 3) {
        if (val >= 0 && val < min_val) {
            min_val = val;
        }

        return;
    }

    recur(depth + 1, val + arr[depth]);
    recur(depth + 1, val - arr[depth]);
    recur(depth + 1, val * arr[depth]);

    if (val % arr[depth] == 0) {
        recur(depth + 1, val / arr[depth]);
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 0; i < 3; i++) {
        cin >> arr[i];
    }

    recur(1, arr[0]);

    cout << min_val << '\n';

    return 0;
}
