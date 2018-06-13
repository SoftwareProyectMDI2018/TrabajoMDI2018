/*
* Autor: Juan
* Fecha: 12 - 6 - 2018
* Ultima Modificacion: 12 - 6 - 2018
* Proposito: Expresar el estado de animo(predominante) que puede mostrar el texto
*/
public class EstadosDelTexto
{
    //Método que determina (o al menos pretende hacerlo) el estado de animo que representa el texto
    public static void estadoEmocionalDelTexto(String[] textoOriginal)
    {
      String[] tristeza = LecturaArchivo.lecturaArreglo("EstadoTristeza.txt");//leemos ,guardamos en array y lo usamos para inicializar tristeza
      String[] entusiasmo = LecturaArchivo.lecturaArreglo("EstadoEntusiasmo.txt");//leemos ,guardamos en array y lo usamos para inicializar Entusiasmo
      String[] euforia = LecturaArchivo.lecturaArreglo("EstadoEuforia.txt");//leemos ,guardamos en array y lo usamos para inicializar Euforia

      int contadorTristeza = 0, contadorEntusiasmo = 0, contadorEuforia = 0; //contadores de cada uno de los estados(inicializados en cero)

      //comparamos arreglo original c/cada arreglo que hacen referencia a los estados.Contamos ocurrencias
      for(int i = 0; i < textoOriginal.length; i++)
      {//bucle principal
        for(int k = 0; k < tristeza.length; k++) //recorrido tristeza y comparamos con elemento i de archivoOriginal
        {
          if((textoOriginal[i].toLowerCase()).equals(tristeza[k])) //si elemento i de archiv.Orig es igual a elem k tristeza
          {
              contadorTristeza++; //increm. se cuentan ocurrencias trist.
              System.out.println(tristeza[k]);//!CUIDADO LINEA HUÉRFANA!
          }
        }

        for(int h = 0; h < entusiasmo.length; h++)//recorrido entusiasmo y comparamos con elemento i de archivoOriginal
        {
          if((textoOriginal[i].toLowerCase()).equals(entusiasmo[h])) //si elemento i de archiv.Orig es igual a elem h entusiasmo
          {
            contadorEntusiasmo++; //increm. se cuentan ocurrencias entusiasmo
            System.out.println(entusiasmo[h]);//!CUIDADO LINEA HUÉRFANA!
          }
        }

        for(int l = 0; l < euforia.length; l++)//recorrido euforia y comparamos con elemento i de archivoOriginal
        {
          if((textoOriginal[i].toLowerCase()).equals(euforia[l]))//si elemento i de archiv.Orig es igual a elem l euforia
          {
            contadorEuforia++; //increm. se cuentan ocurrencias eufóricas
            System.out.println(euforia[l]);//!CUIDADO LINEA HUÉRFANA!
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
        System.out.println("\nEl texto expresa un estado de animo eufórico");// mensaje
        System.out.println(contadorEuforia + " ocurrencias..."); //HUERFANA!!!
      }else if(contadorEntusiasmo > contadorEuforia && contadorEntusiasmo > contadorTristeza) //Si predomina el entusiasmo
        {
          System.out.println("\nEl texto expresa un estado de entusiasmo");//mensaje
          System.out.println(contadorEntusiasmo + " ocurrencias...");//HUERFANA!!!
        }else if(contadorTristeza > contadorEuforia && contadorTristeza > contadorEntusiasmo)//Si predomina la tristeza
        {
          System.out.println("\nEl texto expresa un estado de tristeza"); //mensaje
          System.out.println(contadorTristeza + " ocurrencias..."); //HUERFANA!!!
        }else{
          System.out.println("\nNo puede dererminarse el estado del texto"); //En caso de no predominar un estado
        }
      }//fin del método estadoEmocionalDelTexto
}//fin de la clase EstadosDelTexto
