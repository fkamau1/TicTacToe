import java.util.Scanner;

public class TicTacToe {
    private char[][] board;
    private boolean gameOver;
    private char currentPlayer;

    public TicTacToe(){
        board = new char[3][3];
        gameOver = false;
        currentPlayer = 'X';
        initializeBoard();
    }

    public void initializeBoard(){
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                board[row][column] = ' ';
            }
        }
    }

    public void displayBoard(){
        for(int row = 0; row < board.length; row++){
            for(int column = 0; column < board[row].length; column++){
                System.out.print(board[row][column]);

                if(column < board.length - 1){
                    System.out.print(" | ");
                }
            }
            System.out.println();
            if(row < board.length - 1){
                System.out.println("-----------");
            }
        }
    }

    public void playGame(){
        //displayBoard();
        while (!gameOver){
            displayBoard();
            makeMove();
            if(checkWin()){
                System.out.println("Player " + currentPlayer + " wins");
                gameOver = true;
            }else if(checkTie()){
                System.out.println("It's a tie");
                gameOver = true;
            }
            currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
        }
        displayBoard();
    }

    public void makeMove(){
        Scanner input = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + " enter your move (row[0-2]) ,column[0-2]");
        int row = input.nextInt();
        int column = input.nextInt();

        if (isValidMove(row,column)){
            board[row][column] = currentPlayer;
        } else {
            System.out.println("Invalid move - please try again");
            makeMove();
        }
    }

    private boolean isValidMove(int row, int column){
        return row >= 0 && row < 3 && column >= 0 && column < 3 && board[row][column] == ' ';
    }

    private boolean checkWin(){
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows(){
        for(int i = 0; i < board.length; i++) {
            if (board[i][0] != ' ' && board[i][0] == board[i][1] && board[i][1] == board[i][2]){
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns(){
        for(int i = 0; i < board.length; i++){
            if(board[0][i] != ' ' && board[0][i] == board[1][i] && board[1][i] == board[2][i]){
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals(){
             if(board[0][0] != ' ' && board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
                 return true;
             }
             if (board[2][0] != ' ' && board[2][0] == board[1][1] && board[1][1] == board[2][0]){
                 return true;
             }
        return false;
    }

    private boolean checkTie(){
        for(int i = 0; i < board.length; i++){
            for(int j = 0; j < board[i].length; j++){
                if(board[i][j] == ' '){
                    return false;
                }
            }
        }
        return true;
    }
}
