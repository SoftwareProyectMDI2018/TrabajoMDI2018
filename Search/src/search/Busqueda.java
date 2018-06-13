/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.InputStreamReader;
import java.text.Normalizer;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author user
 */
public class Busqueda {

    protected List<String> wordList = new ArrayList();
    private List<String> linea = new ArrayList();
    protected List<String> textWordList = new ArrayList();
    private String word = "";
    private int floor = 0;
    protected int p1 = 0;
    private Thread21 t21;
    private Thread21 t21_2;
    protected int ii = 0;
    protected int contador;
    protected int a = 0;//si algo no funciona esta variable antes no estaba protegida.
    protected int ceiling;
    protected boolean flagFirstTime_1;
    protected boolean flagFirstTime_2;

    public Busqueda() {

        this.t21 = new Thread21("Thread-1");
        t21.setBq(this);
        this.t21_2 = new Thread21("Thread-2");
        t21_2.setBq(this);
        this.contador = 0;
        this.ceiling = 0;
        flagFirstTime_1 = false;
        flagFirstTime_2 = false;
    }

    public int getContador() {
        return contador;
    }

    public void setContador(int contador) {
        this.contador = contador;
    }

    public Thread21 getT21() {
        return t21;
    }

    public void setT21(Thread21 t21) {
        this.t21 = t21;
    }

    public Thread21 getT21_2() {
        return t21_2;
    }

    public void setT21_2(Thread21 t21_2) {
        this.t21_2 = t21_2;
    }

    public int getIi() {
        return ii;
    }

    public void setIi(int ii) {
        this.ii = ii;
    }

    public int getP1() {
        return p1;
    }

    public void setP1(int p1) {
        this.p1 = p1;
    }

    public List<String> getTextWordList() {
        return textWordList;
    }

    public void setTextWordList(List<String> textWordList) {
        this.textWordList = textWordList;
    }

    public List<String> getWordList() {
        return wordList;
    }

    public void setWordList(List<String> wordList) {
        this.wordList = wordList;
    }

    public List<String> getLinea() {
        return linea;
    }

    public void setLinea(List<String> linea) {
        this.linea = linea;
    }

    //Llena un arreglo con las palabras del listado. Diccionario.
    public void wordList() {

        try {
            FileInputStream fstream = new FileInputStream("/home/user/Git/Metodologia/SEARCH/TrabajoMDI2018/Search/listado-general.txt");
            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {

                wordList.add(strLine.toLowerCase().trim());
                // System.out.println("Dictionary: "+strLine+"<<");

            }

        } catch (Exception e) {
        }

    }

//Método que tiene como función leer y filtrar todas las palabras de un archivo de texto y llenar un arreglo.
//No lee caracteres especiales. 
//Solamente lee letras.
    public void readWord() {

        try {

            FileInputStream fstream = new FileInputStream(/*"/home/user/University/UTN_Programación/Tareas"*/"/home/user/Prueba");

            DataInputStream in = new DataInputStream(fstream);
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String strLine;

            while ((strLine = br.readLine()) != null) {

                //if(  Character.isLetter((strLine = br.readLine()) != null))){}
                linea.add(strLine.toLowerCase());

            }

            for (int i = 0; i < linea.size(); i++) {

                for (int j = 0; j < linea.get(i).length(); j++) {

                    if (Character.isLetter(linea.get(i).charAt(j)) && (linea.get(i).charAt(j) != ' ') /*|| (!Character.isLetter(linea.get(ii).charAt(j)))*/) {

                        word += linea.get(i).charAt(j);

                    }

                    if (/*word != null && */(linea.get(i).charAt(j) == ' ' || (j == (linea.get(i).length() - 1))) /*|| (linea.get(ii).charAt(j) == '.')*/ || (!Character.isLetter(linea.get(i).charAt(j)))) {

                        if (word != "") {
                            //System.out.println("WORD:  >>>"+word);
                            textWordList.add(word);
                            word = "";
                        }

                    }
                    //System.out.println(">>" + linea.get(ii).trim().charAt(j));

                }
            }
            //Close the input stream
            in.close();
        } catch (Exception e) {//Catch exception if any
            System.err.println("Error: " + e.getMessage());
        }

    }

