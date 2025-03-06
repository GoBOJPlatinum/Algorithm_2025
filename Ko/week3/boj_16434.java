package Algorithm_2025.Ko.week3;
import java.util.*;
import java.io.*;

public class boj_16434 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());
        int roomNum=Integer.parseInt(sk.nextToken());
        long ack=Integer.parseInt(sk.nextToken());

        long[][] roomInfo = new long[roomNum][3];

        for(int i=0;i<roomNum;i++){
            sk = new StringTokenizer(bf.readLine());
            roomInfo[i][0]=Integer.parseInt(sk.nextToken());
            roomInfo[i][1]=Integer.parseInt(sk.nextToken());
            roomInfo[i][2]=Integer.parseInt(sk.nextToken());
        }

        long left = 0;
        long right = Long.MAX_VALUE;
        long mid = 0;
        long answer =0;
        while(left<=right){
            mid=(left+right)/2;

            if(play(roomInfo,ack,mid)){
                answer =mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        } 
        System.out.println(answer);   
    }


    public static boolean play(long[][] room, long ack, long mHp){
        
        long cHp = mHp;
        for(int i=0;i<room.length;i++){
            if(room[i][0]==1){
                long fightRet =fight(room[i][1],room[i][2],ack,cHp);
                if(cHp<=fightRet){
                    return false;
                }else{
                    cHp=cHp-fightRet;
                }
            }else{
                ack = ack+room[i][1];
                cHp = potion(room[i][2],mHp,cHp);
            }
        }
        return true;
    }

    public static long fight(long dAck,long dHp, long ack , long cHp){
        
        long ansAtk = (long) Math.ceil((double) dHp / ack);

        return dAck*(ansAtk-1);
    }

    public static long potion(long plusHp,long mHp,long cHp){
        return ((cHp+plusHp)>mHp) ? mHp : cHp+plusHp; 
    }

}
