import java.util.List;

public abstract class Piece { //Es abstracta osea que no se puede ejecutar directamente (servira como base para crear las piezas)
    public enum Color {WHITE,BLACK} //Ponemos el color de las dos piezas

    protected Color color; //Guardamos el color de la pieza 
    protected Position position; //Guarda la posicion de la pieza

    public Piece (Color color){ //Asignamos el constructor para guardar el color de la pieza
        this.color = color;
    }

    public Color getColor() {return color;} //Sirve para leer el color de la pieza con un get
    public Position gePosition() {return position;} //Sirve para leer la posicion
    public void setPosition (Position position) {this.position = position;} //Se utiliza para asignar la posicion de la pieza, como es un setter modifica algo

    public abstract String getLabel(); //Es un metodo el cual tienecomo promesa de que este existira
    public abstract List<Position> getLegalMoves(Board board); //Devolvera una lista de posiciones (lo que significa que casillas se pueden mover una pieza)


    protected void addRayMoves(Board board, List <Position> moves, int dr, int dc) //Metodo el cual sirve para agregar todos los movimientos posibles en linea recta desde una pieza
    {
        int r = position.getRow() + dr;
        int c = position.getCol() + dc;
        while (board.inBounds(r,c)) {
            if (board.isEmpty(r, c)){
                moves.add(new Position(r, c));
            } else if (board.isEnemy(r, c, color)) {
                moves.add(new Position(r, c));
                break;
            } else {
                break;
            }
            r += dr;
            c += dc;
        }

    }
}
