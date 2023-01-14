import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
public class Node{
     public int score;
     public int depth;
     public int color;
     public int originalColor;
     public Piece[][] currentBoard;
     public List<Integer> asList;
     //Im praying for this to work :P
     public ArrayList<Node> nodeArray = new ArrayList<Node>();
     public Node(Piece[][] cb, List<Integer> al, int c, int d, int s, int oc){
        this.asList = al;
        this.originalColor = oc;
        this.depth = d;
        this.currentBoard = cb;
        this.color = c;
        this.score = s;
        //        if (board[width][height].getColor() == col
        MiniMaxABP mini = new MiniMaxABP();
        Piece[][] compareBoard = getBoardCopy(currentBoard);
        if(depth < 4){ 
            ArrayList<ArrayList<Integer>> pieces = mini.getPieceLocations(originalColor, currentBoard);
            for (int i = 0; i < pieces.size(); i++) {
                for (int j = 0; j < pieces.get(0).size()-1; j++) {
                    ArrayList<ArrayList<Integer>> legalMoves = mini.getLegalMoves(currentBoard[pieces.get(i).get(j)][pieces.get(i).get(j+1)]);
                    // System.o
                    for (int k = 0; k < legalMoves.size(); k++) {
                        currentBoard = getBoardCopy(compareBoard);
                        currentBoard = currentBoard[pieces.get(i).get(j)][pieces.get(i).get(j+1)].move(legalMoves.get(k).get(1),legalMoves.get(k).get(0), currentBoard, true);
                        score = originalColor * compare(currentBoard,compareBoard, color);
                        if(depth == 0){ 
                            asList = (List<Integer>) Arrays.asList(legalMoves.get(k).get(1),legalMoves.get(k).get(0),pieces.get(i).get(j),pieces.get(i).get(j+1));                           
                        }
                        nodeArray.add(new Node(currentBoard,asList,(color*-1),depth+1, score, originalColor));

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
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if((arr1[i][j].symbol.equals("♗")) || (arr1[i][j].symbol.equals("♝"))){
                    if(arr1[i][j].color == originalColor){
                      score1+=3;
                    }
                  else{
                    score1-=3;
                      }
                }
                if((arr1[i][j].symbol.equals("♔")) || (arr1[i][j].symbol.equals("♚"))){
                    if(arr1[i][j].color == originalColor){
                      score1+=100;
                    }
                  else{
                    score1-=100;
                      }
                }
                if((arr1[i][j].symbol.equals("♘")) || (arr1[i][j].symbol.equals("♞"))){
                    if(arr1[i][j].color == originalColor){
                      score1+=3;
                    }
                  else{
                    score1-=3;
                      }
                }
                if((arr1[i][j].symbol.equals("♙")) || (arr1[i][j].symbol.equals("♟"))){
                    if(arr1[i][j].color == originalColor){
                      score1+=1;

                    }
                  else{

                    score1-=1;
                      }
                }
                if((arr1[i][j].symbol.equals("♕")) || (arr1[i][j].symbol.equals("♛"))){
                    if(arr1[i][j].color == originalColor){
                      score1+=8;
                    }
                  else{
                    score1-=8;
                      }
                }
                if((arr1[i][j].symbol.equals("♖")) || (arr1[i][j].symbol.equals("♜"))){
                    if(arr1[i][j].color == originalColor){
                      score1+=5;
                    }
                  else{
                    score1-=5;
                      }
                }

              
                
                  if((arr2[i][j].symbol.equals("♗")) || (arr2[i][j].symbol.equals("♝"))){
                    if(arr2[i][j].color == originalColor){
                      score2+=3;
                    }
                  else{
                    score2-=3;
                      }
                }
                if((arr2[i][j].symbol.equals("♔")) || (arr2[i][j].symbol.equals("♚"))){
                    if(arr2[i][j].color == originalColor){
                      score2+=100;
                    }
                  else{
                    score2-=100;
                      }
                }
                if((arr2[i][j].symbol.equals("♘")) || (arr2[i][j].symbol.equals("♞"))){
                    if(arr2[i][j].color == originalColor){
                      score2+=3;
                    }
                  else{
                    score2-=3;
                      }
                }
                if((arr2[i][j].symbol.equals("♙")) || (arr2[i][j].symbol.equals("♟"))){
                    if(arr2[i][j].color == originalColor){
                      score2+=1;
                    }
                  else{
                    score2-=1;
                      }
                }
                if((arr2[i][j].symbol.equals("♕")) || (arr2[i][j].symbol.equals("♛"))){
                    if(arr2[i][j].color == originalColor){
                      score2+=8;
                    }
                  else{
                    score2-=8;
                      }
                }
                if((arr2[i][j].symbol.equals("♖")) || (arr2[i][j].symbol.equals("♜"))){
                    if(arr2[i][j].color == originalColor){
                      score2+=5;
                    }
                  else{
                    score2-=5;
                      }
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