#include<iostream>

using namespace std;

int main(){
    
    string s1,s2;
    while(cin >> s1 >> s2){
        int j = 0;
        int flag = 0;
        
        for(int i=0;i<s2.length();i++){
            if(s1[j]==s2[i]){
                j++;
                if(j==s1.length()){
                    flag = 1;
                    break;
                }
            }
        }
        
        if(flag)cout << "Yes\n";
        else cout << "No\n";
    }
    
    return 0;
}