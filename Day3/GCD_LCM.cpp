#include <iostream>
using namespace std;
int gcd(int a, int b) {
    while(b != 0) {
        int temp = b;
        b = a % b;
        a = temp;
    }
    return a;
}
int main() {
    int a, b;
    cout << "Enter two numbers: ";
    cin >> a >> b;
    int g = gcd(a, b);
    int l = (a * b) / g;
    cout << "GCD: " << g << endl;
    cout << "LCM: " << l << endl;
    return 0;
}