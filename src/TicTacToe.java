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
            currentPlayer = (currentPlayer == 'X') ? 'X' : 'O';
        }
        displayBoard();
    }

    public void makeMove(){
        Scanner input = new Scanner(System.in);
        System.out.println("Player " + currentPlayer + "enter your move (row[0-2]) ,column[0-2]");
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
        return true;
    }

    private boolean checkRows(){
        return true;
    }

    private boolean checkColumns(){
        return true;
    }

    private boolean checkDiagonals(){
        return true;
    }

    private boolean checkTie(){
        return true;
    }
}
