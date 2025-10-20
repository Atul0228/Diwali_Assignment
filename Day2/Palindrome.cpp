#include <iostream>
using namespace std;

int main() {
    int n, rev = 0, original, temp;
    cout << "Enter n: ";
    cin >> n;
    original = n;
    temp = n;
    while(temp > 0) {
        rev = rev * 10 + temp % 10;
        temp /= 10;
    }
    if(original == rev)
        cout << "Palindrome" << endl;
    else
        cout << "Not a palindrome" << endl;
    return 0;
}