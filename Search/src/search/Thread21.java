/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;

/**
 *
 * @author user
 */
//public class Thread2 {
class Thread21 implements Runnable {

    private Thread t;
    //private Thread t2;
    private String threadName;
    private boolean flagA = false;
    private boolean flagB = false;
    protected static volatile boolean flagFinded/*=false*/;
    protected Busqueda bq;

    public Thread21() {
        this.bq= new Busqueda();
        this.flagFinded=false;
        
    }

    public Thread21(String name) {
        threadName = name;
        System.out.println("Creating " + threadName);
    }

    public static boolean isFlagFinded() {
        return flagFinded;
    }

    public static void setFlagFinded(boolean flagFinded) {
        Thread21.flagFinded = flagFinded;
    }

    public Busqueda getBq() {
        return bq;
    }

    public void setBq(Busqueda bq) {
        this.bq = bq;
    }

    public boolean isFlagA() {
        return flagA;
    }

    public void setFlagA(boolean flagA) {
        this.flagA = flagA;
    }

    public boolean isFlagB() {
        return flagB;
    }

    public void setFlagB(boolean flagB) {
        this.flagB = flagB;
    }

    public void run() {
        System.out.println("Running " + threadName);
        //flagFinded=false;
        try {
            System.out.println("bq.p1: "+bq.getP1());
           // System.out.println(">>>"+bq.getTextWordList().get(bq.getIi()-1));
            if (flagA == true) {
                
                for (int i =  bq.getP1(); i > 0; i--) {
                     //System.out.println("****PALABRA****: "+bq.getWordList().get(i)+ threadName + ", " + i);

                   // System.out.println("Thread FlagA: " + threadName + ", " + i);
                    if (bq.getTextWordList().get((bq.getContador()-1)).equals(bq.getWordList().get(i))) {

                        System.err.println("Palabra Encontrada!!!>>FlagA>>>>" + bq.getWordList().get(i));
                       // i=1;
                        flagFinded=true;
                    } else if(i==1 && flagFinded==false){
                        System.err.println("NO ENCONTRADA##############################");
                        flagFinded=true;
                        //System.out.println("Palabra No Encontrada:( FlagA");
                    }
                    
                    if(flagFinded==true){
                        //System.err.println("Palabra Encontrada!!!>>FlagA>>>>" + bq.getWordList().get(i));
                        i=1;
                        //t.interrupt();
                        //t.join();
                        //t=null;
                        //flagFinded=false;
                        
                        
                    }
                    //bq.getWordList().get(i2);

                    // Let the thread sleep for a while.
                    Thread.sleep(0);
                }
            }
            if (flagB == true) {
                for (int i2 =  bq.getP1(); i2 < (bq.wordList.size()-1); i2++) {
                    //System.out.println("Thread FlagB: " + threadName + ", " + i2);
                    // System.out.println("****PALABRA****: "+bq.getWordList().get(i2)+ threadName + ", " + i2);

                    if (bq.getTextWordList().get((bq.getContador()-1)).equals(bq.getWordList().get(i2))) {
                                               System.err.println("Palabra Encontrada!!!>>FlagB" + bq.getWordList().get(i2)+"-----FLAG--"+flagFinded);
                        
                        //i2=bq.wordList.size();
                        flagFinded=true;

                        

                    } else if(i2==((bq.wordList.size()-1)-1) && flagFinded==false){
                        System.err.println("NO ENCONTRADA##############################");
                        flagFinded=true;

                        //System.out.println("Palabra No Encontrada:( FlagB");
                    }
                    if(flagFinded==true){
                       //System.err.println("Palabra Encontrada!!!>>FlagB" + bq.getWordList().get(i2)+"-----FLAG--"+flagFinded);
                        i2=(bq.wordList.size()-1)-1;
                        System.err.println("ERROR");
                        System.out.println("FLAG:"+flagFinded);
                        //t.interrupt();//Antes era "t"
                        //t.join();
                        //t=null;
                        //flagFinded=false;
                    }

                    //bq.getWordList().get(i2);
                    // Let the thread sleep for a while.
                    Thread.sleep(0);
                }

            }
        } catch (InterruptedException e) {
            System.out.println("Thread " + threadName + " interrupted.");
        }
        
        System.out.println("Thread " + threadName + " exiting.");
        //flagFinded=true;
    }

    public void start() {
        t=null;
        System.out.println("bq.p1: "+bq.getP1());
        System.out.println("Starting " + threadName);
        
        if (t == null) {
            System.out.println("T==NUL********************");
            flagFinded=false;
            t = new Thread(this, threadName);
            t.start();

            t.setPriority(1);
            //t.getPriority();
            System.out.println("Priority: " + t.getPriority());
        }
    }
}
    
//}
