import java.io.*;

public class Main {
    static char[] board;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        
        String line;
        while (!(line = br.readLine()).equals("end")) {
            board = line.toCharArray();
            
            // 개수 체크
            int cnt_x = checkCnt('X');
            int cnt_o = checkCnt('O');
            
            if (cnt_x != cnt_o && cnt_x != cnt_o + 1) {
                bw.write("invalid\n");
                continue;
            }
            
            // 승자 체크
            int winner = checkWinner();
            if (winner == -1) {
                bw.write("invalid\n");
                continue;
            }
            
            // 승리 후 개수 체크
            if (winner == 1 && cnt_x != cnt_o + 1) {
                bw.write("invalid\n");
                continue;
            }
            
            if (winner == 2 && cnt_x != cnt_o) {
                bw.write("invalid\n");
                continue;
            }

            // 마지막 상태 확인
            if (!isFinalState()) {
                bw.write("invalid\n");
                continue;
            }
            
            bw.write("valid\n");
        }
        
        bw.close();
    }
    
    static int checkCnt(char c) {
        int cnt = 0;
        for(char now: board) {
            if (c == now) cnt++;
        }
        return cnt;
    }
    
    static int checkWinner() {
        boolean xWin = false;
        boolean oWin = false;
        
        for (int i = 0; i < 3; i++) {
            if (board[i*3] == board[i*3+1] && board[i*3+1] == board[i*3+2]) {
                if (board[i*3] == 'X') xWin = true;
                else if (board[i*3] == 'O') oWin = true;
            }
        }
        
        for (int i = 0; i < 3; i++) {
            if (board[i] == board[i+3] && board[i+3] == board[i+6]) {
                if (board[i] == 'X') xWin = true;
                else if (board[i] == 'O') oWin = true;
            }
        }
        
        if (board[0] == board[4] && board[4] == board[8]) {
            if (board[0] == 'X') xWin = true;
            else if (board[0] == 'O') oWin = true;
        }
        
        if (board[2] == board[4] && board[4] == board[6]) {
            if (board[2] == 'X') xWin = true;
            else if (board[2] == 'O') oWin = true;
        }
        
        if (xWin && oWin) return -1;  // 둘 다 승리 (불가능)
        if (xWin) return 1;           // X 승리
        if (oWin) return 2;           // O 승리
        return 0;                     // 무승부 또는 진행중
    }

    static boolean isFinalState() {
        int winner = checkWinner();
        if (winner == 1 || winner == 2) return true;
        
        for (char c : board) {
            if (c == '.') return false;
        }
        return true;
    }
}