#include<iostream>

using namespace std;

int main(){
    
    string str[3] = {"pi", "ka", "chu"};
    
    string ans;
    cin >> ans;
    
    int N = ans.length();
    for(int i=0;i<N;i++){
        int flag = 0;
        if(i+1<N){
            if(ans[i] == str[0][0] && ans[i+1] == str[0][1]){
                flag = 1;
            }
            else if(ans[i] == str[1][0] && ans[i+1] == str[1][1]){
                flag = 1;
            }
        }
        if(i+2<N){
            if(ans[i] == str[2][0] && ans[i+1] == str[2][1]&& ans[i+2] == str[2][2]){
                flag = 2;
            }
        }
        
        if(flag == 0){ 
            cout << "NO" ;
            return 0;
        }
        
        i += flag;
    }
    
    cout << "YES" << "\n";
    
    
    return 0;
}