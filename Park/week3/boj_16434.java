/** 
 * @ 문제 이해
 * 용사는 공주를 구하기 위해 던전으로 향함
 * 용사는 최대 생명력, 현재 생명력(던전 입장시에는 최대 생명력과 같음), 공격력을 가짐
 * 
 * 던전은 N개의 방으로 이루어져 있고 i번째 방을 통해서만 i + 1 번째 방으로 이동할 수 있음.
 * 방에는 포션이 있거나 몬스터가 있는데 몬스터가 있을 경우 쓰러트러야만 지나갈 수 있음
 * N번째 방에는 공주와 용이 있고, 용을 물리쳐야 공주를 구할 수 있음
 * 
 * 몬스터가 있는 방의 올 경우 전투가 진행
 * 1. 용사의 공격력 만틈  몬스터의 생명력을 깎음
 * 2. 몬스터의 생명력이 0 이하이면 전투가 종료되고 용사는 다음 방으로 이동
 * 3. 몬스터의 공격력만큼 용사의 생명력이 깎임
 * 4, 용사의 생명력이 0 이하이면 전투가 종료되고 용사는 사망
 * 5. 다시 1부터 진행
 * 
 * 포션에 있는 방에 가면 현재의 용사 생명력이 회복되고 공격력도 일정 증가
 * 회복된 생명력이 최대생명력보다 큰 경우 용사의 현재 생명력은 최대 생명력이 제한임
 * 용사는 던전으로 향하기 위해 만반의 준비를 하고 잇음, 용사는 수련을 하면 촤대 생명력을 늘릴 수 있는데 얼마나 수현해야 할지 고민
 * 용사가 용을 쓰러트리기 위한 최소의 최대 생명력을 구하라
 * 
 * @아이디어
 * 용사가 공주를 구하기 위한 최대 생명력의 최소값을 구하라!
 * 그렇다면 최대 생명력의 최대값을 몇으로 설정해야할까?
 * 
 * 몬스터 체력의 총합으로 설정하면 되는구나! gpt야 고마워!
 * 
 * 그럼 left = 1, right = 몬스터 체력의 총합! 으로 하자
 * 
 * 이분 탐색 과정을 구상해보자
 * 
 * long answer = 1
 * 
 * while(left <= right){
 * mid = (left + right) / 2
 * // 여기서 mid 값으로 던전에 들어갔을 때 결과를 계산해야한다
 * // dungeon 메서드는 해당 체력으로 던전 입장시 공주를 구할 수 있느냐를 Boolean으로 리턴 
 * Boolean dungeonIn = dungeon(mid,int basicAd, roomCount, roomsinfo)
 * 
 * if(dungeonIn){
 *  right = mid - 1
 *  answer = right
 * } else{
 * left = mid + 1
 * }
 * 
 * return answer
 * 
 * } 
 * 
 * Boolean dungeon(long Hp,int basicAd, int roomCount, int[][] roomsInfo){
 * for(int i = 0, i < roomCount; i++){
 * 
 * // 방에 몬스터가 있다면
 *  if(roomsInfo[i][0]) == 1{
 *      if (roomsInfo[i][2] <= 0){
 *          continue;
 * } else{
 * }
 * 
 *  
 * } 
 * // 몬스터가 없고 회복방이라면
 * else{
 * ~~~
 * 
 * }
 * 
 * }
 * 
 * }
 * 
 * 
 * 
 * */

import java.io.*;
import java.util.*;

public class boj_16434 {
    public static void main(String[] args) throws IOException {

            // 용사가 공주를 구하기 위한 최대 생명력의 최고값을 구하라!


            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            String[] input = br.readLine().split(" ");

            // 방의 개수
            int roomCount = Integer.parseInt(input[0]);

            // 용사의 초기 공격력
            int basicAd = Integer.parseInt(input[1]);


            // 방 정보 배열, 
            // [0]이 1 이라면 공격력이 [1] 이고 생명력이[2] 인 몬스터가 있음
            // [0]이 2 이라면 용사의 공격력을 [1] 만큼 증가시켜 주고 생명력을 [2] 만큼 증가 시켜줌 
            int[][] roomsInfo = new int[roomCount][3];

            for(int i = 0; i <roomCount; i++){
                String[] roomData = br.readLine().split(" ");
                roomsInfo[i][0] = Integer.parseInt(roomData[0]);
                roomsInfo[i][1] = Integer.parseInt(roomData[1]);
                roomsInfo[i][2] = Integer.parseInt(roomData[2]);
            }

            // 정답 출력용 변수 선언
            long answer = 0;
            
            // 이분 탐색용 값 설정
            long left = 1;
            long right = (long)1e18;
            

            while(left <= right){
                // System.out.println("left : " + left + "right : " + right);
                // mid는 용사의 최대 체력 값
                long mid = (left + right) / 2;

                // 용사의 던전 입장 체력, 최대 체력, 입장 공격력, 방의 개수, 방의 정보 배열
                Boolean dungeonIn = dungeon(mid,mid,basicAd, roomCount, roomsInfo);

                //System.out.println(dungeonIn);
                // 해당 최대 체력값으로 공주를 구했다면
                if(dungeonIn){
                    answer = mid;
                    right = mid - 1;                     
                } else{
                    left = mid + 1;
                }
            };

            System.out.println(answer);
            return ;
    }

    public static Boolean dungeon(long hp,long maxHp, long ad, int roomCount, int[][] roomsInfo){
        for(int i = 0; i < roomCount; i++){
            // 몬스터 있는 방일때
            if(roomsInfo[i][0] == 1){
                long monsterHp = roomsInfo[i][2];
                long monsterAd = roomsInfo[i][1];
                
                // 몬스터를 쓰러뜨리는데 필요한 공격 횟수 (올림 연산)
                long attacksNeeded = (monsterHp + ad - 1) / ad;
                
                // 용사가 받는 데미지 (마지막 공격에서는 몬스터가 반격하지 못함)
                hp -= monsterAd * (attacksNeeded - 1);
                
                // 용사의 체력이 0 이하가 되면 실패
                if(hp <= 0){
                    return false;
                }
            }
            // 아이템이 있는 방일 때
            else if(roomsInfo[i][0] == 2){
                // 체력과 공격력 증가
                ad += roomsInfo[i][1];
                hp += roomsInfo[i][2];
                // 최대 체력 제한 적용
                if(hp > maxHp){
                    hp = maxHp;
                }
            }
        }
        return true;

    }
}