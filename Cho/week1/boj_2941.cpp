#include <iostream>
#include <string>
#include <vector>

using namespace std;

int main()
{
    vector<string> cro = {"c=", "c-", "dz=", "d-", "lj", "nj", "s=", "z="};
    
    int idx;
    string word;
    cin >> word;

    for(int i=0; i < cro.size(); i++)
    {
        while(1)
        {
            idx = word.find(cro[i]);
            if(idx == string::npos)
                break;

            word.replace(idx, cro[i].length(), "#");
        }
    }
    cout << word.length();
    return 0;
<<<<<<< HEAD
}
=======
}
>>>>>>> 83f11d7eaa30b6af7bfe73d901bbb6024ca6e4c5
