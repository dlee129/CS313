/*
 * main class of the project that will create an arithmetic expression tree from the postfix string from Project 2
 * also evaluating the arithmetic expression tree
 */

import java.io.*;

/*
 * Project 3
 * Infix to Postfix Assignment
 * Convert an arithmetic expression written infix notation to the equivalent postfix notation
 * and then dequeue the postfix notation and evaluate the arithmetic expression
 * 
 * 
 */

public class Project2{
	
	/*
	 * set up all the the data members for the project
	 * a string which will act as the input notation
	 */
	

    
    public static void main(String[] args) {
    	//set the File name to be the txt name

    	try{
			BufferedReader sourceFile = new BufferedReader(new InputStreamReader(new FileInputStream("project2.txt")));
			String line = sourceFile.readLine();
            InfixPostfixConverter convert = new InfixPostfixConverter(line);
            System.out.println(convert.infixToPostfix());
    		sourceFile.close();
    	}
		catch (FileNotFoundException FnFe){
			System.out.println(FnFe.getMessage());
		}
		catch (IOException IoE){
			System.out.println(IoE.getMessage());
		}

		
		
		

		
		
		
		
	}//main body of program of class Project3
}