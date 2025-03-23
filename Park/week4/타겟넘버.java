import java.io.*;
import java.util.*;

class Solution {
    int answer;
    public int solution(int[] numbers, int target) {
        
        // 숫자 배열, 타겟 넘버, 현재의 인덱스, 현재의 연산 값
        dfs(numbers, target,0,0);
        return answer;
    }
    
    public void dfs(int[] numbers, int target, int curIdx, int curNum){
        if (curIdx >=numbers.length){
            if (curNum == target){
                answer += 1;
            }
            return;
        }
        
        // 덧셈을 하는 경우
        dfs(numbers, target, curIdx+1, curNum + numbers[curIdx]);
        
        // 뺄셈을 하는 경우
        dfs(numbers, target, curIdx+1, curNum - numbers[curIdx]);
    }
}