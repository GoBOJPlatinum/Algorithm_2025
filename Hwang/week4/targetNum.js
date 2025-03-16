/*numbers는 순서대로, index 때 마다 + 경우, - 경우를 생각해서 계산*/
function solution(numbers, target) {
    function dfs(index, sum) {
        if (index === numbers.length) {
            return sum === target ? 1 : 0;
        }
        return dfs(index + 1, sum + numbers[index]) + dfs(index + 1, sum - numbers[index]);
    }

    return dfs(0, 0);
}

let numbers = [4, 1, 2, 1];
let target = 4;

