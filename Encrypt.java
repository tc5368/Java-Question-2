import java.io.*;
import java.util.*;

public class Encrypt{

	public static void main(String [] args){

		if (args.length != 1){
			System.err.println("One argument expected!");
			System.exit(1);
		}
		
		String filename = args[0];
		try{
			FileInputStream fileIs = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fileIs);
			String readIn = is.readUTF();
			is.close();

			char[] characters = readIn.toCharArray();
			StringBuilder sb = new StringBuilder("");
			for(char i : characters){
				int newAscii = (int) i;
				if (i <=122  && i >=98){
					newAscii = i -1;
				}
				else if ((int) i == 97){
					newAscii = 122;
				}
				else{
					newAscii = i;
				}
				char outText = (char) newAscii;
				sb.append(outText);
				}
			System.out.println(sb);

		}catch(FileNotFoundException e){
			System.out.println("File not found");
		}catch(IOException e){
			System.out.println("IO error");
		}
	}
}
