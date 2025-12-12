import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {

        // Ejecuta la GUI en el hilo de interfaz gráfica (EDT)
        SwingUtilities.invokeLater(() -> {
            ChessGUI gui = new ChessGUI();  // Crea la ventana del juego
            gui.setLocationRelativeTo(null); // Centra la ventana en la pantalla
            gui.setVisible(true);            // Hace la ventana visible
        });
    }
}
