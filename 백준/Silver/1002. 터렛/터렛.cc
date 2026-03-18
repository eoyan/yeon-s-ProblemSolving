#include <iostream>
#include <cmath>

using namespace std;

int main(int argc, const char **argv) {
  
  int N;
  cin >> N;

  for(int i = 0; i < N; i++) {
    double x1, y1, r1, x2, y2, r2;
    int answer;

    cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;

    double dx = abs(x1 - x2);
    double dy = abs(y1 - y2);

    // 두 좌표 사이의 거리 
    double d = sqrt((dx * dx) + (dy * dy));

    //1.  무수히 많은 점에서 만남
    if (x1 == x2 && y1 == y2 && r1 == r2) {
      answer = -1;
    }
    
    //2.  두 원이 한 점에서 만난다. (외접 + 내접)
    else if (d == r1 + r2 || d == abs(r1 - r2))   {
      answer = 1;
    }

    // 3.  두 원이 두점에서 만난다.
    else if (d < r1 + r2 && d > abs(r1 - r2)) {
      answer = 2;
    }

    // 4. 만나지 않는 경우 
    else {
      answer = 0;
    }
    
    cout << answer << '\n';
  }
  

  return 0;
}