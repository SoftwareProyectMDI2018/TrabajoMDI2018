/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package search;
import java.io.File;
/**
 *
 * @author Enzo
 */
public class Enzo {
	
	public void lector(String ubicacion) {
		File archivo=null;
		FileReader fileReader=null;
		BufferedReader buffReader=null;
		String linea;
		try {
			archivo= new File(ubicacion);
			fileReader= new FileReader(archivo);
			buffReader= new BufferedReader(fileReader);
			
			while((linea=buffReader.readLine())!=null) {
				buffReader.readLine();
			}
			
			buffReader.close();
		}catch(Exception e) {}
	}
	
	public void letraMasRepetida() {

	}
	
    
}
