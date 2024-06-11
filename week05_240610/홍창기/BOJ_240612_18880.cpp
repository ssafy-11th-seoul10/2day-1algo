#include <iostream>
#include <cmath>
#include <algorithm>
#include <vector>
#include <queue>
using namespace std;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    int n;
    string s;
    cin >> n >> s;

    int left = 0;

    while (left < n && s[left] == '0') {
        left++;
    }

    if (left == n) {
        cout << n - 1 << '\n';

        return 0;
    }

    int right = n - 1;

    while (s[right] == '0') {
        right--;
    }

    int min_interval = 1000000;
    priority_queue<int, vector<int>, greater<int>> max_interval;
    int cur_interval = 0;

    for (int i = left + 1; i <= right; i++) {
        cur_interval++;

        if (s[i] == '1') {
            if (cur_interval < min_interval) {
                min_interval = cur_interval;
            }

            max_interval.push(cur_interval);

            if (max_interval.size() > 2) {
                max_interval.pop();
            }

            cur_interval = 0;
        }
    }

    int a = 0;
    int b = 0;

    if (max_interval.size() == 2) {
        b = max_interval.top();
        max_interval.pop();
        a = max_interval.top();
        max_interval.pop();
    }
    else if (max_interval.size() == 1) {
        a = max_interval.top();
        max_interval.pop();
    }

    int c = left;
    int d = n - 1 - right;

    if (c < d) swap(c, d);

    int ans1 = min(min_interval, a / 3);
    int ans2 = min({ min_interval, a / 2, b / 2 });
    int ans3 = min(min_interval, c / 2);
    int ans4 = min({ min_interval, c, d });
    int ans5 = min({ min_interval, a / 2, c });

    int ans = max({ ans1, ans2, ans3, ans4, ans5 });
    cout << ans << '\n';

    return 0;
}
