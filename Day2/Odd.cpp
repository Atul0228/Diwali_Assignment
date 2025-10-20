#include <iostream>
using namespace std;

int main() {
    int n, sum = 0;
    cout << "Enter n: ";
    cin >> n;
    for(int i = 0; i < n; i++) {
        sum += 2 * i + 1;
    }
    cout << "Sum of first " << n << " odd numbers: " << sum << endl;
    return 0;
}