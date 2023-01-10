public class Piece {
    public String symbol;
    public int color;
    public int currentX;
    public int currentY;
    public boolean allXPos = true;
    public boolean allXNeg = true;
    public boolean allYPos = true;
    public boolean allYNeg = true;
    public boolean TR = true;
    public boolean BR = true;
    public boolean TL = true;
    public boolean BL = true;

    public Piece(){
        this.symbol = "-";
    }


    public boolean hasPiece(){
        if(this.symbol.equals("-")){return false;}
        return true;
    }
    public Piece[][] getBoardCopy(){
        Piece[][] b = new Piece[8][8];
          for(int i = 0; i < 8; i++){
            for(int j =0; j<8;j++){
              b[i][j] = Main.board[i][j];
            }
          }
        return b;
      }
    public int getColor(){return this.color;}

    public Piece[][] promote(int y, int x){return Main.board;}

    public String toString(){return this.symbol;}

    
    public Piece[][] move(int y, int x, Piece[][] board, boolean ghost){
        return Main.board;
    }
    public Piece[][] slide(int a, int b, int c, int d, boolean b1, boolean b2, int x, int y, boolean xOrYAxis){
    Piece[][] board = Main.board;
    
    if(c == d){
        if(board[y][x].getColor()!= color){
            System.out.println("A " + a + " B " + b);
            if(b > a){
                for(int i = 1; i <  b-a; i++){
                    if(xOrYAxis){
                        System.out.println("A");
                        if(board[y-i][x].hasPiece()){
                            b1 = false;
                        }
                    }
                    if(!(xOrYAxis)){
                        System.out.println("B");
                        if(board[y][x-i].hasPiece()){
                            b1 = false;
                        }
                    }
                }
                if(b1){
                    board[y][x] = board[currentY][currentX];
                    board[currentY][currentX] = new Piece();
                    currentX = x;
                    currentY = y;
                    return board;
                }
            }
            else if(b < a){
                for(int i = 1; i <  a-b; i++){
                    if(xOrYAxis){
                        System.out.println("Q");
                        if(board[y+i][x].hasPiece()){
                            b2 = false;
                        }
                    }
                    if(!(xOrYAxis)){
                        System.out.println("P");
                        if(board[y][x+i].hasPiece()){
                            b2 = false;
                        }
                    }
                }
                if(b2){
                    board[y][x] = board[currentY][currentX];
                    board[currentY][currentX] = new Piece();
                    currentX = x;
                    currentY = y;
                    return board;
                }


            }
        }

        }
        return board;
    }
    public Piece[][] diag(Piece[][] board, int a, int b, int c, int d){
        int flipSign1 = 1;
        int flipSign2 = 1;
        boolean bool = true;
        if(Math.abs(a-b) == Math.abs(c-d)){
            if(board[d][b].getColor()!= color){
                if(a > b && c > d){
                    flipSign1 = -1;
                    flipSign2 = -1;
                }
                else if(a > b && c < d){
                    flipSign1 = -1;
                    flipSign2 = 1;
                }
                else if(a < b && c > d){
                    flipSign1 = -1;
                    flipSign2 = 1;
                }
                else if(a < b && c < d){
                    flipSign1 = 1;
                    flipSign2 = 1;
                }
                for(int i = 1; i < Math.abs(d-c);i++){
                    System.out.println((c+i*flipSign1) + " | " + (a+i*flipSign2));
                    System.out.println(bool);
                    if(board[c+i*flipSign2][a+i*flipSign1].hasPiece()){
                        bool = false;
                    }
                }
                System.out.println(bool);
            }
                    if(bool){
                        board[d][b] = board[c][a];
                        board[c][a] = new Piece();
                        currentX = b;
                        currentY = d;
                        return board;
                }
            }
            return board;
        }
    public Piece[][] basicMovement(Piece[][] board, int a, int b, int c, int d, int changex, int changey, boolean ghost){
        if(a+changex == b && c+changey == d){
            if(board[d][b].getColor()!= color){
                board[d][b] = board[c][a];
                board[c][a] = new Piece();
                if(!ghost){
                    currentX = b;
                    currentY = d;
                }
            }
        }
        // for(Piece[] pa : board){
        //     for(Piece p : pa){
        //         System.out.print(p.symbol);
        //     }
        //     System.out.println();
        // }
        return board;
    }
    }

