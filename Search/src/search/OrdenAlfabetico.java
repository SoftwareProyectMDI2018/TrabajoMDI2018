
/*
*Autor: juan
*Fecha: 27-5-2018
*Ultima modificacion: 12-6-2018
*Propósito: Ordenar una lista de elementos(objetos) Strings
*/
public class OrdenAlfabetico {
    //Variables instanciadas
    private String[] arreglo1;
    private String[] arreglo2;
    //Constructor
    public OrdenAlfabetico(String[] arreglo1, String[] arreglo2) {
      //El objeto se inicializará sólo si los arreglos son del mismo tamaño
      if(arreglo1.length == arreglo2.length)
          this.arreglo1 = arreglo1;
          this.arreglo2 = arreglo2;
    }
    //Métodos get && set
    public String[] getArreglo1() {
        return arreglo1;
    }

    public void setArreglo1(String[] arreglo1) {
        this.arreglo1 = arreglo1;
    }

    public String[] getArreglo2() {
        return arreglo2;
    }

    public void setArreglo2(String[] arreglo2) {
        this.arreglo2 = arreglo2;
    }

    //método que toma los elementos de un arreglo y los ordena en un arreglo nuevo
    //Teniendo en cuenta el estandar de ascii
    public void listaOrdenada(String[] arreglo1, String[] arreglo2){
      if(arreglo1.length == arreglo2.length)
      {
        int k = 0;
        int condicionDeControl = 0; //variable que controla la condición
        for(int i = 0; i <= 127; i++)
        {
            for(int j = 0; j < arreglo1.length; j++)
            {
                if(((int)arreglo1[j].toUpperCase().charAt(k)) == i){ //Condición clave
                    arreglo2[k + condicionDeControl] =  arreglo1[j];
                    condicionDeControl++; //Incremento
                }//fin condición si
            }//fin segundo for
        }//fin primer for
      }//fin del if
      else//sino
      {
        System.out.println("El tamaño de ambos arreglos no coincide");//Se imprime un mensaje de error al usuario
        System.out.println("No puede ejecutar este método."); //Mensaje a Usuario
      }
    }//fin método orderedList
    //Método displayList que muestra la lista
    public void muestraLista(String[]arreglo)
    {
        for(int i = 0; i < arreglo.length; i++)
        {
            System.out.println(arreglo[i]);
        }
    }//fin del método displaysList
}//fin de la clase OrdenAlfabetico
