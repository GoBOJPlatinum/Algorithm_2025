package Algorithm_2025.Ko.week4
class 타겟넘버 {
    public int solution(int[] numbers, int target) {
        int answer = dfs(numbers,target,0,0);
        return answer;
    }
    
    public int dfs(int[] numbers, int target, int index , int result){
        
        if(index==numbers.length){
            if(result == target){
                return 1;
            }return 0;
        }
        return dfs(numbers,target,index+1,result+numbers[index])+ dfs(numbers,target,index+1,result-numbers[index]);
    }
}