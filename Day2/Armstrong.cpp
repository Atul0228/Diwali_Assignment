#include <iostream>
using namespace std;

int main() {
    int n, temp, digits = 0, sum = 0;
    cout << "Enter n: ";
    cin >> n;
    temp = n;

    while(temp > 0) {
        digits++;
        temp /= 10;
    }

    temp = n;
    while(temp > 0) {
        int num = temp % 10;

        int power = 1;
        for(int i = 0; i < digits; i++) {
            power *= num;
        }

        sum += power;
        temp /= 10;
    }

    if(sum == n)
        cout << "Armstrong number" << endl;
    else
        cout << "Not an Armstrong number" << endl;

    return 0;
}