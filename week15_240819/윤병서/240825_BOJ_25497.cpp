#include <bits/stdc++.h>
using namespace std;

int main() {
    int n; cin >> n;
    string s; cin >> s;
    int ans = 0;
    bool chk = false;
    stack<int> lr, sk;
    for(int i = 0 ; i < n ; i ++){
        if(s[i] == 'L'){
            lr.push(1);
        } else if(s[i] == 'R'){
            if(lr.empty()){
                chk = true;
            } else {
                lr.pop();
                ans ++;
            }
        } else if(s[i] == 'S'){
            sk.push(1);
        } else if(s[i] == 'K'){
            if(sk.empty()){
                chk = true;
            } else {
                sk.pop();
                ans ++;
            }
        } else ans ++;
        if(chk) break;
    }
    cout << ans;
}
