#include <iostream>
using namespace std;

int main() {
    int n;
    cout << "How many strings? ";
    cin >> n;

    string s, longest = "";
    cout << "Enter " << n << " strings:" << endl;

    for (int i = 0; i < n; i++) {
        cin >> s;
        if (s.length() > longest.length())
            longest = s;
    }

    cout << "Length of the longest string: " << longest.length() << endl;
    return 0;
}