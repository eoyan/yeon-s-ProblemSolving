#include <iostream>

using namespace std;

int main(int argc, const char **argv) {
  int Y;
  cin >> Y;


  if (Y % 4 == 0 && Y % 100 != 0 || Y % 400 == 0) {
    cout << 1;
  }

  else {
    cout << 0;
  }
  
}