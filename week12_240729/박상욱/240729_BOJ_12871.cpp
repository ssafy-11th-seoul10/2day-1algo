#include<iostream>

using namespace std;

int GCD(int a,int b){
    int c = a%b;
    while(c != 0){
        a = b;
        b = c;
        c = a%b;
    }
    return b;
}

int main(){
    
    
    string s,t;
    cin >> s >> t;
    
    int l1 = s.length();
    int l2 = t.length();
    
    if(l1<l2){
        int temp = l1;
        l1 = l2;
        l2 = temp;
    }
    
    int lcm = l1 * l2 / GCD(l1,l2);
    
    string s1 = s;
    string s2 = t;
    while(s1.length() < lcm){
        s1 += s;
    }
    while(s2.length() < lcm){
        s2 += t;
    }
    
    if(s1 != s2){
        cout << 0 << "\n";
    }
    else {
        cout << 1 << "\n";
    }
    return 0;
}