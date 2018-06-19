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
        Estadistica es = new Estadistica();
        
        b1.wordList();
        b1.readWord();        
        b1.searchWord();
        es.setBsq(b1);
        es.cargaArrayAbc();
       
        es.desintegraPalabra(b1,es.letras);
         System.out.println("\n\n      Incidencia de letras:  \n");
        es.muestraLetras();
        float[] proms = es.promedios(b1);
        
        es.soutPromedios(proms);
       // System.out.println("Mediana: "+es.letraMediana(b1.getTextWordList()));
        System.out.println("#############");
        //es.desintegraPalabra(b1);
        es.muestraLetras();
        System.out.println("#############");
        OrdenAlfabetico orden= new OrdenAlfabetico();
        orden.setBusqueda(b1);
        orden.listaOrdenada(b1);
        orden.muestraLista();
        
    }
    
}
