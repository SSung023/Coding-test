#include <iostream>
#include <cstring>

using namespace std;

int main() {

    int num = 0;
    int count = 0;
    int temp = 0;

    cin >> num;

    temp = num;

    while(true){

        // 만약 값이 10보다 작다면 그 수에 10을 곱하고, 원래 값을 더한다
        if(temp < 10){
            temp = temp + temp * 10;
        }

        //만약 값이 10보다 크다면 각 자리 수를 더한 것이 1의 자리
        //원래 값의 일의 자리가 십의 자리로 된다.
        else{
            temp = ((temp % 10) * 10) + ((temp / 10 + temp % 10) % 10);

        }

        count++;

        if(temp == num)
            break;

    }

    cout << count;


    return 0;
}
