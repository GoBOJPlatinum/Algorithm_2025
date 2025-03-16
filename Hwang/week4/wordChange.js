function solution(begin, target, words) {
    if (!words.includes(target)) return 0; // target이 words에 없으면 변환 불가능

    let queue = [[begin, 0]]; // [현재 단어, 변환 횟수]
    let visited = new Set();  // 방문한 단어 저장

    while (queue.length > 0) {
        let [current, count] = queue.shift(); // 큐에서 현재 단어 가져오기

        if (current === target) return count; // 목표 단어에 도달하면 변환 횟수 반환

        for (let word of words) {
            if (!visited.has(word) && isOneLetterDifferent(current, word)) {
                queue.push([word, count + 1]); // 변환 횟수 증가
                visited.add(word); // 방문 처리
            }
        }
    }
    return 0; // 변환할 수 없는 경우
}

// 두 단어가 한 글자만 다르면 true 반환
function isOneLetterDifferent(word1, word2) {
    let diffCount = 0;
    for (let i = 0; i < word1.length; i++) {
        if (word1[i] !== word2[i]) diffCount++;
        if (diffCount > 1) return false; // 두 글자 이상 다르면 false
    }
    return diffCount === 1;
}
