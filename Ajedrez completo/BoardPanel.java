import javax.swing.*;
import java.awt.*;

public class BoardPanel extends JPanel {
    private final Board board;

    public BoardPanel(Board board) { //Constructor el cual recibe el tablero y organiza el panel con una cuadricula 8x8 
        this.board = board; //Guarda el tablero que mando ChessGUI
        setLayout(new GridLayout(8, 8)); //Esto hace que el juego tenga 64 casillas
        render(); //Dibuja el tablero
    }

    private void render() {
        removeAll(); //Borra lo que habia antes
        for (int r = 0; r < 8; r++) { //Recorre las 64 casillas
            for (int c = 0; c < 8; c++) {
                Piece p = board.getPiece(new Position(r, c)); //Crea una posicion y pide al objeto Board que pieza esta alli
                JButton casilla = new JButton(p == null ? "" : p.getLabel()); //Crea el boton de la pieza
                casilla.setBackground(((r + c) % 2 == 0) ? new Color(240, 217, 181) : new Color(181, 136, 99)); //Pinta la casilla blanca o negra
                add(casilla);
            }
        }
        //Actualiza visualmente
        revalidate(); //Recalcula el diseño
        repaint(); //Repinta el panel
    }
}
