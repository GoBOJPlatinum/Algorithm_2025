// 그리디 알고리즘 동전 0
//  K원을 만든는 데 필요한 동전의 최소 개수

#include <iostream>
using namespace std;

int a[10];

int main()
{
	int n, k;
	cin >> n >> k;

	for (int i = 0; i < n; i++)
	{
		cin >> a[i];
	}
	int cnt = 0;
	for (int i = n-1; i >= 0; i--)
	{
		if (a[i]<=k) //현재 돈에 낼 수 있는 최대 화폐 찾으면
		{
			cnt += k / a[i]; //그 지폐로 얼마나 낼 수 있는지 체크
			k %= a[i]; //남은돈만 가진다
		}
	}
	cout << cnt;
}
