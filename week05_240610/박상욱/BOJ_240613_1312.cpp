#include<iostream>
using namespace std;

int main(){
    
    int A,B,N;
    
    cin >>A>>B>>N;
    
    int i=-1;
    while(i<N){
        int ans = A/B;
        int mod = A%B;
        A=mod*10;
        i++;
        if(i==N){
            cout<< ans;
            break;
        }
    }
    
    return 0;
}