/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author Enzo
 */
public class Letra {
    public char letra;
    public int frecuencia;

    public Letra(char letra, int frecuencia) {
        this.letra = letra;
        this.frecuencia = 0;
    }

    public char getLetra() {
        return letra;
    }

    public void setLetra(char letra) {
        this.letra = letra;
    }

    public int getFrecuencia() {
        return frecuencia;
    }

    public void setFrecuencia(int frecuencia) {
        this.frecuencia = frecuencia;
    }
        
    
}
