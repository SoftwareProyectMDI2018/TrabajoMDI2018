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
public class Enzo {
    public class Letras{
        public char letra;
        public int frecuencia;

        public Letras(char letra, int frecuencia) {
            this.letra = letra;
            this.frecuencia = 0;
        }
        
        //public static ArrayList<Letras>letras=new ArrayList<>();

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
   //public ArrayList <Letras> letras()= new ArrayList<>();
    // Clase contiene calculos estadisticos para aplicar en un ArrayList.
    // Los objetivos de esta clase es aportar los metodos necesarios para:
    //  1). Obtener el numero de repeticiones de cada letra(frecuencias).
    //  2). Obtener la letra que se encuentra en el medio del texto(mediana).
    
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
    
    public void desintegraPalabra(ArrayList<String> palabras,ArrayList<Letras>letras){
        char[] achar=new char[palabras.get(0).length()];
        achar=palabras.get(0).toCharArray();
        for (int i = 0; i < achar.length; i++) {
            for (int j = 0; j < letras.size(); j++) {
                if (achar[i]==letras.get(j).getLetra()) {
                    letras.get(j).setFrecuencia(letras.get(j).getFrecuencia()+1);
                }
            }
        }
    }// este metodo debe ubicarase dentro de un bucle
    
    public void leerArrayPalabras(ArrayList<String> palabras){
        Iterator<String> itpal = palabras.iterator();
        //Bucle
        while (itpal.hasNext()) {
            //desintegraPalabra(palabras, letras); //AGREGAR ARRAY DE LETRAS
            itpal.next();
        }
        
    }
    
    public void muestraLetras(ArrayList<Letras>letras){
        for(int i=0; i<letras.size();i++){
        System.out.println("-"+letras.get(i).getLetra()+"--> "+letras.get(i).getFrecuencia());  
        }
    }
    
    public void vacio(){
        String commit;
    }
}
