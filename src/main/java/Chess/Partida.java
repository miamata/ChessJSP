package Chess;
import java.util.ArrayList;

public class Partida {

	public boolean esJugadaValida(int y, int x) {
		boolean[][] movimientosValidos = new boolean[8][8];
		movimientosValidos = tablero[casillaAnterior[0]][casillaAnterior[1]].movimientosValidos(casillaAnterior[0], casillaAnterior[1], this);
		
		return movimientosValidos[y][x] == true;
	}
    
	private Pieza[][] tablero;
	private ArrayList<Pieza> cementerio = new ArrayList<>();
	private Color turno = Color.BLANCAS;
        private int[] casillaAnterior;
        
	public Color getTurno() {return this.turno;}
	
	public void cambiarTurno() {
		this.turno = this.turno == Color.BLANCAS ? Color.NEGRAS : Color.BLANCAS;
	}
	
	public Partida(Pieza[][] tablero) {this.tablero = tablero;}
	
        public void setCasillaAnterior(int[] casilla) {this.casillaAnterior = casilla;}
        
	public Pieza[][] getTablero() {return this.tablero;}

	public int[] getCasillaAnterior() {return this.casillaAnterior;}
        
	public ArrayList<Pieza> getCementerio() {return this.cementerio;}

	public static Partida inicializaPartida() {return new Partida(tableroDefault());}
	
        public static Pieza[][] tableroDefault() {
                
		Pieza[][] tablero = new Pieza[8][8]; // Inicializo tablero
		
                tablero[0][0] = new Torre(Color.NEGRAS);
                tablero[0][1] = new Caballo(Color.NEGRAS);
                tablero[0][2] = new Alfil(Color.NEGRAS);
                tablero[0][3] = new Reina(Color.NEGRAS);
                tablero[0][4] = new Rey(Color.NEGRAS);
		tablero[0][5] = new Alfil(Color.NEGRAS);
                tablero[0][6] = new Caballo(Color.NEGRAS);
                tablero[0][7] = new Torre(Color.NEGRAS);
                
                tablero[1][0] = new Peon(Color.NEGRAS);
                tablero[1][1] = new Peon(Color.NEGRAS);
                tablero[1][2] = new Peon(Color.NEGRAS);
                tablero[1][3] = new Peon(Color.NEGRAS);
                tablero[1][4] = new Peon(Color.NEGRAS);
                tablero[1][5] = new Peon(Color.NEGRAS);
                tablero[1][6] = new Peon(Color.NEGRAS);
                tablero[1][7] = new Peon(Color.NEGRAS);
                
                
                tablero[6][0] = new Peon(Color.BLANCAS);
                tablero[6][1] = new Peon(Color.BLANCAS);
                tablero[6][2] = new Peon(Color.BLANCAS);
                tablero[6][3] = new Peon(Color.BLANCAS);
                tablero[6][4] = new Peon(Color.BLANCAS);
                tablero[6][5] = new Peon(Color.BLANCAS);
                tablero[6][6] = new Peon(Color.BLANCAS);
                tablero[6][7] = new Peon(Color.BLANCAS);
                
                tablero[7][0] = new Torre(Color.BLANCAS);
                tablero[7][1] = new Caballo(Color.BLANCAS);
                tablero[7][2] = new Alfil(Color.BLANCAS);
                tablero[7][3] = new Reina(Color.BLANCAS);
                tablero[7][4] = new Rey(Color.BLANCAS);
		tablero[7][5] = new Alfil(Color.BLANCAS);
                tablero[7][6] = new Caballo(Color.BLANCAS);
                tablero[7][7] = new Torre(Color.BLANCAS);
                
                
                return tablero;
	}
        
        public boolean comprobarAcenso(int y , int x) {
            return this.tablero[y][x].puedeAscender(y, x, this);
        }
        
        public Pieza[][] hacerJugada(int y, int x) {
            boolean[][] movimientosValidos = new boolean[8][8];
            movimientosValidos = tablero[casillaAnterior[0]][casillaAnterior[1]].movimientosValidos(casillaAnterior[0], casillaAnterior[1], this);
            
            if(movimientosValidos[y][x] == true) {
                if(tablero[y][x] != null) {piezaACementerio(tablero[y][x]);
            }
                
                tablero[y][x] = tablero[casillaAnterior[0]][casillaAnterior[1]];
                tablero[casillaAnterior[0]][casillaAnterior[1]] = null;

            }
            return tablero;
        }
        
        public Pieza[][] ascenderPieza(String piezaElegida) {
            Pieza pieza = null;
            switch(piezaElegida) {
                case "Reina":
                    pieza = new Reina(this.tablero[casillaAnterior[0]][casillaAnterior[1]].getColor());
                    break;
                    
                case "Caballo":
                    pieza = new Caballo(this.tablero[casillaAnterior[0]][casillaAnterior[1]].getColor());
                    break;
                
                case "Alfil":
                    pieza = new Alfil(this.tablero[casillaAnterior[0]][casillaAnterior[1]].getColor());
                    break;
                    
                case "Torre":
                    pieza = new Torre(this.tablero[casillaAnterior[0]][casillaAnterior[1]].getColor());
                    break;      
            }
            
            this.tablero[casillaAnterior[0]][casillaAnterior[1]] = pieza;
            
            return this.tablero;
        }
        
	public void piezaACementerio(Pieza piezaMuerta) {cementerio.add(piezaMuerta);}    
}