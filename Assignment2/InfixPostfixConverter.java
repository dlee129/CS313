public class InfixPostfixConverter{

	static String input;
    private LinkedStack<Character> charStack = new LinkedStack<>();

    /*
     * this is what project2 returns after passing through an infixexpression
     */
    public InfixPostfixConverter(String infixExpression) {
        input = infixExpression;
    }
    
    /*
     *Main part of the conversion code that turns an infix notation to its proper postfix notation 
     */

    public String infixToPostfix() {
        String postfixString = "";
        /*
         * for statement reads each character of the input expression
         */
        for (int index = 0; index < input.length(); ++index) {
        	// charValue represents the character that is at the current index #
            char charValue = input.charAt(index);
            // ( takes precedence as operator
            if (charValue == '(') {
            	charStack.push('('); // Code Added
            	// ) precedence as operator to ( 
            } else if (charValue == ')') {
                Character oper = charStack.top();
                /*
                 * this while loop will keep reading characters from the stack
                 * and
                 */
                while (!(oper.equals('(')) && !(charStack.isEmpty())) {
                	charStack.pop();
                    postfixString += oper.charValue();
                    if (!charStack.isEmpty()) // Code Added
                        oper = charStack.top(); // Code Added
                }
                charStack.pop(); // Code Added
            } else if (charValue == '+' || charValue == '-') {
                if (charStack.isEmpty()) {
                	charStack.push(charValue);
                } else {
                    Character oper = charStack.top();
                    while (!(charStack.isEmpty() || oper.equals(('(')) || oper.equals((')')))) {
                        oper = charStack.pop(); // Code Updated
                        postfixString += oper.charValue();
                    }
                    charStack.push(charValue);
                }
            } else if (charValue == '*' || charValue == '/') {
                if (charStack.isEmpty()) {
                	charStack.push(charValue);
                } else {
                    Character oper = charStack.top();
                    // while condition updated
                    while (!oper.equals(('(')) && !oper.equals(('+')) && !oper.equals(('-')) && !charStack.isEmpty()) {
                        oper = charStack.pop(); // Code Updated
                        postfixString += oper.charValue();
                    }
                    charStack.push(charValue);
                    postfixString += " ";
                }
        	} else {
        		if( charValue == '0' || charValue == '1' || charValue == '2' || charValue == '3' || charValue == '4' || charValue == '5' || charValue == '6' || charValue == '7' || charValue == '8' || charValue == '9'){
        			postfixString += charValue;
        		} else {
                postfixString += charValue;
                postfixString += " ";
        		}
            }
        }

        while (!charStack.isEmpty()) {
            Character oper = charStack.top();
            if (!oper.equals(('('))) {
            	charStack.pop();
                postfixString += oper.charValue()+ " ";
            }
        }
        return postfixString;
    }

	/*
	 * This is the end of the program that converts the infix to postfix
	 */
}