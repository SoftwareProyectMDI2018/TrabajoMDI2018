/**
 * Author: Juan
 * Date: 27-5-2018
 * Last Modification: 27-5-2018
 * Purpose: The class should take a List of Strings and ordered this one
 *
 */
public class Alphabetical {

    //instance variables
    private String[] array1;
    private String[] array2;

    //Constructor
    public Alphabetical(String[] array1, String[] array2) {
        this.array1 = array1;
        this.array2 = array2;
    }
    //methods get && set
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


    public static void orderedList(String[] array1, String[] array2){
        int k = 0;
        int conditionControl = 0; //variable that controls the condition
        for(int i = 0; i <= 127; i++)
        {
            for(int j = 0; j < array1.length; j++)
            {
                if(((int)array1[j].toUpperCase().charAt(k)) == i){ //key condition
                    array2[k + conditionControl] =  array1[j];
                    conditionControl++; //increment
                }//end if condition
            }//end 2nd for
        }//end ft for
    }//end method orderedList

    //Method displayList that displays the Ordered List
    public static void displaysList(String[]array)
    {
        for(int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
    }//end method displaysList
}//end class Alphabetical
