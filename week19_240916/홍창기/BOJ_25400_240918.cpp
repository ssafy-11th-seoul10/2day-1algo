#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    int cur = 1;

    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;

        if (x == cur) {
            cur++;
        }
    }

    cur--;
    cout << n - cur << '\n';

    return 0;
}
