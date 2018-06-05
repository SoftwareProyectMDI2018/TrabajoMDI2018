/*
Author: juan
Date: 27-5-2018
Last Modification: 27-5-2018
Program Purpose: Test the class AlphabeticalList and show
what this can do

*/

import java.util.Scanner;//El programa usa Scanner
public class AlphabeticalListTest {
    //Método main que comienza la ejecución de la aplicación
    public static void main(String[] args) {


        //declaración e inicialización
        String[]a = {"Going","to","memphis","right","now","zzz","gre0","1324","what","!34","-45"};
        String[]b = new String[a.length];

        //Creación de objeto Alphabetical para llamar a los
        //métodos desde el main
        Alphabetical a1 = new Alphabetical(a,b);

        a1.orderedList(a,b);
        a1.displaysList(b);

    }//fin del método main
}//fin de la clase AlphabeticalListTest
