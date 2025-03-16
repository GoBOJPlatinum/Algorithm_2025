package Algorithm_2025.Ko.week2;
import java.util.*;
import java.io.*;
public class boj_11399 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        StringTokenizer s = new StringTokenizer(bf.readLine());
        int[] number = new int[n];

        for(int i=0;i<n;i++){
            number[i]=Integer.parseInt(s.nextToken());
        }

        Arrays.sort(number);

        int answer = 0;
        for(int i=0;i<n;i++){
            int total=0;
            for(int j=0;j<=i;j++){
                total=total+number[j];
            }
            answer = answer+total;
        }
        System.out.println(answer);
    }
}
