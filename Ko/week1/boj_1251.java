import java.io.*;
import java.util.*;
public class boj_1251{
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        List<String> li = new ArrayList<>();

        String inputString = bf.readLine(); 

        // 가능한 모든 경우 탐색색
        for(int i=2;i<inputString.length();i++){
            for(int j=1;j<i;j++){
                
                //각 문자를 뒤집고 리스트에 추가가
                StringBuilder sb1 = new StringBuilder(inputString.substring(0,j));
                StringBuilder sb2 = new StringBuilder(inputString.substring(j,i));
                StringBuilder sb3 = new StringBuilder(inputString.substring(i));
                sb1.reverse();
                sb2.reverse();
                sb3.reverse();
                li.add(sb1.toString()+sb2.toString()+sb3.toString());
            }
        }

        //리스트를 정렬하면 사전 상 가장 앞서는 문자를 얻을 수 있음음
        Collections.sort(li);
        System.out.println(li.get(0));
    }
}
