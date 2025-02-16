import java.util.*;
import java.io.*;
public class boj_14891 {
    public static void main(String[] args) throws IOException{
        
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder[] T = new StringBuilder[4];
        for(int i=0;i<4;i++){
            T[i]=new StringBuilder(bf.readLine());
        }

        int n = Integer.parseInt(bf.readLine());
        int[][] move = new int[n][2];
        for(int i=0;i<n;i++){
            StringTokenizer st = new StringTokenizer(bf.readLine());
            move[i][0]=Integer.parseInt(st.nextToken());
            move[i][1]=Integer.parseInt(st.nextToken());

            // 각 톱니바퀴가 맞닿는 부분이 같은 극인지 다른 극인지 추척한다.
            boolean[] dif = new boolean[3];
            
            if(T[0].charAt(2)!=T[1].charAt(6)){
                dif[0]=true;
            }
            if(T[1].charAt(2)!=T[2].charAt(6)){
                dif[1]=true;
            }
            if(T[2].charAt(2)!=T[3].charAt(6)){
                dif[2]=true;
            }
            moving(move[i][0],move[i][1],dif,T);
        }
        
        System.out.println(
            Integer.parseInt((String.valueOf(T[0].charAt(0))))*1+
            Integer.parseInt((String.valueOf(T[1].charAt(0))))*2+
            Integer.parseInt((String.valueOf(T[2].charAt(0))))*4+
            Integer.parseInt((String.valueOf(T[3].charAt(0))))*8
        );
    }

    public static void moving(int n, int m,boolean[] dif, StringBuilder[] T){
        //톱니바퀴가 돌아가는 경우에 따라 진행
        if(n==1){
            //톱니바퀴 회전
            turn(T[n-1],m);
            //반복하면서 오른쪽 톱니바퀴 회전전
            for(int i=0;i<dif.length;i++){
                if(!dif[i]) {
                    break;
                }
                m*=-1;
                n++;
                turn(T[n-1],m);
            }
        }else if(n==2){
            turn(T[n-1],m);
            if(dif[0]){
                turn(T[n-2],m*(-1));
            }
            for(int i=1;i<dif.length;i++){
                if(!dif[i]) break;
                m*=-1;
                n++;
                turn(T[n-1],m);
            }
        }else if(n==3){
            turn(T[n-1],m);
            if(dif[2]){
                turn(T[n],m*(-1));
            }
            for(int i=1;i>=0;i--){
                if(!dif[i]) break;
                m*=-1;
                n--;
                turn(T[n-1],m);    
            }
        }else if(n==4){
            turn(T[n-1],m);
            for(int i=2;i>=0;i--){
                if(!dif[i]) break;
                m*=-1;
                n--;
                turn(T[n-1],m);
            }
        }
    }
    public static void turn(StringBuilder s,int m){
        //시계방향
        if(m==1){
            char temp=s.charAt(7);
            s.deleteCharAt(7);
            s.insert(0,temp);
        }
        //시계반대방향향
        if(m==-1){
            char temp=s.charAt(0);
            s.deleteCharAt(0);
            s.append(temp);
        }
    }
}
