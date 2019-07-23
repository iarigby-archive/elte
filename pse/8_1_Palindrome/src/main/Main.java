package main;

import palindrome.PalindromePercentageChecker;

public class Main {

    public static void main(String[] args) {
        PalindromePercentageChecker checker = new PalindromePercentageChecker();

        System.out.println(checker.check("This is a 0% palindrome. <- 0.0")); // prints: 0.0
        System.out.println(checker.check("LLol <- 0.5")); // prints: 0.5
        System.out.println(checker.check("Never are even. <- 0.6666667")); // prints: 0.6666667
        System.out.println(checker.check("Stressed coool desserts ^_^ <- 0.7619048")); // prints: 0.7619048
        System.out.println(checker.check("Dammit, I'm mad. <- 1.0")); // prints: 1.0
    }

}
