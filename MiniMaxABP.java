import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;

public class MiniMaxABP {

  public MiniMaxABP() {
  }

  public Piece[][] getBoardCopy() {
    Piece[][] b = new Piece[8][8];
    for (int i = 0; i < 8; i++) {
      for (int j = 0; j < 8; j++) {
        b[i][j] = Main.board[i][j];
      }
    }
    return b;
  }

  public ArrayList<ArrayList<Integer>> getPieceLocations(int color, Piece[][] board) {
    ArrayList<ArrayList<Integer>> arrayOfPieces = new ArrayList<ArrayList<Integer>>();
    for (int width = 0; width < 8; width++) {
      for (int height = 0; height < 8; height++) {
        if (board[width][height].getColor() == color) {
          List<Integer> asList = (List<Integer>) Arrays.asList(width, height);
          arrayOfPieces.add(new ArrayList<Integer>(asList));
        }
      }
    }
    return arrayOfPieces;
  }

  public ArrayList<ArrayList<Integer>> getLegalMoves(Piece p) {
    Piece[][] board = getBoardCopy();
    ArrayList<ArrayList<Integer>> arrayOfLegalmoves = new ArrayList<ArrayList<Integer>>();
    for (int w = 0; w < 8; w++) {
      for (int h = 0; h < 8; h++) {
        board = getBoardCopy();
        Piece[][] temp = p.move(h, w, board, true);
        if(!(isEqual(temp,getBoardCopy()))){
          List<Integer> asList = (List<Integer>) Arrays.asList(w, h);
          arrayOfLegalmoves.add(new ArrayList<Integer>(asList));
        }
      }
    }
    return arrayOfLegalmoves;
  }
  public static boolean isEqual(Piece[][] arr1, Piece[][] arr2){
    //Main.printBoard(arr1);
    //Main.printBoard(arr2);
    boolean equal = true;
    for (int w = 0; w < 8; w++) {
      for (int h = 0; h < 8; h++) {
       
        if(!(arr1[w][h].symbol.equals(arr2[w][h].symbol))){
          equal = false;
        }
      }
    }
    return equal;
  }

  }