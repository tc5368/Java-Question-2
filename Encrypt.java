import java.io.*;
import java.util.*;

public class Encrypt{

	public static void main(String [] args){
		if (args.length != 1){
			System.err.println("One argument expected!");
			System.exit(1);
		}
	try{
		FileReader fr = new FileReader(args[0]);
		int i;
		int newAscii = 0;
		StringBuilder sb = new StringBuilder(""); 

		while((i =fr.read()) != -1){
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
	}
	catch(IOException e){
		System.out.println("No Such File");
	}
	}
}
