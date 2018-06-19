package search;/*
*Autor: Juan
*Fecha: 12 - 6 - 2018
*Ultima Modificacion: 13 -6 2018
*Proposito: Leer archivos txt y pasarlos a un arreglo
*/
import java.io.File; //la clase usa File
import java.io.FileNotFoundException;; //la clase
import java.util.Scanner; //la clase usa Scanner
public class LecturaArchivo
{
  //método que lee el arreglo.Recibe el archivo como parámetro
  public static String[] lecturaArreglo(String archivo)
  {
    int contador = 0; //contador para la cantidad de elementos del arreglo(archivo)
    try
    {
      Scanner cadena = new Scanner(new File(archivo));//necesario para leer el archivo
      while(cadena.hasNextLine())
      {
        contador++; //contamos las lineas
        cadena.next(); //movimiento a la proxima línea
      }
      String[] palabras = new String[contador]; //arreglo palabras con tamaño del valor del contador
      Scanner cadena2 = new Scanner(new File(archivo)); //necesario para leer el archivo

      //No se usa while ya que se sabe cuantas líneas existen. Recorrido de lectura
      for(int i = 0; i < contador; i++){ //encabezado del for
        palabras[i] = cadena2.next(); //se asume de que existe una palabra por linea
      }//fin del for
      return palabras; //retornamos arreglo
    }
    catch(FileNotFoundException e){ //lanzamos exception en caso de que exista
    }
    return null; //retornamos null
  }
  //método que muestra el archivo.txt en un arreglo.(Creado para fines de prueba)
  private static void muestraArchivo(){
    String[] palabras = lecturaArreglo("EstadoEntusiasmo.txt"); //le pasamos path  del archivo o el nombre si esta en la carpeta del proyecto
    System.out.println(); //salto
    //mostramos el arreglo
    for(int i = 0; i < palabras.length; i++)
    {
      System.out.println(palabras[i]);
    }
    System.out.println();
    String[] palabras2 = lecturaArreglo("EstadoTristeza.txt");
    System.out.println(); //salto
    //mostramos el arreglo
    for(int i = 0; i < palabras2.length; i++)
    {
      System.out.println(palabras2[i]);
    }
  }
}//fin de la clase LecturaArchivo
