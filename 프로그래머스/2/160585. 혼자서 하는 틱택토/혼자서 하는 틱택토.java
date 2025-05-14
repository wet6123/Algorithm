class Solution {
    public int solution(String[] board) {
        int countO = 0;
        int countX = 0;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i].charAt(j) == 'O') countO++;
                if (board[i].charAt(j) == 'X') countX++;
            }
        }
        
        if (countO < countX || countO > countX + 1) {
            return 0;
        }
        
        boolean oWin = isWinner(board, 'O');
        boolean xWin = isWinner(board, 'X');
        
        if (oWin && countO != countX + 1) {
            return 0;
        }
        
        if (xWin && countO != countX) {
            return 0;
        }
        
        if (oWin && xWin) {
            return 0;
        }
        
        return 1;
    }
    
    private boolean isWinner(String[] board, char player) {
        for (int i = 0; i < 3; i++) {
            if (board[i].charAt(0) == player && 
                board[i].charAt(1) == player && 
                board[i].charAt(2) == player) {
                return true;
            }
        }
        
        for (int j = 0; j < 3; j++) {
            if (board[0].charAt(j) == player && 
                board[1].charAt(j) == player && 
                board[2].charAt(j) == player) {
                return true;
            }
        }
        
        if (board[0].charAt(0) == player && 
            board[1].charAt(1) == player && 
            board[2].charAt(2) == player) {
            return true;
        }
        
        if (board[0].charAt(2) == player && 
            board[1].charAt(1) == player && 
            board[2].charAt(0) == player) {
            return true;
        }
        
        return false;
    }
}