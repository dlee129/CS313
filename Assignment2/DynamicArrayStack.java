/*
 * This is the DynamicArrayStack.java class
 * 
 * Here the methods are implemented to use for stack operations
 * 
 * 
 */
public class DynamicArrayStack<AnyType> implements Stack<AnyType>{
	/*
	 * Set up the data members of class DynamicArrayStack
	 */
  public static final int DEFAULT_CAPACITY = 256;
  AnyType[] data;
  int topOfStack;

  /*
   * This will initialize the size for the Stack
   */
  public DynamicArrayStack(){
	  
	  this(DEFAULT_CAPACITY); 
	  
  }

  /*
   * this will change the stack size to what the parameter input is
   * this will also set the stack to be empty since the top is -1
   */
  public DynamicArrayStack(int capacity){
	  
    topOfStack = -1;
    data = (AnyType[]) new Object[capacity];
    //this is initializing and creating the stack
    
  }

  public int size(){
	  
    return (topOfStack);
    // this increases the size of the stack whenever another object is being pushed
    
  }

  public boolean isEmpty(){
	
	
    if(topOfStack == -1){
    	return true;
    }else{
    	return false;
    }
    //returns -1 when the stack is empty
    
  }

  public void push(AnyType newValue){
	 
	topOfStack += 1; 
    data[topOfStack] = newValue;
    
    //inserts a new value at the top of the stack
  }

  public AnyType top(){
	  
	  	if(topOfStack == -1){
	  		return data[topOfStack=1];
	  	}else{
		    return data[topOfStack];
	  	}

	    // this gives us the value of the data at the top of the stack 
  }

  public AnyType pop(){

	    
	    AnyType temp = data[topOfStack];
	    topOfStack--;
	    return temp;
	    //this removes the data at the top of the stack 
  }

  protected void resize(int newCapacity){
	  
    int n = size();

    AnyType[] temp = (AnyType[]) new Object[newCapacity];
    for (int i=0; i < n; i++)
      temp[i] = data[i];
    data = temp;
    
    //this method corrects the size of the stack and adjusts it whenever a push or pop happens
  }
}