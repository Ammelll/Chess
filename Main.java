import java.util.ArrayList;
import java.util.Scanner;
public class Main{
    public static Piece[][] board = new Piece[8][8];
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args){
        Main.populate(0,1);
        Main.populate(7,-1);
        for(int p = 0; p < 8; p++){
            board[1][p] = new Pawn(1,1,p);
        }  
        for(int p = 0; p < 8; p++){
            board[6][p] = new Pawn(-1,6,p);
        }  
        for(int i = 2; i < 6; i++){
            for(int j = 0; j < 8; j++){
                board[i][j] = new Piece();
            }
        }    
        MiniMaxABP mini = new MiniMaxABP(-1);
        ArrayList<ArrayList<Integer>> tempBoard = mini.getLegalMoves(board[1][0]);
        while(true){
            Main.printBoard(board);
            int chosenPieceX = Integer.parseInt(scanner.nextLine());
            int chosenPieceY = Integer.parseInt(scanner.nextLine());
            int attemptX = Integer.parseInt(scanner.nextLine());
            int attemptY = Integer.parseInt(scanner.nextLine());
            board[chosenPieceY][chosenPieceX].move(attemptY, attemptX, board, false);
            Main.promotionCheck();
        }
    }




    
    public static Piece[][] promotionCheck(){
        for(int i = 0; i < 7; i++){
            board = board[0][i].promote(0,i);
            board = board[7][i].promote(7,i);
        }
        return board;
    }
    public static void printBoard(Piece[][] board){
        for(int i = 0; i < 8; i++ ){
            for(int j = 0; j < 8; j++){
                System.out.print(board[i][j]);
            }
            System.out.println();
        }
    }
    public static void populate(int r, int c){
        board[r][0] = new Rook(c,r,0);
        board[r][1] = new Knight(c,r,1);       
        board[r][2] = new Bishop(c,r,2);         
        board[r][3] = new Queen(c,r,3);    
        board[r][4] = new King(c,r,4);    
        board[r][5] = new Bishop(c, r, 5);    
        board[r][6] = new Knight(c,r,6);
        board[r][7] = new Rook(c,r,7);  
    }
    public static Piece[][] getBoardCopy(){
        Piece[][] b = new Piece[8][8];
          for(int i = 0; i < 8; i++){
            for(int j =0; j<8;j++){
              b[i][j] = Main.board[i][j];
            }
          }
        return b;
      }
}