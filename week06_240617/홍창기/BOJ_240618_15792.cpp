#include <iostream>
#include <cmath>
#include <algorithm>
using namespace std;

int main() {
    int a, b;
    cin >> a >> b;

    cout << a / b << '.';

    for (int i = 0; i < 1002; i++) {
        a = a % b * 10;
        cout << a / b;
    }

    cout << '\n';

    return 0;
}