    public String cleanString(String texto) {
        /* switch (texto.charAt(0)) {
            case 'á':
                texto.replace('á', 'a').charAt(0);
                break;

            case 'à':
                texto.replace('à', 'a').charAt(0);
                break;

            case 'ä':
                texto.replace('ä', 'a').charAt(0);
                break;

            case 'é':
                texto.replace('é', 'e').charAt(0);
                break;

            case 'è':
                texto.replace('è', 'e').charAt(0);
                break;

            case 'ë':
                texto.replace('ë', 'e').charAt(0);
                break;

            case 'í':
                texto.replace('í', 'i').charAt(0);
                break;

            case 'ì':
                texto.replace('ì', 'i').charAt(0);
                break;

            case 'ï':
                texto.replace('ï', 'i').charAt(0);
                break;

            case 'ó':
                texto.replace('ó', 'o').charAt(0);
                break;

            case 'ò':
                texto.replace('ò', 'o').charAt(0);
                break;

            case 'ö':
                texto.replace('ö', 'o').charAt(0);
                break;

            case 'ú':
                texto.replace('ú', 'u').charAt(0);
                break;

            case 'ù':
                texto.replace('ù', 'u').charAt(0);
                break;

            case 'ä':
                texto.replace('ä', 'a').charAt(0);
                break;

        }*/
        texto = Normalizer.normalize(texto, Normalizer.Form.NFD);
        texto = texto.replaceAll("[\\p{InCombiningDiacriticalMarks}]", "");
        return texto;
    }

