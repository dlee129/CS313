import java.io.*;
import java.util.*;

public class ArithmeticExpressionTree{
	
	static LinkedQueue<String> ArithmeticQueue = new LinkedQueue<>();
	static LinkedStack<BinaryTree> treeStack = new LinkedStack<>();
	static BinaryTree<String> finalTree = new BinaryTree<>();
	static String postfix;
	
	public ArithmeticExpressionTree(String input){
		
		postfix = input;
		/*
		 * This part of the class begins the part of Project 3 which turns the ending postfix expression into Arithmetic Expression Tree
		 * First we begin by enqueing all the characters from the postfix conversion into an empty queue
		 * 
		 */
	}
	public void ArithmeticTreeEvaluation(){
		/*
		 * Stringtokenizer is used to separate all the operands and operators into separate strings
		 * these separate strings are then put into a queue as individual strings 
		 */
		StringTokenizer st = new StringTokenizer(postfix);
		while(st.hasMoreTokens()){
			String variable = st.nextToken();
			ArithmeticQueue.enqueue(variable);
		}
		/*
		 * This will read the ArithmeticQueue and check if it is empty or not
		 * if it is not empty, then the while loop will keep running and dequeue the first element of the queue
		 */
		while(!ArithmeticQueue.isEmpty()){
			String element = ArithmeticQueue.first();
			if(element == "+" || element == "-" ||  element == "*" || element == "/"  ){
				
				BinaryTree<String> T = new BinaryTree<>(element);
				//this sets the Tree T to be the root with the first element from the queue
					treeStack.pop();
					if(!treeStack.isEmpty()){
					BinaryTree<String> rightChild = treeStack.top();
					treeStack.pop();
					BinaryTree<String> leftChild = treeStack.top();
					T.attach(leftChild, rightChild);
					treeStack.push(T);
				}
				
			}
			else{
				BinaryTree<String> T = new BinaryTree<>(element);
				treeStack.push(T);
			}
			ArithmeticQueue.dequeue();
			finalTree = treeStack.top();
			treeStack.pop();
		}//while loop that keeps running as long as ArithmeticQueue
		
		/*
		 * This is the evaluation part of the Arithmetic Expression Tree
		 * iterate through the tree
		 * process each element whether its an operand or operator
		 * 
		 */
		
		Iterator<String> itr = finalTree.iterator();
		LinkedStack<Integer> evalTree = new LinkedStack<>();
		while(itr.hasNext()){
			String element = itr.next();
			char checker = element.charAt(0);
			if(element == "+" || element == "-" || element == "*" || element == "/"){
				int right;
				int left;
				right = evalTree.top();
				evalTree.pop();
				left = evalTree.top();
				evalTree.pop();
				int sum = right + left;
				evalTree.push(sum);
			}
			else if((Character.isDigit(checker)) && Integer.parseInt(element) > 0){
				evalTree.push(Integer.parseInt(element));
			}
			else if (Character.isLetter(checker)){
				Scanner in = new Scanner(System.in);
				System.out.println("Give a value for " + element + " : ");
				int value = in.nextInt();
				evalTree.push(value);
				in.close();
			}
		}
		
		}//ArithmeticExpressionTree class constructor
}
