// Theory of Programming languages
// Lab Activity 5
import java.util.Scanner;
import java.util.Stack;

public class Main  {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Enter Expression: ");
        String input_token = input.nextLine();
        String[] tokens = input_token.split("\\s+");

        if (semanticChecker(tokens) )
        {
            System.out.println("Semantically Correct!");
        }
        else {
            System.out.println("Semantically Incorrect!");
        }
    }
    static boolean typeCheck(String dataType, String value) {
        if (((dataType.matches("int") || dataType.matches("double")) && onlyDigits(value, value.length()))) {
            return true;
        } else if (dataType.matches("float") && value.matches("[-+]?[0-9]*\\.?[0-9]+")) {
            return true;
        } else if (dataType.matches("String") && value.contains("\"")) {
            return true;
        } else if (dataType.matches("char") && value.contains(".")) {
            return true;
        } else return dataType.matches("boolean") && (value.contains("true") || value.contains("false"));
    }

    static boolean semanticChecker(String[] tokens) {
        String dataType = "";
        String value = "";
        for (String token : tokens) {
            if (token.equals("int") || token.equals("char") || token.equals("double") || token.equals("String")) {
                dataType = token;
            } else if (token.contains("\"") || token.matches("[0-9];+") || token.matches("[1-9][0-9]")) {
                if (token.endsWith(";") || token.contains("\""))
                {
                    value = token.replace(";","").replaceAll("\"[^\"]*\"","");
                }
                else {
                    value = token;
                }
            }
        }
        return typeCheck(dataType, value);
    }
    static Boolean onlyDigits (String str,int n)
    {
        for (int i = 0; i < n; i++) {
            if (str.charAt(i) < '0'
                    || str.charAt(i) > '9') {
                return false;
            }
        }
        return true;
    }
}