#include<iostream>

using namespace std;

int main(){
    
    string str;
    getline(cin,str);
    
    char arr[4] = {'U','C','P','C'};
    int idx = 0;
    for(int i=0;i<str.length();i++){
        if(str[i]==arr[idx]){
            idx++;
        }
        if(idx==4)break;
    }
    
    if(idx==4){
        cout << "I love UCPC";
    }
    else{
        cout << "I hate UCPC";
    }
    
    
    return 0;
}