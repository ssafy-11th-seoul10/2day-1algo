#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int t;
    cin >> t;

    while (t-- > 0) {
        int n;
        string p;
        cin >> n >> p;

        if (n == 1) {
            cout << 9 << ' ' << 3 << '\n';
            continue;
        }

        int digit_sum = 0;

        for (char &d : p) {
            digit_sum += d - '0';
        }

        digit_sum %= 3; // p는 소수이므로 3의 배수일 수 없고, 따라서 digit_sum은 0이 될 수 없다.
        int k = 3 - digit_sum; // 따라서 k 역시 1 또는 2이다.

        for (int i = 0; i < n; i++) {
            char d = p[i] <= '7' ? p[i] + k : p[i] - 3 + k;
            swap(p[i], d);
            cout << p << ' ' << 3 << '\n';
            swap(p[i], d);
        }
    }

    return 0;
}
