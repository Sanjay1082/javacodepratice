package strings.Simple.string;

import java.util.Stack;

public class BalancedParenthesis
{

    public static boolean balancedParenthesis(String value){

        Stack<Character> stack = new Stack();
        char[] ch = value.toCharArray();

        for (char ch1 : ch){

            switch(ch1){
                case '{' :
                case '[' :
                case '(' :
                    stack.push(ch1);
                    break;
                case ')' :
                    if(stack.isEmpty() || stack.peek()!='(')
                        return false;
                    stack.pop();
                    break;
                case '}' :
                    if(stack.isEmpty() || stack.peek()!='{')
                        return false;
                    stack.pop();
                    break;
                case ']' :
                    if(stack.isEmpty() && stack.peek()!='[')
                        return false;
                    stack.pop();
                    break;
                default:
                    break;
            }

        }
        return stack.isEmpty();
    }


    public static void main(String[] args) {
        System.out.println(balancedParenthesis("}"));
    }

}
