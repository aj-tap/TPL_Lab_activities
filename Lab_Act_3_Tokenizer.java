// Theory of Programming languages
// Lab Activity 3 
// The Tokenizer (aka “Lexical Analysis”)
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        System.out.println("Enter Source Language: ");
        Scanner input = new Scanner(System.in);
        String input_string = "";
        String output_string = "";
        input_string = input.nextLine();
        String[] tokens = input_string.split("(?<!(\"|').{0,255}) | (?!.*\\1.*)");
        for (String token : tokens)
        {
            if (token.equals("int") || token.equals("char") || token.equals("double") || token.equals("String"))
            {
                output_string += "<data_type> ";
            } else if (token.equals("=")) {
                output_string += "<assignment_operator> ";
            } else if (token.contains("\"") ) {
                output_string += "<value> ";
            } else if (token.matches("[0-9];+") || token.matches("[1-9][0-9]") ) {
                output_string += "<value> ";
            } else
            {
                output_string += "<identifier> ";
            }
            if(token.contains(";"))
            {
                output_string += "<delimeter> ";
            }
        }
        System.out.println("Output is: "+ output_string);
    }
}
