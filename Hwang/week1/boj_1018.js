const readline = require('readline');
const rl = readline.createInterface({
    input: process.stdin,
    output: process.stdout
});

let input = [];
rl.on('line', (line) => {
    input.push(line.trim());
}).on('close', () => {
    
    const [N, M] = input[0].split(' ').map(Number);
    const board = input.slice(1);
    
    if (board.length !== N) {
        process.exit(1);
    }
    console.log(chess(board, N, M));
});


function chess(board, N, M) {
    let minRepaints = Infinity;
    

    const chess1 = Array.from({ length: 8 }, (_, i) =>
        Array.from({ length: 8 }, (_, j) => (i + j) % 2 === 0 ? 'W' : 'B')
    );
    
    const chess2 = Array.from({ length: 8 }, (_, i) =>
        Array.from({ length: 8 }, (_, j) => (i + j) % 2 === 0 ? 'B' : 'W')
    );
    

    for (let i = 0; i <= N - 8; i++) {
        for (let j = 0; j <= M - 8; j++) {
            let repaint1 = 0, repaint2 = 0;
            

            for (let x = 0; x < 8; x++) {
                for (let y = 0; y < 8; y++) {
                    if (board[i + x][j + y] !== chess1[x][y]) repaint1++;
                    if (board[i + x][j + y] !== chess2[x][y]) repaint2++;
                }
            }
            
            // 최솟값 갱신
            minRepaints = Math.min(minRepaints, repaint1, repaint2);
        }
    }
    
    return minRepaints;
}
