// Theory of Programming languages
// Lab Activity 2 v1.2
// DFA (Deterministic Finite Automata)
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        String state = "q0";
        String input = "1111110000101";
        for(int x = 0; x < input.length(); x++){
            if(state.equals("q0") && input.charAt(x) == '0'  ){
                state = "q1";
            }else if(state.equals("q0") && input.charAt(x) == '1'  ){
                state = "q0";
            }else if(state.equals("q1") && input.charAt(x) == '0'  ){
                state = "q1";
            }else if(state.equals("q1") && input.charAt(x) == '1'  ){
                state = "q2";
            } else if (state.equals("q2") && input.charAt(x) == '0') {
                state = "q1";
            } else if (state.equals("q2") && input.charAt(x) == '1') {
                state = "q0";
            } else{
                System.out.println("Invalid input.. Exiting automaton");
            }
        }
        //check if state is final state
        if(state.equals("q2")){
            System.out.println("String accepted");
        }else{
            System.out.println("String not accepted");
            //System.out.println(state);
        }
    }
}