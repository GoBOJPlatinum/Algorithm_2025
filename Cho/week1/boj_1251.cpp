#include <iostream>
#include <string>
#include <algorithm>

using namespace std;

int main()
{
    ios_base::sync_with_stdio(0);
    cin.tie(0);
    
    string word;
    cin >> word;
    
    string result;
    int len = static_cast<int>(word.size());
    for(int i = 1; i <= len - 2; i++)
    {
        for(int j = 1; j <= len - i - 1; j++)
        {
            string a = word.substr(0,i);
            string b = word.substr(i,j);
            string c = word.substr(i+j);
            
            reverse(a.begin(), a.end());
            reverse(b.begin(), b.end());
            reverse(c.begin(), c.end());
            
            string ret = a + b + c;
            if(result == "") result = ret;
            else if(result > ret) result = ret;
        }
    }
    
    cout << result << "\n";
    return 0;
}