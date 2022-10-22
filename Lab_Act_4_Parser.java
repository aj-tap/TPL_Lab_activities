// Theory of Programming languages
// Lab Activity 4 
// The Parser(aka “Syntax Analysis”)
import java.util.Scanner;
import java.util.Stack;
public class Main {
    public static void main(String[] args) {
        Stack<String> stk = new Stack<>();
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Tokens: ");
        String input_token = input.nextLine();
        String[] tokens = input_token.split("\\s+");
        for (int i = 0; i <tokens.length ; i++) {
            if (tokens[i].contains("<data_type>")|| stk.empty())
            {
                stk.push(tokens[i]);
            }
            else if (stk.peek().equals("<value>"))
            {
                String id = stk.pop();
                String output = "Expression───id────"+ id;
                stk.push(output);
                i--;
            }else if (stk.peek().equals("<identifier>"))
            {
                String id1 = stk.pop();
                String id2 = stk.pop();
                String output = "        ┌──── id───"+id1+"\n" +
                        "        │\n" +
                        "Expression\n" +
                        "        │\n" +
                        "        └──── id───"+ id2;
                stk.push(output);
                i--;
            } else if (stk.peek().equals("<assignment_operator>"))
            {
                String id = stk.pop();
                String output = "Operator────"+id;
                stk.push(output);
                i--;
            }
            else if( (tokens[i].contains("<identifier>") || tokens[i].contains("<value>") || tokens[i].contains("<assignment_operator>") || tokens[i].contains("<delimiter>") ) )
            {
                stk.push(tokens[i]);
            }
            else
            {
                break;
            }
        }
        if (stk.peek().equals("<delimiter>")) {
            System.out.println("Syntax Correct\n");
            System.out.println("\t\t+++ Parse Tree +++\n");
            stk.pop();
            for (String s : stk) {
                System.out.println(s);
            }
        } else {
            System.out.println("Syntax Error");
        }
    }
}
