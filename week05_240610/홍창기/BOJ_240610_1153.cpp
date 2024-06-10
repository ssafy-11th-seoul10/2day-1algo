#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int sieve[1000000];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    for (int i = 2; i < 500000; i++) {
        if (sieve[i] == 1) continue;

        for (int j = (i << 1); j < 1000000; j += i) {
            sieve[j] = 1;
        }
    }

    int n;
    cin >> n;

    if (n < 8) {
        cout << "-1\n";
    }
    else {
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
        }
        else {
            int i = 3;

            while (sieve[i] == 1 || sieve[n - i] == 1) {
                i += 2;
            }

            cout << i << ' ' << n - i << '\n';
        }
    }

    return 0;
}
