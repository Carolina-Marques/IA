/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package agent;

/**
 *
 * @author mcaro
 */
public class Posicao {
    private int linha;
    private int coluna;
    
    public Posicao(int linha, int coluna) {
        this.linha = linha;
        this.coluna = coluna;
    }

    @Override
    public String toString() {
        return "Posicao{" + "linha=" + linha + ", coluna=" + coluna + '}';
    }
    
}
