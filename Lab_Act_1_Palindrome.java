// Theory of Programming languages
// Lab Activity 1
// Create a palindrome checker.
import java.util.Scanner;
public class Palindrome {
    void Palindrome(){
        Scanner input = new Scanner(System.in);
        System.out.println("Enter word/phrase:");
        String word = input.nextLine();
        String reverse_word = "";
        for (int i = (word.length() -1) ; i >=0 ; i--) {
            reverse_word = reverse_word + word.charAt(i);
        }
        if (word.equals(reverse_word))
        {
            System.out.println(word + " is palindrome\n");
        }
        else {
            System.out.println(word + " is NOT a palindrome\n");
        }
    }
}