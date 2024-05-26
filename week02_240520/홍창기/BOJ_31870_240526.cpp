#include <bits/stdc++.h>
using namespace std;

#define FASTIO ios_base::sync_with_stdio(false);cin.tie(NULL); // boj_15552.cpp
#define SETPRECISION(n) cout << fixed;cout.precision(n); // boj_1008.cpp
#define SIZE(v) (int)v.size()
#define ALL(v) v.begin(),v.end()
using ll = long long;

int arr[1000];

int main() {
    FASTIO;

    int n;
    cin >> n;

    for (int i = 0; i < n; i++) {
        cin >> arr[i];
    }

    int asc = 0;
    int desc = 1;

    for (int i = 0; i < n; i++) {
        int cur = 0;

        for (int j = i + 1; j < n; j++) {
            if (arr[i] > arr[j]) cur++;
        }

        asc += cur;
        desc += n - 1 - i - cur;
    }

    cout << min(asc, desc) << '\n';

    return 0;
}
