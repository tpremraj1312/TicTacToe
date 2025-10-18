import java.util.Scanner;

public class tictactoe {
    public static void main(String[] args) {
        
        char[][] board=new char[3][3]; // the game board
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                board[i][j]=' '; // start with empty spaces
            }
        }
        
        char currentPlayer='X'; // player X starts first
        Scanner scanner=new Scanner(System.in); // to get input from user
        boolean gameOver=false; // to check if game is finished
        
        // Game loop, keep playing until someone wins or it's a draw
        while(!gameOver) {
            printBoard(board); // show the current board
            
            // Ask for input
            System.out.println("Player "+currentPlayer+", enter row (0-2) and column (0-2): ");
            int row=scanner.nextInt();
            int col=scanner.nextInt();
            
            // Check if the spot is empty
            if (row>=0 && row<3 && col>=0 && col<3 && board[row][col]==' ') {
                board[row][col]=currentPlayer; // place the mark
                
                // Check if this player won
                if(checkWin(board, currentPlayer)){
                    printBoard(board);
                    System.out.println("Player " + currentPlayer + " wins!");
                    gameOver = true;
                } else if (isBoardFull(board)) {
                    printBoard(board);
                    System.out.println("It's a draw!");
                    gameOver=true;
                } else {
                    // Switch to the other player
                    if(currentPlayer=='X'){
                        currentPlayer='O';
                    } else {
                        currentPlayer='X';
                    }
                }
            } else {
                System.out.println("Invalid move, try again.");
            }
        }
    }
    
    //print the board
    public static void printBoard(char[][] board) {
        System.out.println("Board:");
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                System.out.print(board[i][j]);
                if (j < 2) {
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if (i < 2) {
                System.out.println("---------");
            }
        }
    }
    
    // Method to check if someone won
    public static boolean checkWin(char[][] board, char player) {
        // Check rows
        for (int i=0;i<3;i++) {
            if (board[i][0]==player && board[i][1]==player && board[i][2]==player) {
                return true;
            }
        }
        // Check columns
        for (int j=0;j<3;j++) {
            if (board[0][j]==player && board[1][j]==player && board[2][j]==player){
                return true;
            }
        }
        // Check diagonals
        if (board[0][0]==player && board[1][1]==player && board[2][2]==player) {
            return true;
        }
        if (board[0][2]==player && board[1][1]==player && board[2][0]==player) {
            return true;
        }
        return false;
    }
    
    // Method to check if board is full
    public static boolean isBoardFull(char[][] board) {
        for (int i=0;i<3;i++) {
            for (int j=0;j<3;j++) {
                if (board[i][j]==' ') {
                    return false;
                }
            }
        }
        return true;
    }
}