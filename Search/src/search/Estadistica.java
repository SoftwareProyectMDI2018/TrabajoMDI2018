/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Iterator;

/**
 *
 * @author user
 */
public class Estadistica {
   ArrayList <Letra> letras= new ArrayList();
   
   public void cargaArrayAbc(){
   String abecedario= "abcdefghijklmñopqrstuvwxyz";
   char [] abechar= abecedario.toCharArray();
       for (int i = 0; i <abechar.length; i++) {
   Letra le = new Letra(abechar[i],0);
   this.letras.add(le);
       }
   }
    // Clase contiene calculos estadisticos para aplicar en un ArrayList.
    // Los objetivos de esta clase es aportar los metodos necesarios para:
    //  1). Obtener el numero de repeticiones de cada letra(frecuencias).
    //  2). Obtener la letra que se encuentra en el medio del texto(mediana).
    //  3). Obtener un promedio de utilizacion de cada letra.
    public String lectorTexto(String ubicacion){
        File file=new File(ubicacion);
        FileReader fileR = null;
        BufferedReader br= null;
        String texto="";
        try{
            fileR=new FileReader(file);
            br=new BufferedReader(fileR);
            String linea;
            
            while ((linea=br.readLine())!=null) {
                texto= texto+br.readLine();
            }
            br.close();
        }catch(Exception e){}
      
        return texto;
        
    }
    
    public String letraMediana(String ubicacion){
        String mediana="";
        //Leer Texto
        String texto=lectorTexto(ubicacion);
        //Quitar espacios y caracteres especiales(.,;!¡¿?')
        String textoPuro=texto.replaceAll("[^\\dA-Za-z]", "");
        //Determinar largo.
        int largo=textoPuro.length();
        //Buscar mediana
            mediana=""+textoPuro.charAt(largo/2);
        //Retorna
        return mediana;
    }
    
    public void desintegraPalabra(ArrayList<String> palabras,ArrayList<Letra>letras){
        int contador=0;
        for (int x = 0; x < palabras.size(); x++) {
        char[] achar=new char[palabras.get(x).length()];
        achar=palabras.get(x).toCharArray();
        for (int i = 0; i < achar.length; i++) {
            for (int j = 0; j < this.letras.size(); j++) {
                if (achar[i]==this.letras.get(j).getLetra()) {
                    this.letras.get(j).setFrecuencia(this.letras.get(j).getFrecuencia()+1);
                }
            }
        }
        }
    }// este metodo debe ubicarase dentro de un bucle
    
    
    public void muestraLetras(){
        for(int i=0; i<this.letras.size();i++){
        System.out.println("-"+this.letras.get(i).getLetra()+"--> "+this.letras.get(i).getFrecuencia());  
        }
    }
    
    public void vacio(){
        String commit;
    }
}
