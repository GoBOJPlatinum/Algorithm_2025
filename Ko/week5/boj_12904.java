import java.io.*;
import java.util.*;
public class boj_12904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder s = new StringBuilder(br.readLine());
        StringBuilder t = new StringBuilder(br.readLine());

        while(s.length()<t.length()){
            if(t.charAt(t.length()-1)=='A'){
                t.deleteCharAt(t.length()-1);
            }
            else if(t.charAt(t.length()-1)=='B'){
                t.deleteCharAt(t.length()-1);
                t.reverse();
            }
            if(s.length()==t.length()) break;
        }

        int answer=1;
        for(int i=0;i<t.length();i++){
            if(t.charAt(i)!=s.charAt(i)){
                answer=0;
            }
        }
        System.out.print(answer);
    }
}