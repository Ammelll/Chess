public class Pawn extends Piece{
    private boolean firstMove = true;

    public Pawn(int c, int y, int x){
        if(c == 1){this.symbol = "♙";}
        else{this.symbol = "♟";}
        this.color = c;
        this.currentX = x;
        this.currentY = y;
        this.firstMove = true;
    }
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){
        
        board = basicMovement(board,currentX, x, currentY, y, 0,color, ghost);
        if(firstMove){
            board = basicMovement(board, currentX, x, currentY, y, 0,color*2, ghost);
        }
        if(!ghost){
            firstMove = false;
        }
        if(currentX+color == x && currentY+color== y && board[y][x].hasPiece()){
            if(board[y][x].getColor()!= color){
                board[y][x] = board[currentY][currentX];
                board[currentY][currentX] = new Piece();
                if(!ghost){
                    currentX = x;
                    currentY = y;
                    firstMove = false;
                }
            }
        }
        else if(currentX-color == x && currentY+color== y && board[y][x].hasPiece()){
            if(board[y][x].getColor()!= color){
                board[y][x] = board[currentY][currentX];
                board[currentY][currentX] = new Piece();
                if(!ghost){
                    currentX = x;
                    currentY = y;
                    firstMove = false;
                }
            }
        }
        
        return board;   
    }



    @Override public Piece[][] promote(int y, int x){
        Piece[][] board = Main.board;
        if(y == 0 && color == -1){
            board[y][x] = new Queen(color, y,x);
        }
        if(y == 7 && color == 1){
            board[y][x] = new Queen(color,y,x);
        }
        return board;


    }



}
