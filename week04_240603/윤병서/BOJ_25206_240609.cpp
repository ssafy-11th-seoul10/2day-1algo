#include <bits/stdc++.h>
using namespace std;

int main() {
    double b = 0;
        double score = 0;
	for(int i = 0 ; i < 20 ; i ++){
        string s; cin >> s;
        double a; cin >> a;
        b += a;
        string c; cin >> c;
        if(c == "A+"){
            score += 4.5 * a;
        }
        if(c == "A0"){
            score += 4.0 * a;
        }
        if(c == "B+"){
            score += 3.5 * a;
        }
        if(c == "B0"){
            score += 3 * a;
        }
        if(c == "C+"){
            score += 2.5 * a;
        }
        if(c == "C0"){
            score += 2.0 * a;
        }
        if(c == "D+"){
            score += 1.5 * a;
        }
        if(c == "D0"){
            score += 1.0 * a;
        }
        if(c == "P"){
            b -= a;
        }
    }
    cout << score / b;
}
