#include <iostream>

using namespace std;

// 현재까지의 총 게임 횟수 x와 이긴 게임 수 y를 사용해 승률을 계산하는 함수
int calc_rate(long long x, long long y) 
{
  return (100 * y) / x;
}

int main() 
{

  long long x, y, z;
  int count = -1;

  cin >> x >> y;  // x 게임 횟수 , y 이긴 횟수

  z = calc_rate(x, y);  //현재 승률 계산
  // 만약 현재 승률이 99% 이상이라면, 승률 증가가 불가능
  if (z >= 99) 
  {
    cout << count << endl;
    return 0;
  }
  // 이분 탐색을 위한 변수 설정
  int left = 0;
  int right = 1000000000; // 10억번까지 시도 가능
  int mid = 0;

  while (left <= right) 
  {
    mid = (left + right) / 2;   //중간값 설정
    
    long long newz = calc_rate(x+mid, y+mid);  // mid 판에서 더 이겼을 때의 승률 계산
    
    if (z < newz) // 승률 up -> 하나 줄임
        right = mid - 1;  // 더 적은 게임 수로 승률을 올릴 수 있는 경우
    else // 승률 down -> 범위 늘림
        left = mid + 1;  // 아직 승률이 변하지 않으므로 더 많은 게임 진행 필요
  }

  cout << left << endl;

  return 0;
}