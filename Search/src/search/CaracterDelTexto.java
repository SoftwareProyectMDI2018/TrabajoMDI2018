/*
*Autor: Juan
*Propósito: Representar el caracter del texto que se pasó (formal o informal) ---inclinacion
*Fecha: 12 - 6 -2018
*Ultima Modificacion: 12 - 6 - 2018
*/
public class CaracterDelTexto
{
  public static void determinarCaracter(String[] archivoOriginal) //el metodo original es recibido como el parámetro
  {
    String[] informales = LecturaArchivo.lecturaArreglo("palabrasInformales.txt");//leemos,pasamos a arreglo y guardamos en informales
    String[] formales = LecturaArchivo.lecturaArreglo("palabrasFormales.txt");//leemos,pasamos a arreglo y guardamos en formales
    int contadorFormales = 0; //cuenta ocurrencias de informales
    int contadorInformales = 0;//cuenta ocurrencias de informales
    //comparamos elmentos de archivoOriginal con los del archivo
    for(int i = 0; i < archivoOriginal.length; i++)//itera hasta el tamaño del arreglo original
    {
      for(int k = 0; k < informales.length; k++ ) //bucle itera el tamaño del archivo1
      {
        if((archivoOriginal[i].toLowerCase()).equals(informales[k])){
          contadorInformales++;}
      }
      for(int h = 0; h < formales.length; h++) //bucle itera el tamaño del archivo1
      {
        if((archivoOriginal[i].toLowerCase()).equals(formales[h])){
          contadorFormales++;}
      }
    }//primer for
    if(contadorFormales > contadorInformales) //en caso de existir mas palabas tomadas como formales
    {
      System.out.println("\nEl texto es de caracter formal");
      System.out.println(contadorFormales + "ocurrencias...");
    } else if(contadorInformales > contadorFormales){ //en caso de que las ocurrencias de informales sea mayor..
      System.out.println("\nEl texto es de caracter informal");
      System.out.println(contadorInformales + " ocurrencias...");
    }else{
      System.out.println("\nNo puede determinarse el caracter del texto");
    }
  }//fin determinarEstado
}//fin de la clase CaracterDelTexto
