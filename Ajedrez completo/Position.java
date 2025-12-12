public class Position {
    private final int row; //Creamos el atributos la cual es la fila, ponemos final en la columna ya que esta no cambiara
    private final int col; //Creamos el atributos los cuales son las columnas, ponemos final ya que no pueden cambiar

    public Position(int row, int col) //Creamos el constructor el cual recibe la fila y la columna (los recibe)
    {
        this.row = row;
        this.col = col;
    }

    public int getRow() {return row;} //Metodo para leer los valores, no hay setters ya que la clase es inmutable
    public int getCol() {return col;}

    public boolean isValid()
    {
        return row >= 0 && row < 8 && col >= 0 && col < 8; //Se verifica que la fila  no sea negativa, ya que pide que sea mayor de 0. La fila no pasa de 7 ya que empieza en 0, la columna no es negativa y la columna no pasa de 7
    }

    //Funcion para comparar dos posiciones y saber si estan en el mismo lugar del tablero
    @Override //Override sirve para cambiar el metodo que ya existe, esto para crear una nueva forma de comparar objetos
    public boolean equals(Object o) //
    {
        if (this == o) return true; //Si es exactamente el mismo objeto entonces estos son iguales
        if (!(o instanceof Position)) return false; //Si el objeto no es una posicion entonces no son iguales
        Position that = (Position) o; //Ahora se trata ese objeto como una posicion para poder leer los datos
        return row == that.row && col == that.col; //Si la fila es igual y la columna igual devuelve true
    }

    
}
