public class Knight extends Piece{


    public Knight(int c, int y, int x){
        if(c == 1){this.symbol = "♘";}
        else{this.symbol = "♞";}
        this.color = c;
        this.currentX = x;
        this.currentY = y;
    }
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){
        System.out.println("X: " + x + " " + "Y: " + y);
        System.out.println("CX: " + currentX + " " + "CY: " + currentY);
        board = knightMove(board, y, x,-1, 2);
        board = knightMove(board, y, x,1, 2);
        board = knightMove(board, y, x,2, -1);
        board = knightMove(board, y, x,2, 1);
        board = knightMove(board, y, x,1, -2);
        board = knightMove(board, y, x,-1, -2);
        board = knightMove(board, y, x,-2, 1);
        board = knightMove(board, y, x,-2, -1);
        
        return board;   
    }
    public Piece[][] knightMove(Piece[][] board, int y, int x, int changex, int changey){
        if((currentX+changex == x && currentY+changey == y) || (currentX-1 == x && currentY+2 == y)){
            if(board[y][x].getColor()!= color){
                board[y][x] = board[currentY][currentX];
                board[currentY][currentX] = new Piece();
                currentX = x;
                currentY = y;
            }
        }
        return board;
    }



}
