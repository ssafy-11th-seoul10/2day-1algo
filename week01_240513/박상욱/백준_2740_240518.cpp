#include<iostream>

using namespace std;

int main(){
    
    int A[100][100];
    int B[100][100];
    int C[100][100];
    
    int N,M,K;
    cin >> N >> M;
    
    
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin >> A[i][j];
        }
    }
    
    cin >> M >> K;
    
    for(int i=0;i<M;i++){
        for(int j=0;j<K;j++){
            cin >> B[i][j];
        }
    }
    
    for(int i=0;i<N;i++){
        for(int j=0;j<K;j++){
            C[i][j] = 0;
            for(int k=0;k<M;k++){
                C[i][j] += A[i][k] * B[k][j];
            }
            cout << C[i][j] << " ";
        }
        cout << "\n";
    }
    
    
    
    return 0;
}