public class King extends Piece{


    public King(int c, int y, int x){
        if(c == 1){this.symbol = "♔";}
        else{this.symbol = "♚";}
        this.color = c;
        this.currentX = x;
        this.currentY = y;
    }
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){
        System.out.println("X: " + x + " " + "Y: " + y);
        System.out.println("KX: " + currentX + " " + "KY: " + currentY);
        board = basicMovement(board, currentX, x, currentY, y, 1,1,ghost);
        board = basicMovement(board, currentX, x, currentY, y, 1,0 ,ghost);
        board = basicMovement(board, currentX, x, currentY, y, 1,-1,ghost);
        board = basicMovement(board, currentX, x, currentY, y, 0, 1,ghost);
        board = basicMovement(board, currentX, x, currentY, y, 0, -1,ghost);
        board = basicMovement(board, currentX, x, currentY, y, -1, 1,ghost);
        board = basicMovement(board, currentX, x, currentY, y, -1, 0,ghost);
        board = basicMovement(board, currentX, x, currentY, y, -1, -1,ghost);
        
        return board;   
    }
}
