package main;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import match.AlwaysTrueMatcher;
import match.MatchCollector;
import match.PrefixMatcher;
import match.StringMatcher;

public class Main {

    public static void main(String[] args) {
        List<String> inputs = new ArrayList<>();
        inputs.add("Madder");
        inputs.add("Maidenhair");
        inputs.add("Mandrake");
        inputs.add("Maple");
        inputs.add("Marigold");
        inputs.add("Marshmallow");
        inputs.add("Mezereon");
        inputs.add("Milfoil");
        inputs.add("Milkwort");
        inputs.add("Mugwort");
        inputs.add("Mulberry");
        inputs.add("Myrtle");

        StringMatcher m1 = new AlwaysTrueMatcher();
        AlwaysTrueMatcher m2 = new AlwaysTrueMatcher();

        PrefixMatcher m3 = new PrefixMatcher("M");
        StringMatcher m4 = new PrefixMatcher("Ma");

        StringMatcher m5 = m2.and(m4);
        StringMatcher m6 = m1.and(m4).and(new PrefixMatcher("Mar"));

        tryMatcher(m1, inputs); // [true, true, true, true, true, true, true, true, true, true, true, true]
        tryMatcher(m3, inputs); // [true, true, true, true, true, true, true, true, true, true, true, true]
        tryMatcher(m4, inputs); // [true, true, true, true, true, true, false, false, false, false, false, false]
        tryMatcher(m5, inputs); // [true, true, true, true, true, true, false, false, false, false, false, false]
        tryMatcher(m6, inputs); // [false, false, false, false, true, true, false, false, false, false, false, false]

        MatchCollector collector = new MatchCollector(Arrays.asList(m4, m5, m6));
        System.out.println("After collected some the best inputs are :') " + collector.collect(inputs));
    }

    // iterates through the inputs and decides whether the matcher matches that
    private static void tryMatcher(StringMatcher matcher, List<String> inputs) {
        String result = matcher.getClass().getName() + ": ";
        result += inputs.stream().map(matcher::match).collect(Collectors.toList());
        System.out.println(result);
    }

}
