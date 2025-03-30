package Ko.week6;

import java.util.*;
import java.io.*;
public class boj_14889{
    static boolean[][] visited;
    static int[][] ground;
    static int answer=Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException{
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer sk = new StringTokenizer(bf.readLine());

        int m=Integer.parseInt(sk.nextToken());

        ground = new int[m+1][m+1];
        visited = new boolean[m+1][m+1];

        for(int i=1;i<=m;i++){
            sk = new StringTokenizer(bf.readLine());
            for(int k=1;k<m+1;k++){
                ground[i][k]=Integer.parseInt(sk.nextToken());
            }
        }

        int[] teamA= new int[m/2];

        dfs(m,0,1,teamA);

        System.out.print(answer);
    }

    public static void dfs(int m ,int cnt, int start,int[] teamA){
        if(cnt==m/2){
            team(teamA,m);
            return;
        }

        for(int i=start;i<=m;i++){
            teamA[cnt]=i;
            dfs(m,cnt+1,i+1,teamA);
        }
    }

    public static void team(int[] teamA, int m){
        int [] teamB = new int[m/2];

        int a =0;
        for(int i=1;i<=m;i++){
            boolean has =false;
            for(int j=0;j<teamA.length;j++){
                if(i<teamA[j]){
                    continue;
                }
                if(i==teamA[j]){
                    has =true;
                    break;
                }
            }
            if(!has){
                teamB[a++]=i;
            }
        }
        answer=Math.min(answer,Math.abs(teamScore(teamA)-teamScore(teamB)));
    }

    public static int teamScore(int[] team){
        int score =0;

        for(int i=0;i<team.length;i++){
            for(int j=0;j<team.length;j++){
                if(team[i]==team[j])continue;
                score=score+ground[team[i]][team[j]];
            }
        }
        return score;
    }

}