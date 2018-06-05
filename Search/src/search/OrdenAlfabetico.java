/**
 * Autor: Juan
 * Fecha: 27-5-2018
 * Última modificación: 3-6-2018
 * Propósito: La clase debe poseer un método que pueda
 tomar un arreglo de Strings,ordenarlo alfabeticamente
 (en otro arreglo) y posteriormente imprimirlo.
 */

public class Alphabetical {
    //Variables instanciadas
    private String[] array1;
    private String[] array2;
    //Constructor
    public Alphabetical(String[] array1, String[] array2) {
      //El objeto se inicializará sólo si los arreglos son del mismo tamaño
      if(array1.length == array2.length)
          this.array1 = array1;
          this.array2 = array2;
    }
    //Métodos get && set
    public String[] getArray1() {
        return array1;
    }

    public void setArray1(String[] array1) {
        this.array1 = array1;
    }

    public String[] getArray2() {
        return array2;
    }

    public void setArray2(String[] array2) {
        this.array2 = array2;
    }

    //método que toma los elementos de un arreglo y los ordena en un arreglo nuevo
    //Teniendo en cuenta el estandar de ascii
    public void orderedList(String[] array1, String[] array2){

      if(array1.length == array2.length)
      {

        int k = 0;
        int conditionControl = 0; //variable que controla la condición
        for(int i = 0; i <= 127; i++)
        {
            for(int j = 0; j < array1.length; j++)
            {
                if(((int)array1[j].toUpperCase().charAt(k)) == i){ //Condición clave
                    array2[k + conditionControl] =  array1[j];
                    conditionControl++; //Incremento
                }//fin condición si
            }//fin segundo for
        }//fin primer for
      }//fin del if
      else//sino
      {
        System.out.println("El tamaño de ambos arreglos no coincide");//Se imprime un mensaje de error al usuario
      }
    }//fin método orderedList

    //Método displayList que muestra la lista
    public void displaysList(String[]array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }//fin del método displaysList
}//fin de la clase Alphabetical
