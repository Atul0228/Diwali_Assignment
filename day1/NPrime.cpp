#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "Enter n: ";
    cin >> n;
    cout << "Prime numbers up to " << n << ":\n";

    for (int num = 2; num <= n; num++) {
        bool isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        if (isPrime)
            cout << num << " ";
    }

    cout << endl;
    return 0;
}