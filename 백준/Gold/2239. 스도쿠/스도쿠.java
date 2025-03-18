import java.util.*;
import java.lang.*;
import java.io.*;

public class Main {
    private static final int GRID_SIZE = 9;
    
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        int[][] board = new int[GRID_SIZE][GRID_SIZE];
        
        for (int i = 0; i < GRID_SIZE; i++) {
            st = new StringTokenizer(br.readLine());
            int num = Integer.parseInt(st.nextToken());
            for (int j = GRID_SIZE - 1; j >= 0; j--) {
                board[i][j] = num % 10;
                num /= 10;
            }
        }
        
        solveBoard(board);
        
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                bw.write(board[i][j] + "");
            }
            bw.write("\n");
        }
        
        bw.flush();
        bw.close();
    }
    
    private static boolean solveBoard(int[][] board) {
        int[] emptyCell = findEmptyCell(board);
        int row = emptyCell[0];
        int col = emptyCell[1];
        
        if (row == -1 && col == -1) {
            return true;
        }
        
        for (int num = 1; num <= GRID_SIZE; num++) {
            if (isValidPlacement(board, row, col, num)) {
                board[row][col] = num;
                
                if (solveBoard(board)) {
                    return true;
                }
                
                board[row][col] = 0;
            }
        }
        
        return false;
    }
    
    private static int[] findEmptyCell(int[][] board) {
        int[] cell = {-1, -1};
        
        for (int i = 0; i < GRID_SIZE; i++) {
            for (int j = 0; j < GRID_SIZE; j++) {
                if (board[i][j] == 0) {
                    cell[0] = i;
                    cell[1] = j;
                    return cell;
                }
            }
        }
        
        return cell;
    }
    
    private static boolean isValidPlacement(int[][] board, int row, int col, int num) {
        for (int j = 0; j < GRID_SIZE; j++) {
            if (board[row][j] == num) {
                return false;
            }
        }
        
        for (int i = 0; i < GRID_SIZE; i++) {
            if (board[i][col] == num) {
                return false;
            }
        }
        
        int startRow = row - row % 3;
        int startCol = col - col % 3;
        
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[startRow + i][startCol + j] == num) {
                    return false;
                }
            }
        }
        
        return true;
    }
}