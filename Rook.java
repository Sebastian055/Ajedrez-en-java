import java.util.ArrayList;
import java.util.List;

public class Rook extends Piece {
    public Rook(Color color) { super(color); }

    @Override
    public String getLabel() { return (color == Color.WHITE) ? "WR" : "BR"; }

    @Override
    public List<Position> getLegalMoves(Board board) {
        List<Position> moves = new ArrayList<>();
        addRayMoves(board, moves, -1, 0);
        addRayMoves(board, moves, 1, 0);
        addRayMoves(board, moves, 0, -1);
        addRayMoves(board, moves, 0, 1);
        return moves;
    }
}
