/*
Author: juan
Date: 27-5-2018
Last Modification: 27-5-2018
Program Purpose: This class test the class Alphabetical.java showing their capabilities
*/
public class AlphabeticalTest {
    public static void main(String[] args) {

        //declaration and initialization
        String[]a = {"Going","to","memphis","right","now","zzz"};
        String[]b = new String[a.length];

        //Creation of Alphabetical object to call methods from main
        Alphabetical a1 = new Alphabetical(a,b);

        a1.orderedList(a,b);
        a1.displaysList(b);

    }//end method main

}//end class AlphabeticalListTest
