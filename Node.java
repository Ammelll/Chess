import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Node{
     public int score;
     public ArrayList<ArrayList<Integer>> moveSet;
     public int depth;
     public int color;
     public Piece[][] currentBoard;
     //Im praying for this to work :P
     public ArrayList<Node> nodeArray = new ArrayList<Node>();
     public Node(Piece[][] cb, ArrayList<ArrayList<Integer>> ms, int c, int d, int s){
        this.moveSet = ms;
        this.depth = d;
        this.currentBoard = cb;
        this.color = c;
        this.score = s;
        MiniMaxABP mini = new MiniMaxABP();
        Piece[][] compareBoard = getBoardCopy(currentBoard);
        if(depth < 3){
            ArrayList<ArrayList<Integer>> pieces = mini.getPieceLocations(color, currentBoard);
            for (int i = 0; i < pieces.size(); i++) {
                for (int j = 0; j < pieces.get(0).size()-1; j++) {


                    ArrayList<ArrayList<Integer>> legalMoves = mini.getLegalMoves(currentBoard[pieces.get(i).get(j)][pieces.get(i).get(j+1)]);


                    for (int k = 0; k < legalMoves.size(); k++) {
                        for (int l = 0; l < legalMoves.get(0).size()-1; l++) {
                            currentBoard = getBoardCopy(compareBoard);
                            currentBoard = currentBoard[pieces.get(i).get(j)][pieces.get(i).get(j+1)].move(legalMoves.get(k).get(l+1),legalMoves.get(k).get(l), currentBoard, true);
                            score+= compare(currentBoard,compareBoard, color);
                            List<Integer> asList = (List<Integer>) Arrays.asList(k, l);
                            moveSet.add(new ArrayList<Integer>(asList));
                            nodeArray.add(new Node(currentBoard,moveSet,color,depth+1, score));
                        }
                    }
                }
            }
        }
     }
     public Piece[][] getBoardCopy(Piece[][] board) {
        Piece[][] b = new Piece[8][8];
        for (int i = 0; i < 8; i++) {
          for (int j = 0; j < 8; j++) {
            b[i][j] = board[i][j];
          }
        }
        return b;
      }
     public int compare(Piece[][] arr1, Piece[][] arr2, int color){
        int score1 = 0;
        int score2 = 0;
        String bishopSymbol = "";
        String kingSymbol = "";
        String knightSymbol = "";
        String pawnSymbol = "";
        String queenSymbol = "";
        String rookSymbol = "";

        if(color == 1){
            bishopSymbol = "♗";
            kingSymbol = "♔";
            knightSymbol = "♘";
            pawnSymbol = "♙";
            queenSymbol = "♕";
            rookSymbol = "♖";
        }
        if(color == -1){
            bishopSymbol = "♝";
            kingSymbol = "♚";
            knightSymbol = "♞";
            pawnSymbol = "♟";
            queenSymbol = "♛";
            rookSymbol = "♜";
        }
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((arr1[i][j].symbol.equals(bishopSymbol) && arr1[i][j].color == color)){
                    score1+=3;
                }
                if((arr1[i][j].symbol.equals(kingSymbol) && arr1[i][j].color == color)){
                    score1+=100;
                }
                if((arr1[i][j].symbol.equals(knightSymbol) && arr1[i][j].color == color)){
                    score1+=3;
                }
                if((arr1[i][j].symbol.equals(pawnSymbol) && arr1[i][j].color == color)){
                    score1+=1;
                }
                if((arr1[i][j].symbol.equals(queenSymbol) && arr1[i][j].color == color)){
                    score1+=8;
                }
                if((arr1[i][j].symbol.equals(rookSymbol) && arr1[i][j].color == color)){
                    score1+=5;
                }
                
                if((arr2[i][j].symbol.equals(bishopSymbol) && arr2[i][j].color == color)){
                    score2+=3;
                }
                if((arr2[i][j].symbol.equals(kingSymbol) && arr2[i][j].color == color)){
                    score2+=100;
                }
                if((arr2[i][j].symbol.equals(knightSymbol) && arr2[i][j].color == color)){
                    score2+=3;
                }
                if((arr2[i][j].symbol.equals(pawnSymbol) && arr2[i][j].color == color)){
                    score2+=1;
                }
                if((arr2[i][j].symbol.equals(queenSymbol) && arr2[i][j].color == color)){
                    score2+=8;
                }
                if((arr2[i][j].symbol.equals(rookSymbol) && arr2[i][j].color == color)){
                    score2+=5;
                }

            }
        }
       
        return score1-score2;
    }
}
/*
for piece
new Node()
 */