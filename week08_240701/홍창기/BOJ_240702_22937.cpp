#include <iostream>
#include <cmath>
#include <algorithm>
#include <iomanip>
using namespace std;
using ll = long long;
using ull = unsigned long long;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    while (n-- > 0) {
        string a, b;
        cin >> a >> b;

        int a_sign = 0;
        ull a_num = 0;

        if (a[0] == '-') {
            a_sign = 1;
            a_num = stoull(a[1] + a.substr(3, 12));
        }
        else {
            a_sign = 0;
            a_num = stoull(a[0] + a.substr(2, 11));
        }

        int b_sign = 0;
        ull b_num = 0;

        if (b[0] == '-') {
            b_sign = 1;
            b_num = stoull(b[1] + b.substr(3, 12));
        }
        else {
            b_sign = 0;
            b_num = stoull(b[0] + b.substr(2, 11));
        }

        ull res_num = a_num * b_num;

        if ((a_sign ^ b_sign) == 1) {
            cout << '-';
        }

        cout << res_num / 1000000000000000000ull << '.';
        cout << setw(18) << setfill('0') << res_num % 1000000000000000000ull << '\n';
    }

    return 0;
}
