/**
Autor: juan
Fecha: 13-6-2018
Ultima modificacion: 13-6-2018
Proposito:
-Determinar el caracter del texto ya sea formal o informal
-Determinar el estado predominante del texto (tristeza,Entusiasmo,Euforia)
*/
public class Caracter_Y_Estado
{
  //Método que determina (o al menos pretende hacerlo) el estado de animo que representa el texto
  public static void estadoEmocionalDelTexto(String[] textoOriginal)
  {
    String[] tristeza = LecturaArchivo.lecturaArreglo("EstadoTristeza.txt");//leemos ,guardamos en array y lo usamos para inicializar tristeza
    String[] entusiasmo = LecturaArchivo.lecturaArreglo("EstadoEntusiasmo.txt");//leemos ,guardamos en array y lo usamos para inicializar Entusiasmo
    String[] euforia = LecturaArchivo.lecturaArreglo("EstadoEuforia.txt");//leemos ,guardamos en array y lo usamos para inicializar Euforia

    int contadorTristeza = 0, contadorEntusiasmo = 0, contadorEuforia = 0; //contadores de cada uno de los estados(inicializados en cero)
    if(textoOriginal[0] == null) //se asume que si el elmento 1 del textoOriginal es nulo
    {
      System.out.println("\nNo se puede determinar el estado.El texto esta incompleto."); //Mensaje a Usuario
    }
    else
    {
    //comparamos arreglo original c/cada arreglo que hacen referencia a los estados.Contamos ocurrencias
    for(int i = 0; i < textoOriginal.length; i++)
    {//bucle principal
      for(int k = 0; k < tristeza.length; k++) //recorrido tristeza y comparamos con elemento i de archivoOriginal
      {
        if((textoOriginal[i].toLowerCase()).equals(tristeza[k])) //si elemento i de archiv.Orig es igual a elem k tristeza
        {
            contadorTristeza++; //increm. se cuentan ocurrencias trist.
        }
      }

      for(int h = 0; h < entusiasmo.length; h++)//recorrido entusiasmo y comparamos con elemento i de archivoOriginal
      {
        if((textoOriginal[i].toLowerCase()).equals(entusiasmo[h])) //si elemento i de archiv.Orig es igual a elem h entusiasmo
        {
          contadorEntusiasmo++; //increm. se cuentan ocurrencias entusiasmo
        }
      }

      for(int l = 0; l < euforia.length; l++)//recorrido euforia y comparamos con elemento i de archivoOriginal
      {
        if((textoOriginal[i].toLowerCase()).equals(euforia[l]))//si elemento i de archiv.Orig es igual a elem l euforia
        {
          contadorEuforia++; //increm. se cuentan ocurrencias eufóricas
        }
      }
    }//bucle principal

    //validamos que se pueda calcular el entusiasmo
    if(contadorEuforia == 0 && contadorEntusiasmo == 0 && contadorTristeza == 0) //al no encontrar ocurrencias de estados
    {
      System.out.println("\nNo es posible expresar el estado del texto..."); //mensaje en ese caso
      //calculamos contador con mayor valor
    }else if(contadorEuforia > contadorEntusiasmo && contadorEuforia > contadorTristeza)  //Si predomina la euforia
      {
      System.out.println("\nEl texto expresa un estado de euforia");// mensaje
    }else if(contadorEntusiasmo > contadorEuforia && contadorEntusiasmo > contadorTristeza) //Si predomina el entusiasmo
      {
        System.out.println("\nEl texto expresa un estado de entusiasmo");//mensaje
      }else if(contadorTristeza > contadorEuforia && contadorTristeza > contadorEntusiasmo)//Si predomina la tristeza
      {
        System.out.println("\nEl texto expresa un estado de tristeza"); //mensaje
      }else{
        System.out.println("\nNo es posible expresar el estado del texto"); //En caso de no predominar un estado
      }
    }
    }//fin del método estadoEmocionalDelTexto


    public static void determinarCaracter(String[] archivoOriginal) //el archivo original es recibido como el parámetro
    {
      if(archivoOriginal[0] != null) //verificamos que archivoOriginal esté completo
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
        }else if(contadorInformales > contadorFormales){ //en caso de que las ocurrencias de informales sea mayor..
          System.out.println("\nEl texto es de caracter informal");
        }else{
          System.out.println("\nNo puede determinarse el caracter del texto");
      }
    }

    }//fin del metodo determinarCaracter
}//fin de clase Caracter_Y_Estado
