import javax.swing.*;
import java.awt.*;


public class ChessGUI extends JFrame { //Metodo para realizar la interfaz en 
    public ChessGUI()
    {
        setTitle("Ajedrez en java"); //Titulo de la interfaz
        setSize(600, 600); //Tamaño de la interfaz
        setDefaultCloseOperation(EXIT_ON_CLOSE); //Boton para cerrar la interfaz
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());

        Board board = new Board();
        board.setupInitial();

        BoardPanel boardPanel = new BoardPanel(board);
        add(boardPanel, BorderLayout.CENTER);

    }
   
    
      
}
    

