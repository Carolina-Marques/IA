/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

import java.util.Collection;
import utils.Direcao;

/**
 *
 * @author mcaro
 */
public class Peca {
    private int numPecas;
    private Direcao direcao;
    private Posicao pos;

    public int getNumPecas() {
        return numPecas;
    }

    public Direcao getDirecao() {
        return direcao;
    }

    public Posicao getPos() {
        return pos;
    }

    public Peca(int numPecas, Direcao direcao, Posicao pos) {
        this.numPecas = numPecas;
        this.direcao = direcao;
        this.pos = pos;
    }
    public int PecaType(Peca p){
        switch(p.getNumPecas()){
            case 2:
                
                break;
        }
        return 0;
    }
    @Override
    public String toString() {
        return "Peca{" + "numPecas=" + numPecas + ", direcao=" + direcao + ", pos=" + pos + '}';
    }
    
}