    public void searchWord() {
        boolean flag1 = false;//For first half. It means that that word is in the first half of the array.
        boolean flag2 = false;//For second half.
        boolean flag3 = false;
        boolean half1 = false;
        boolean half2 = false;
        /*int*/ //p1 = (wordList.size()) / 2;
        int len2 = (wordList.size() + 1) / 2;
        int p2 = 0;

        /*System.out.println("Pointer2: " + ((wordList.size()) - p1));
        System.out.println("Pointer1: " + p1);
        System.out.println("Size half: " + (wordList.size()) / 2);
        System.out.println("Size - : " + (wordList.size() - (wordList.size() / 2)));
        System.out.println("Size" + (wordList.size()));
        System.out.println("Size: " + wordList.get((wordList.size()) / 2));
        System.out.println("Size: " + wordList.get(p1));
        System.out.println("Size Text: " + textWordList.size());*/
        for (ii = 0; ii < textWordList.size(); ii++) {
            System.out.println("Pointer1: " + p1);
            p1 = (wordList.size()) / 2;
            ceiling = 0;
            p2 = 0;
            floor = 0;
            flagFirstTime_1 = false;
            flagFirstTime_2 = false;
            half1 = false;
            half2 = false;
            Thread21.flagFinded = false;
            System.out.println("FLAG!!!!!!!!!!!!!!!!!!!!" + Thread21.flagFinded);
            contador++;
            System.out.println("ii: " + ii);
            System.out.println("WORD: " + textWordList.get(ii));
            // System.out.println("I: "+ii);

            for (int j = 0; j < wordList.size(); j++) {
                System.out.println("POINTER--1: " + p1);

                if ((cleanString(textWordList.get(ii)).charAt(0) < (cleanString(wordList.get(p1)).charAt(0)))) {
                    flag1 = true;
                    flagFirstTime_1 = true;
                    //System.out.println("Yess");

                } else if ((cleanString(textWordList.get(ii)).charAt(0) > (cleanString(wordList.get(p1)).charAt(0)))) {
                    flag2 = true;
                    //flag3 = true;
                    flagFirstTime_2 = true;
                    //System.out.println("NOs");
                } else if ((cleanString(textWordList.get(ii)).charAt(0) == (cleanString(wordList.get(p1)).charAt(0)))) {

                    System.out.println("Encontrada!!");
                    System.out.println("p1: " + p1);
                    System.out.println("Palabra: " + wordList.get(p1));
                    //j = wordList.size();
                    t21.setFlagA(true);
                    t21.start();

                    t21_2.setFlagB(true);
                    t21_2.start();
                    System.out.println(Thread21.flagFinded);
                    while (Thread21.flagFinded == false) {
                    };

                    System.out.println(Thread21.flagFinded);
                    System.out.println("RUNNNNNNNNNNNN");
                    flag1 = false;
                    flag2 = false;
                    j = wordList.size();

                }
//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>Sección búsqueda en primera mitad.<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<

                if (flagFirstTime_1 == true && flagFirstTime_2 == false) {
                    flag1 = false;
                    half1 = true;

                    p2 = 0;
                    if (p1 % 2 == 0) {

                        p2 = p1 / 2;
                        ceiling = p1;
                        p1 = p2;
                        System.out.println("FLAG FIRST TIME>>>>>>>>>>>>><#######>>>>>>>>");

                    }

                    if (p1 % 2 != 0) {

                        p2 = (p1 + 1) / 2;
                        ceiling = p1;
                        p1 = p2;
                        System.out.println("FLAG FIRST TIME !=0>>>>>>>>##########>>>>>!!!!!!!!!!!!!!!!!!!");

                    }

                }
                if (flagFirstTime_1 == true && flag2 == true && half1 == true) {
                    

                    //ceiling =p1
                    p2 = 0;
                    //p2 = (ceiling - p1);
                    flag1 = false;
                    flag2 = false;

                    if (((ceiling - p1) % 2 == 0)) {
                        floor = p1;
                        p2 = ((ceiling - p1) / 2) + floor;
                        ceiling = ceiling;
                        //floor = p1;
                        p1 = p2;

                    }

                    if (((ceiling - p1) % 2 != 0)) {
                        floor = p1;
                        p2 = ((p2 + 1) / 2) + floor;
                        ceiling = ceiling;
                        //floor = p1;
                        p1 = p2;

                    }

                }

                if (flag1 == true && half1 == true) {
                    

                    p2 = 0;
                    flag1 = false;
                    flag2 = false;
                    
                    if (((p1 - floor) % 2 == 0)) {
                        //System.out.println(">>>>>>>>>>><FLAG2_1");

                        p2 = (p1 - floor) / 2;//p2 / 2;
                        ceiling = p1;
                        p1 = p2 + floor;
                    //    System.out.println("P1: " + p1);

                    }
                    
                     if (((p1 - floor) % 2 != 0)) {
                        //System.out.println(">>>>>>>>>>>>>>FLAG2_2");

                        p2 = (p2 + 1) / 2;
                        ceiling = p1;
                        p1 = p2 + floor;

                    }
                    
                    

                }

//++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++++
//>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>> Sección búsqueda en segunda mitad. <<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<<
                if (flag1 == true && half2 == true) {//Esto corresponde con menor.
                    p2 = 0;
                    //p2 = (p1 - floor);
                    flag2 = false;
                    flag1 = false;

                    if (((p1 - floor) % 2 == 0)) {
                        System.out.println(">>>>>>>>>>><FLAG2_1");

                        p2 = (p1 - floor) / 2;//p2 / 2;
                        ceiling = p1;
                        p1 = p2 + floor;
                        System.out.println("P1: " + p1);

                    }

                    if (((p1 - floor) % 2 != 0)) {
                        System.out.println(">>>>>>>>>>>>>>FLAG2_2");

                        p2 = (p2 + 1) / 2;
                        ceiling = p1;
                        p1 = p2 + floor;

                    }

                }
                if (flagFirstTime_2 == true && half2 == true && flag2 == true && flagFirstTime_1==true) {
                    //flag3=false;Esta variable booleana parece ser que no se usa.
                    //ceiling =p1
                    p2 = 0;
                    //p2 = (ceiling - p1);
                    flag1 = false;
                    flag2 = false;

                    if (((ceiling - p1) % 2 == 0)) {

                        p2 = ((ceiling - p1) / 2) + floor;
                        ceiling = ceiling;
                        floor = p1;
                        p1 = p2;

                    }

                    if (((ceiling - p1) % 2 != 0)) {

                        p2 = ((p2 + 1) / 2) + floor;
                        ceiling = ceiling;
                        floor = p1;
                        p1 = p2;

                    }

                }

                if (flagFirstTime_2 == true && flagFirstTime_1 == false && half1==false) {//Este corresponde con mayor hasta el final
                    half2 = true;
                    p2 = 0;
                    p2 = ((wordList.size()) - p1);
                    //flag2=false;

                    if ((((wordList.size()) - p1) % 2) == 0) {

                        p2 = p2 / 2;
                        p2 = p2 + p1;
                        floor = p1;
                        p1 = p2;
                        System.out.println("P2%2=0--OK!");

                    }

                    if ((((wordList.size()) - p1) % 2) != 0) {
                        p2 = 0;
                        p2 = (p2 + 1) / 2;
                        p2 = p2 + p1;
                        floor = p1;
                        p1 = p2;
                        System.out.println("P2%2!=0--OK!");

                    }

                }

            }
            //System.out.println("I: "+ii);
        }

    }

}
