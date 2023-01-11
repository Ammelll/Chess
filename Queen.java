public class Queen extends Piece {

    public Queen(int c, int y, int x){
        if(c == 1){this.symbol = "♕";}
        else{this.symbol = "♛";}
        this.color = c;
        this.currentX = x;
        this.currentY = y;
    }
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){

       
        board = diag(board, currentX, x, currentY, y);
        board = slide(currentX, x, currentY,y, true, true, x, y,false);
        board = slide(currentY, y, x, currentX, true, true, x, y,true);
        
        return board;
    }
       
}
