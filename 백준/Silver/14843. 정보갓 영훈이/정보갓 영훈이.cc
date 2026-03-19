#include <iostream>
#include <iomanip>

using namespace std;

int main(int argc, const char **argv) {
  int N;   
  cin >> N;

  double score;

  // 영훈이 점수 구하기 
  for (int i = 0; i < N; i++) {
    double S;
    int A, T, M;
    cin >> S >> A >> T >> M;

    score +=  S * (1 + 1.0 / A) * (1 + 1.0 * M / T) / 4;
  }

  int P;
  cin >> P;

  int rank = 1;

  // 등수 측정
  for (int i = 0; i < P; i++) {
     double p;
     cin >> p;

     if (p > score) {
      rank++;
     }
  }

  if (rank <= (P + 1) * 0.15) {
    cout << "The total score of Younghoon \"The God\" is " << fixed << setprecision(2) << score << ".\n";
  }

  else {
    cout << "The total score of Younghoon is " << fixed << setprecision(2) << score << ".\n";
  }

  return 0;
}