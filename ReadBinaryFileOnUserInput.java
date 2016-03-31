import java.io.*;
import java.util.Scanner;
/*
	This program opens a file, reads and displays the contents
	in a 32-bit Binary number, hexadecimal, and unsigned integer
*/


public class ReadBinaryFileOnUserInput
{
	public static void main(String[] args)
						throws IOException
	{
		//initialize "number" to input from file
		//initialize "eof" for End-of-File
		int decNumber;
		String binNumber, userFile;
		int number;
		//Scanner userFile = new Scanner(System.in);
		boolean eof = false;

		//reading file from keyboard
		Scanner sc = new Scanner(System.in);
		System.out.print("Input File name: ");
		userFile = sc.nextLine();
		System.out.print("\n");
		
		//Create binary file input objects
		FileInputStream fstream = new FileInputStream(userFile);
		DataInputStream inputFile = new DataInputStream(fstream);

		System.out.println("Reading numbers from specified file");

		//Read contents of the file
		while(!eof)
		{
			try
			{	
				number = inputFile.readInt();
				binNumber = String.format("%32s \t", Integer.toBinaryString(number)).replace(' ', '0');
				System.out.printf("%32s \t %08x \t %10d\n", binNumber, number, Math.abs(number));
			}
			catch(EOFException e)
			{
				eof = true;
			}
		}
		System.out.println("\nDone.");

		//Close file
		inputFile.close();
	}
}
