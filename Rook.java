public class Rook extends Piece {

    public Rook(int c, int y, int x){
        if(c == 1){this.symbol = "♖";}
        else{this.symbol = "♜";}
        this.color = c;
        this.currentX = x;
        this.currentY = y;
    }
    
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){
        board = slide(currentX, x, currentY,y, true, true, x, y,false);
        board = slide(currentY, y, x, currentX, true, true, x, y,true);

        return board;
    }
 
}
