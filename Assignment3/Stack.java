/*
 * This is the stack class needed to implement methods to use in the DynamicArrayStack class
 * 
 * Contains basic constructors for class Stack
 */
public interface Stack<AnyType>{
	
  int size();
  
  boolean isEmpty();
  
  void push(AnyType newValue);
  
  AnyType top();
  
  AnyType pop();
  
}