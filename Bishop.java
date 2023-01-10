public class Bishop extends Piece {

    public Bishop(int c, int y, int x){
        if(c == 1){this.symbol = "♗";}
        else{this.symbol = "♝";}
        this.color = c;
        this.currentX = x;
        this.currentY = y;
    }
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){
        System.out.println("BX: " + x + " " + "Y: " + y);
        System.out.println("BCX: " + currentX + " " + "CY: " + currentY);
        board = diag(board, currentX, x, currentY, y);
        return board;
    }
    @Override public int getColor(){return this.color;}

}
