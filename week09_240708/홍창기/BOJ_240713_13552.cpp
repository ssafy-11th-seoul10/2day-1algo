// Solve 2024-07-13

#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;
using ll = long long;

int px[100000];
int py[100000];
int pz[100000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> px[i] >> py[i] >> pz[i];
    }

    int q;
    cin >> q;

    while (q-- > 0) {
        int cx, cy, cz, cr;
        cin >> cx >> cy >> cz >> cr;

        ll cr2 = cr * (ll) cr;
        int cnt = 0;

        for (int i = 0; i < n; i++) {
            ll dx = cx - px[i];
            ll dy = cy - py[i];
            ll dz = cz - pz[i];

            if (dx * dx + dy * dy + dz * dz <= cr2) {
                cnt++;
            }
        }

        cout << cnt << '\n';
    }

    return 0;
}
