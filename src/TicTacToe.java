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
        displayBoard();
        while (!gameOver){
            //displayBoard();
        }
    }
}
