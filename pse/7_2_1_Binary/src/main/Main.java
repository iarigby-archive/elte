package main;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import converter.StringConverter;

public class Main {

    public static void main(String[] args) {
        String binaryQuestion = "1101001111010001111110100000111100111001011100001111001001000001101001111001101000001010111110100011000011110100";
        StringConverter stringConverter = new StringConverter();

        List<String> words = stringConverter.convertBinaryToStringList(binaryQuestion);
        System.out.println("Words are: " + words);

        int[] indices = new int[] { 4, 2, 3, 1 };
        sortBy(words, indices);
        System.out.println("Question is: " + words.stream().collect(Collectors.joining(" ")));

        String answer = "2015";
        String binaryAnswer = stringConverter.convertStringToBinary(answer);
        System.out.println("Your answer is: " + binaryAnswer);

        words = stringConverter.convertBinaryToStringList(binaryAnswer);
        System.out.println("Thank you, so it is: " + words.stream().collect(Collectors.joining(" ")));
    }

}
