#include <bits/stdc++.h>
using namespace std;

int main() {
    string s; cin >> s;
    set<string> st;
    for(int i = 0 ; i < s.size(); i ++){
        for(int j = 0 ; j < s.size() ; j ++){
            st.insert(s.substr(i, j - i));
        }
    }
    cout << st.size();
}
