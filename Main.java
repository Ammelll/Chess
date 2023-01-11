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
        MiniMaxABP mini = new MiniMaxABP();

        ArrayList<ArrayList<Integer>> pieces = mini.getPieceLocations(-1, board);
    

        // for (int i = 0; i < pieces.size(); i++) {
        //     for (int j = 0; j < pieces.get(0).size()-1; j++) {

        //         ArrayList<ArrayList<Integer>> legalMoves = mini.getLegalMoves(board[pieces.get(i).get(j)][pieces.get(i).get(j+1)]);
        //         for (int k = 0; k < legalMoves.size(); k++) {
        //             for (int l = 0; l < legalMoves.get(0).size()-1; l++) {
        //                 System.out.println(legalMoves.get(k).get(l) + " " + legalMoves.get(k).get(l+1));
                        
        //             }
        //         }
        //     }
            
        // }
        // printBoard(board);
    // }
        // MiniMaxABP mini = new MiniMaxABP();
        // ArrayList<ArrayList<Integer>> pieces = mini.getPieceLocations(-1, board);
        // for (int i = 0; i < pieces.size(); i++) {
        //     for (int j = 0; j < pieces.get(0).size(); j++) {
        //         System.out.println(pieces.get(i).get(j));
        //     }
        // }

        // Node root = new Node(board,new ArrayList<ArrayList<Integer>>(), -1, 0, 0);
        // for(Node n : root.nodeArray){
        //     for(Node node : n.nodeArray){
        //         printBoard(n.currentBoard);

        //     }
        // }
    }
    //     while(true){
    //         Main.printBoard(board);
    //         int chosenPieceX = Integer.parseInt(scanner.nextLine());
    //         int chosenPieceY = Integer.parseInt(scanner.nextLine());
    //         int attemptX = Integer.parseInt(scanner.nextLine());
    //         int attemptY = Integer.parseInt(scanner.nextLine());
    //         board[chosenPieceY][chosenPieceX].move(attemptY, attemptX, board, false);
    //         Main.promotionCheck();
    //     }
    // }




    
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
        // board[r][0] = new Rook(c,r,0);
        // board[r][1] = new Knight(c,r,1);       
        // board[r][2] = new Bishop(c,r,2);         
        // board[r][3] = new Queen(c,r,3);    
        // board[r][4] = new King(c,r,4);    
        // board[r][5] = new Bishop(c, r, 5);    
        // board[r][6] = new Knight(c,r,6);
        // board[r][7] = new Rook(c,r,7);  
        board[r][0] = new Piece();
        board[r][1] = new Piece();
        board[r][2] = new Piece();
        board[r][3] = new Piece();
        board[r][4] = new Piece();
        board[r][5] = new Piece();
        board[r][6] = new Piece();
        board[r][7] = new Piece();

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