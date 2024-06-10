#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

bool is_prime(int x) {
    for (int i = 2, ie = sqrt(x); i <= ie; i++) {
        if (x % i == 0) {
            return false;
        }
    }

    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;

    while (cin >> n) {
        if (n < 8) {
            cout << "Impossible.\n";
            continue;
        }

        if (n & 1) {
            cout << "2 3 ";
            n -= 5;
        }
        else {
            cout << "2 2 ";
            n -= 4;
        }

        if (n == 4) {
            cout << "2 2\n";
            continue;
        }

        int i = 3;

        while (!is_prime(i) || !is_prime(n - i)) {
            i += 2;
        }

        cout << i << ' ' << n - i << '\n';
    }

    return 0;
}
