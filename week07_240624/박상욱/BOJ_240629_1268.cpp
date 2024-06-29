#include<iostream>

using namespace std;

int student[1000][5] = {0,};

int main(){
    
    
    
    int N;
    cin  >> N;
    
    for(int i=0;i<N;i++){
        for(int j=0;j<5;j++){
            int num;
            cin >> num;
            student[i][j] = num;
        }
    }
    
    int cnt = 0;
    int number = 1;
    
    for(int i=0;i<N;i++){
        int temp = 0;
        for(int j=0;j<N;j++){
            if(i==j)continue;
            int flag = false;
            for(int k=0;k<5;k++){
                if(student[i][k] == student[j][k]){
                    flag = true;
                    break;
                }
            }
            if(flag){
                temp++;
            }
        }
        if(temp>cnt){
            cnt = temp;
            number = i+1;
        }
    }
    
    cout << number;
    
    return 0;
}