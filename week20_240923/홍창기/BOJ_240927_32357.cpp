#include <bits/stdc++.h>
using namespace std;
using ll = long long;
using pii = pair<int, int>;

bool is_palindrome(string s) {
    int i = 0;
    int j = s.size() - 1;

    while (i < j) {
        if (s[i] != s[j]) {
            return false;
        }

        i++; j--;
    }

    return true;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    cin >> n;

    int cnt = 0;

    while (n-- > 0) {
        string s;
        cin >> s;

        if (is_palindrome(s)) {
            cnt++;
        }
    }

    cout << cnt * (cnt - 1) << '\n';

    return 0;
}
