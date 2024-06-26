#include <iostream>
#include <cmath>
#include <algorithm>
#include <string>
#include <vector>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    string signs = "/-\\(@?>&%";
    string s;

    while (true) {
        cin >> s;

        if (s[0] == '#') {
            break;
        }

        int x = 0;

        for (char c : s) {
            x *= 8;

            for (int j = 0; j <= 8; j++) {
                if (c == signs[j]) {
                    x += j - 1;
                    break;
                }
            }
        }

        cout << x << '\n';
    }

    return 0;
}
