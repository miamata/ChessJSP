package Chess;

public class Rey extends Pieza {
    
    public Rey(Color color) {
        super(color, color == Color.BLANCAS ? "&#9812;": "&#9818;");
    }

    @Override
    public Boolean[][] movimientosValidos(String pos) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
