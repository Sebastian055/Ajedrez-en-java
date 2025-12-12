public class Board {
    private final Piece [][] grid = new Piece[8][8]; //Declara un atributo de la clase llamado grid el cual declara una matriz de 8x8 

    public Piece getPiece(Position p)  //Este metodo sirve para pedir la pieza que esta en una posicion del tablero
    {
        if (!p.isValid()) return null; //Revisa si la posicion es valida, si no lo es devuelve null en la consola
        return grid[p.getRow()][p.getCol()]; //Devuelve la pieza que esta en la casilla del tablero

    }

    public void setPiece(Position p, Piece piece) //Metodo para poner una casilla en el tablero (recibe la posicion donde quieras poner la pieza y la pieza que quieres colocar)
    {
        if (!p.isValid()) return;  //Revisa si la posicion esta dentro del rango 0-7, si es valida no hace nada
        grid[p.getRow()][p.getCol()] = piece; //Se coloca la pieza en la matriz del tablero
        if (piece != null) piece.setPosition(p); //Actualiza la pieza por dentro (guarda la posicion)

    }

    public boolean inBounds(int row, int col )
    {
        return row >= 0 && row < 8 && col >= 0 && col < 8; //Verificamos que la casilla este dentrodel tablero
    }

    public boolean isEmpty(int row, int col)
    {
        return grid[row][col] == null; //Sabemos si una casilla del tablero esta vacia
    }

    public boolean isEnemy (int row, int col, Piece.Color color) //Metodo que sirve para saber si hay una pieza enemiga
    {
        Piece p = grid[row][col];
        return p != null && p.getColor() != color;
    }

    public void movePiece (Position from, Position to) //Mueve una camisa desde una casilla hacia otra
    {
        Piece p = getPiece(from); //Busca que pieza esta en la casilla from, si hay una pieza la guarda en p
        if (p == null) return; //Si from esta vacio no hay nada que mover y se sale del metodo
        setPiece(to, p); //Coloca la pieza p en la casilla destino to
        setPiece(from, null); //Despues de mover la casilla de origen debe de quedar vacia
    }


    public void setupInitial () //Metodo para generar las piezas
    {
        //Piezas blancas:
        setPiece(new Position(0,0), new Rook(Piece.Color.WHITE));
        setPiece(new Position(0,1), new Knight(Piece.Color.WHITE));
        setPiece(new Position(0,2), new Bishop(Piece.Color.WHITE));
        setPiece(new Position(0,3), new Queen(Piece.Color.WHITE));
        setPiece(new Position(0,4), new King(Piece.Color.WHITE));
        setPiece(new Position(0,5), new Bishop(Piece.Color.WHITE));
        setPiece(new Position(0,6), new Knight(Piece.Color.WHITE));
        setPiece(new Position(0,7), new Rook(Piece.Color.WHITE));
        for (int c = 0; c < 8; c++) setPiece(new Position(1, c), new Pawn(Piece.Color.WHITE)); //Se colocan los 8 peones blancos en la fila 1 del tablero


        //Piezas negras:
        setPiece(new Position(7, 0), new Rook(Piece.Color.BLACK));
        setPiece(new Position(7, 1), new Knight(Piece.Color.BLACK));
        setPiece(new Position(7, 2), new Bishop(Piece.Color.BLACK));
        setPiece(new Position(7, 3), new Queen(Piece.Color.BLACK));
        setPiece(new Position(7, 4), new King(Piece.Color.BLACK));
        setPiece(new Position(7, 5), new Bishop(Piece.Color.BLACK));
        setPiece(new Position(7, 6), new Knight(Piece.Color.BLACK));
        setPiece(new Position(7, 7), new Rook(Piece.Color.BLACK));
        for (int c = 0; c < 8; c++) setPiece(new Position(6, c), new Pawn(Piece.Color.BLACK));
    }



    }





