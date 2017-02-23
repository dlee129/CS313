import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Project1{
	public static void main(String []args){
		
		try{
			BufferedReader sourceFile = new BufferedReader(new InputStreamReader(new FileInputStream("project1.txt")));
			String line = sourceFile.readLine();
			sourceFile.close();
    	}
		catch (FileNotFoundException FnFe){
			System.out.println(FnFe.getMessage());
		}
		catch (IOException IoE){
			System.out.println(IoE.getMessage());
		}
			
		
	}//main body of program. also executes project
}