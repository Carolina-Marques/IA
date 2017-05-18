package montacargas;

import agent.Action;
import agent.Peca;
import agent.Posicao;
import agent.State;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import utils.Direcao;

public class MontaCargasState extends State implements Cloneable {

    static final int[][] goalMatrix = {{0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 1},
                                       {0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0},
                                       {0, 0, 0, 0, 0, 0}};
    //static final int[] linesfinalMatrix = {0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 4, 4, 4, 4, 4, 4};
    //static final int[] colsfinalMatrix = {0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 0, 1, 2, 3, 4, 5, 0, 1, 2 ,3 ,4 ,5 ,0 , 1, 2 ,3 ,4 ,5 };
    public static final int SIZE = 5;
    private int[][] matrix;
    private int lineBlank;
    private int columnBlank;
    public int numberPieces=0;
    
    public MontaCargasState(int[][] matrix) {
        List<Peca> pecas = new ArrayList<Peca>();
        this.matrix = new int[matrix.length][matrix.length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                this.matrix[i][j] = matrix[i][j];
                if (this.matrix[i][j] <= 0 || this.matrix[i][j]>=10) {
                    lineBlank = i;
                    columnBlank = j;                   
                } else {
                    switch(matrix[i][j]){
                        case 1:
                            break;
                        case 2:
                            break;
                        case 3:
                            break;
                        case 4:
                            Peca p = new Peca(2,Direcao.HORIZONTAL,new Posicao(i,j));
                            if(isPecaValida(p,pecas)){
                                pecas.add(p);
                                System.out.println("ENTROU");
                            }
                            break;
                    }
                    //numberPieces++;
                }
                if(matrix[i][j] == matrix[2][5]){
                    
                }
            }
        }
        for(Peca peca: pecas){
            System.out.println(peca.toString());
        }
    }
    
    public boolean isPecaValida(Peca peca, List<Peca> lista) {
        //List<Peca> porAnalisar = new ArrayList<Peca>();
        //List<Peca> analisados = new ArrayList<Peca>();
        /*
        porAnalisar.add(peca);

        while (!porAnalisar.isEmpty()) {
            Peca aAnalisar = porAnalisar.remove(0);
            if (analisados.contains(aAnalisar)) {
                continue;
            }
            analisados.add(aAnalisar);
            porAnalisar.addAll(getAllPecas());
        }*/
        
        //porAnalisar.addAll(getAllPecas());
        for(Peca p: lista){
            if(lista.contains(peca))
                return true;
        }
        return false;
    }
    
    public void executeAction(Action action) {
        action.execute(this);
        firePuzzleChanged(null);
    }

    public boolean canMoveUp() {
        return lineBlank != 0;
    }

    public boolean canMoveRight() {
        return columnBlank != matrix.length - 1;
    }

    public boolean canMoveDown() {
        return lineBlank != matrix.length - 1;
    }

    public boolean canMoveLeft() {
        return columnBlank != 0;
    }

    /*
     * In the next four methods we don't verify if the actions are valid.
     * This is done in method executeActions in class EightPuzzleProblem.
     * Doing the verification in these methods would imply that a clone of the
     * state was created whether the operation could be executed or not.
     */
    public void moveUp() {
        matrix[lineBlank][columnBlank] = matrix[--lineBlank][columnBlank];
        matrix[lineBlank][columnBlank] = 0;
    }

    public void moveRight() {
        matrix[lineBlank][columnBlank] = matrix[lineBlank][++columnBlank];
        matrix[lineBlank][columnBlank] = 0;
    }

    public void moveDown() {
        matrix[lineBlank][columnBlank] = matrix[++lineBlank][columnBlank];
        matrix[lineBlank][columnBlank] = 0;
    }

    public void moveLeft() {
        matrix[lineBlank][columnBlank] = matrix[lineBlank][--columnBlank];
        matrix[lineBlank][columnBlank] = 0;
    }

    public int getNumLines() {
        return matrix.length;
    }

    public int getNumColumns() {
        return matrix[0].length;
    }

    public int getTileValue(int line, int column) {
        if (!isValidPosition(line, column)) {
            throw new IndexOutOfBoundsException("Invalid position!");
        }
        return matrix[line][column];
    }

    public boolean isValidPosition(int line, int column) {
        return line >= 0 && line < matrix.length && column >= 0 && column < matrix[0].length;
    }

    @Override
    public boolean equals(Object other) {
        if (!(other instanceof MontaCargasState)) {
            return false;
        }

        MontaCargasState o = (MontaCargasState) other;
        if (matrix.length != o.matrix.length) {
            return false;
        }

        return Arrays.deepEquals(matrix, o.matrix);
    }

    @Override
    public int hashCode() {
        return 97 * 7 + Arrays.deepHashCode(this.matrix);
    }

    @Override
    public String toString() {
        StringBuilder buffer = new StringBuilder();
        for (int i = 0; i < matrix.length; i++) {
            buffer.append('\n');
            for (int j = 0; j < matrix.length; j++) {
                buffer.append(matrix[i][j]);
                buffer.append(' ');
            }
        }
        return buffer.toString();
    }

    @Override
    public Object clone() {
        return new MontaCargasState(matrix);
    }
    //Listeners
    private transient ArrayList<MontaCargasListener> listeners = new ArrayList<MontaCargasListener>(3);

    public synchronized void removeListener(MontaCargasListener l) {
        if (listeners != null && listeners.contains(l)) {
            listeners.remove(l);
        }
    }

    public synchronized void addListener(MontaCargasListener l) {
        if (!listeners.contains(l)) {
            listeners.add(l);
        }
    }

    public void firePuzzleChanged(MontaCargasEvent pe) {
        for (MontaCargasListener listener : listeners) {
            listener.puzzleChanged(null);
        }
    }

    public List<Peca> getAllPecas() {
        List<Peca> pecas = new ArrayList<Peca>();
        for(Peca peca: pecas){
            pecas.add(peca);
        }
       return pecas;
    }
    
    public List<Posicao> verificarPosicoesPeca(Peca peca){
    List<Posicao> posicoes = new ArrayList<Posicao>();
    switch(peca.getNumPecas()){
            case 2:
                
                break;
        }
    return posicoes;
    }
    
}
