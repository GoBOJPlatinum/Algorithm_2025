#include <iostream>
#include <vector>
// 용사는 N개의 방을 차례로 지나야 하며, 각 방에는 몬스터 혹은 포션이 있음음
// 초기 공격력 h_atk 
// 모든 방을 통과할 때 최소한의 최대 체력

// 몬스터 방(싸움방)
// 용사는 한 번 공격할 때마다 몬스터 hp만큼 --
// 몬스터는 용사 cur_hp만큼 --
// 몬스터 잡기 전에 cur_hp <= 0 이면 패배

//포션 방(회복방)
// 공격력 a ++
// 체력 h 만큼 회복(최대 체력 초과는 불가)
#define MAX 999999000001

using namespace std;

typedef pair<int, pair<int, int>> ppii;
typedef long long ll;

vector<ppii> v;
int n, h_atk, t, a, h;

bool progress(ll target) 
{
	ll max_hp = target;
	ll cur_hp = target;
	ll temp_atk = h_atk;

	for (int i = 0; i < v.size(); i++) 
    {
		ll status = v[i].first;
		ll attack = v[i].second.first;
		ll hp = v[i].second.second;

		if (status == 1) //몬스터 방
        {
			ll cnt = hp / temp_atk; // 현재 공격력으로 몬스터 hp 줄임
			if (hp % temp_atk == 0)
				cnt--; // 남으면 한번 더 맞음
			ll attackAmount = cnt * attack; //남은 공격량 확인
			cur_hp -= attackAmount; // 용사 cur_hp에 반영
			if (cur_hp <= 0) 
				return false; // 죽으면 실패
			
		}
		else //포션 방
        {
			temp_atk += attack; // 체력 증가
			cur_hp += hp; // cur_hp 회복

			if (cur_hp > max_hp) //최대보다 넘으면 최대값을 설정
				cur_hp = max_hp;
		}
	}
	return true;
}

int main() 
{
	cin >> n >> h_atk;
	for (int i = 0; i < n; i++) 
    {
		cin >> t >> a >> h;
		v.push_back({ t,{a, h} });
	}

	ll l = 1;
	ll r = MAX * n;
	ll answer = 0;

	while (l <= r) 
    {
		ll mid = (l + r) / 2; // 최대 최소값의 중간값을 구해해 mid 설정

		if (progress(mid)) // 현재 mid값으로 끝낼 수 있는지 확인인
        {
			answer = mid;
			r = mid - 1; // 끝낼 수 있다면 mid -1해서 최소 체력 탐색
		}
		else 
			l = mid + 1; // 불가능이면 mid +1 체력 증가가
	}
	cout << answer;
}
