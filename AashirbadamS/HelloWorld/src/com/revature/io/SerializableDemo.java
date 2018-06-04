package com.revature.io;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

public class SerializableDemo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		

	}
	
	public static void serializableObject(String filename, Object o) {
		try {
			//stream to write byte stream to a 
			FileOutputStream fileOut = new FileOutputStream(filename);
			//use objectoutputstream
			ObjectOutputStream out =new ObjectOutputStream(fileOut);
			
			//Actually send my object
			out.writeObject(0);
			out.close();
			fileOut.close();
		}catch (FileNotFoundException f) {
			f.printStackTrace();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
