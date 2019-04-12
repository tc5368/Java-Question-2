import java.io.*;
import java.util.*;	//Importint the need libraries

//Written by Tom Clare c1769261

public class Encrypt{

	public static void main(String [] args){

		if (args.length != 1){
			System.err.println("One argument expected!"); //Given code for ensuring the correct parameters are given
			System.exit(1);
		}
		
		String filename = args[0]; //assigns the parameter to a string variable named filename
		try{ //Sets up a try catch statment in case there are erros importing the file.
			FileInputStream fileIs = new FileInputStream(filename);
			ObjectInputStream is = new ObjectInputStream(fileIs); //Opens and sets up the binary file reader from the given file
			String readIn = is.readUTF();
			is.close();

			char[] characters = readIn.toCharArray(); //This converts the string input from the binary file into a character array for easy iteration.
			StringBuilder sb = new StringBuilder(""); //Initalises a string builder for rebuilding the output from the character array.
			for(char i : characters){
				int newAscii = (int) i;		//For each character in the incoming file it will assign the interger variable newAscii to the characters Ascii value
				if (i <=122  && i >=98){	//Then in the first if statement checks if the character is one that it needs to change.
					newAscii = i -1;		//if so then it simply takes from off the ascii value.
				}
				else if ((int) i == 97){ 	//the else if statment checks if the character is the letter a as that needs a special rule.
					newAscii = 122;			//inside of being subtracted it is set to the ascii value for z
				}
				else{
					newAscii = i;			//Any other characters end up here and are not changed. 
				}
				char outText = (char) newAscii;
				sb.append(outText);				//The changed or unchanged characters are then added to the stringbuilder ready to be output.
				}
			System.out.println(sb+"\n"); //here it prints the output of the encrypting.

		}catch(FileNotFoundException e){
			System.out.println("File not found"); //If the user has requested a file that is not present it will say no file avaliable
		}catch(IOException e){
			System.out.println("IO error"); //This is if there is an error in reading the file.
		}
	}
}
