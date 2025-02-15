import java.util.*;
import java.io.*;
public class boj_1018 {
    public static void main(String[] args) throws IOException{

        //입력 받기
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        
        int n = Integer.parseInt(sk.nextToken());
        int m = Integer.parseInt(sk.nextToken());

        String[] st = new String[n];
        
        // answer을 큰 수로  초기화
        int answer = 9999;

        //String 배열에 한줄 씩 저장장
        for(int i=0;i<st.length;i++){
            st[i]=bf.readLine();
        }

        // 오른쪽 위에부터 8x8 크기의 체스판 탐색색
        for(int i=0; i+7<n;i++){
            for(int j=m-8;j>=0;j--){
                StringBuilder sb = new StringBuilder();
                sb.append(new StringBuilder(st[i].substring(j,j+8)));
                sb.append(new StringBuilder(st[i+1].substring(j,j+8))); 
                sb.append(new StringBuilder(st[i+2].substring(j,j+8))); 
                sb.append(new StringBuilder(st[i+3].substring(j,j+8))); 
                sb.append(new StringBuilder(st[i+4].substring(j,j+8))); 
                sb.append(new StringBuilder(st[i+5].substring(j,j+8))); 
                sb.append(new StringBuilder(st[i+6].substring(j,j+8))); 
                sb.append(new StringBuilder(st[i+7].substring(j,j+8)));
                int count =0;
                char a = 'B';
                char b = 'W';
                char temp=' ';
                for(int k=0;k<64;k++){
                    
                    //한 줄 씩 내려갈 때마다 각 행의 첫번 째 인덱스가 바뀜
                    // 여기서는 왼 쪽 맨 위의 체스 판 색이 W인 경우로 가정정
                    if(k>1 && k%8==0){
                        temp=a;
                        a=b;
                        b=temp;
                    }

                    // 왼 쪽 맨위 체스판의 색이 B이면 W가 아니므로 count 증가가
                    if(k==0&&sb.charAt(k)=='B'){
                        count++;
                        continue;
                    }
                    // 짝 수 인덱스가 b에 담긴 문자가 아니면 count 증가
                    if(k%2==0&&sb.charAt(k)!=b){
                        count++;
                        continue;
                    }
                    //홀 수 인덱스가 a에 담긴 문자가 아니면 count 증가가
                    if(k%2!=0&&sb.charAt(k)!=a){
                        count++;
                        continue;
                    } 
                }

                // 맨 왼쪽 위가 흰색인 경우와 검정색인 경우, 총 두가지 경우 중 count가 작은 것을 선택택
                count=Math.min(count,64-count);
               
                // 주어진 경우 중 가장 작은 answer이 정답답
                answer=Math.min(answer,count);
               
            }
        }
        System.out.println(answer);
    }
}

/* 
WBWBWBWB    
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW
WBWBWBWB
BWBWBWBW

0 1 2 3 4 5 6 7 
8 9 10 11 12 13 14 15
16 17 18 19 20 21 22 23
24 25 26 27 28 29 30 31
32...

0 2 4 6     
9 11 13 15
16 18 20 22 
23
*/