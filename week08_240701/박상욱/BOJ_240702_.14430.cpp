/******************************************************************************

                              Online C++ Compiler.
               Code, Compile, Run and Debug C++ program online.
Write your code in this editor and press "Run" button to compile and execute it.

*******************************************************************************/

#include <iostream>
#include <algorithm>

using namespace std;

int N,M;
int area[301][301] = {0,};

int DP[301][301] = {0,};

void search(){
    
    DP[0][0] = area[0][0];
    
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            DP[i][j] = max((i-1>=0?DP[i-1][j]:0),(j-1>=0?DP[i][j-1]:0)) + area[i][j];
        }
    }
    
    cout << DP[N-1][M-1] << "\n";
}

int main()
{
    cin >> N >> M;
    
    for(int i=0;i<N;i++){
        for(int j=0;j<M;j++){
            cin >> area[i][j];
        }
    }
    
    search();

    return 0;
}