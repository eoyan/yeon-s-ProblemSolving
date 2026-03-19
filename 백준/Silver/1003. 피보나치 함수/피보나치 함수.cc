#include <iostream>

using namespace std;

int printZero, printOne;

int main(int argc, const char ** argv) {
  int T;
  cin >> T;

  int dp[41][2];
    dp[0][0] = 1;
    dp[0][1] = 0;
    dp[1][0] = 0;
    dp[1][1] = 1;

  for (int j = 2; j <= 40; j++) {
    dp[j][0] = dp[j-2][0] + dp[j-1][0];
    dp[j][1] = dp[j-2][1] + dp[j-1][1];
  }
  
  for(int i = 0; i < T; i++) {
    int n;
    cin >> n;
    cout << dp[n][0] << ' ' << dp[n][1] << '\n';
  }
}