/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author user
 */
public class Search {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Busqueda b1 = new Busqueda();
        b1.wordList();
        b1.readWord();        
        b1.searchWord();
        OrdenAlfabetico orden= new OrdenAlfabetico();
        orden.listaOrdenada(b1.getTextWordList());
        orden.muestraLista();
    }
    
}
