#include <iostream>
using namespace std;
int main() {
    int n;
    cout << "Enter size of array (n): ";
    cin >> n;
    int arr[n];
    cout << "Enter " << n << " numbers from 0 to " << n << " (one missing): ";
    int sum = 0;
    for(int i = 0; i < n; i++) {
        cin >> arr[i];
        sum += arr[i];
    }
    int total = n * (n + 1) / 2;
    cout << "Missing number: " << total - sum << endl;
    return 0;
}