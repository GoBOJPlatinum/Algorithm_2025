#include <iostream>
#include <cstring>

using namespace std;

string gear[4];
int Rotate[4];

void init()
{
    for(int i=0; i < 4; i++)
        Rotate[i] = 0;
}

void left_check(int idx, int clock)
{
    if(idx <= 0) return;

    if(gear[idx][6] != gear[idx-1][2])
    {
        Rotate[idx-1] = clock * -1;
        left_check(idx-1, clock * -1);
    }
}

void right_check(int idx, int clock)
{
    if(idx >= 3) return;

    if(gear[idx][2] != gear[idx+1][6])
    {
        Rotate[idx+1] = clock * -1;
        right_check(idx+1, clock * -1);
    }
}

void move(int idx, int clock)
{
    if(clock == 1)
        gear[idx] = gear[idx].substr(7) + gear[idx].substr(0, 7);
    else if(clock == -1)
        gear[idx] = gear[idx].substr(1, 7) + gear[idx].substr(0, 1);
}


void check(int idx, int clock)
{
    Rotate[idx] = clock;
    left_check(idx, clock);
    right_check(idx, clock);

    for(int i=0; i < 4; i++)
        move(i, Rotate[i]);
}

int main()
{
    int result = 0;
    int k, g, r;
    for(int i=0; i < 4; i++)
        cin >> gear[i];
    
    cin >> k;

    for(int i=0; i < k; i++)
    {
        cin >> g >> r;
        init();
        check(g-1, r);
    }

    int mul = 1;
    for(int i=0; i < 4; i++)
    {
        result += (gear[i][0] - '0') * mul;
        mul *= 2;
    }

    cout << result;
    return 0;
}

<<<<<<< HEAD

=======
>>>>>>> 83f11d7eaa30b6af7bfe73d901bbb6024ca6e4c5
