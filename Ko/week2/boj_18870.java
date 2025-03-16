package Algorithm_2025.Ko.week2;

import java.util.*;
import java.io.*;
public class boj_18870 {
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(bf.readLine());
        int[] arr = new int[n];
        int[] temp = new int[n];
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        for(int i=0;i<n;i++){
            temp[i]=arr[i]=Integer.parseInt(sk.nextToken());
        }

        Arrays.sort(temp);

        Map<Integer,Integer> m = new HashMap<>();

        int a=0;
        for(int i=0;i<n;i++){
            if(!m.containsKey(temp[i])){
                m.put(temp[i],a++);
            }
        }

        StringBuilder sb = new StringBuilder();
		for(int key : arr) {
			int ranking = m.get(key);	// 원본 배열 원소(key)에 대한 value(순위)를 갖고온다.
			sb.append(ranking).append(' ');
		}
		
		System.out.println(sb);
    }
}
