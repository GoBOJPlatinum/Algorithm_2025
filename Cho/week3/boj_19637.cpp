#include <iostream>
#include <vector>
#include <algorithm>
#include <unordered_map>
// 전사 N명의 전투력에 따라 칭호가 주어짐 (IF문 좀 대신 써줘)
// M명의 캐릭터가 주어졌을 때, 해당 전투력에 해당하는 가장 낮은 전투력 구간의 칭호 출력 문제
using namespace std; 

int main() 
{
	int a, b; 
    cin >> a >> b; 
    // 이미 오름차순으로 입력됨
	vector <pair <int, string>> v(a); //전투력, 칭호 저장할 벡터

	for (int i = 0; i < a; i++) 
        cin >> v[i].second >> v[i].first; 

	for (int i = 0; i < b; i++) 
    {
		int x; 
        cin >> x; // 전투력 받아오는 중간 변수

		int l = 0; 
		int h = v.size() - 1;
		int result = h; 

		while (l <= h) 
        {
			int mid = (l + h) / 2; //가운데 값 mid 선출출
			if (v[mid].first >= x) // 전투력이 같거나 크면 
            {
				h = mid - 1; //최대값을 mid -1하여 좁혀서 탐색
				result = mid; 
			}
			else l = mid + 1; //최소값을 mid +1하여 탐색
		}
		cout << v[result].second << "\n"; 
	}
}