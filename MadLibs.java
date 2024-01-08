// Based on example project from some of TreeHouse's online Java materials
import java.io.Console;
import java.util.Set;

public class MadLibs {
    
    public static void main(String[] args) {
        Console console = System.console();

        // Reference variables for checking grammar/unkind language
        Set<String> VOWELS = Set.of("a", "e", "i", "o", "u");
        Set<String> PEJORATIVES = Set.of("dork", "jerk");

        // Only allow users over age 13 to play MadLibs
        int age = Integer.parseInt(console.readLine("Please enter your age in years: "));
        if (age < 13) {
            console.printf("You must at least 13 to play MadLibs.\n");
            System.exit(0);
        }

        // Gather game words
        String name = console.readLine("Enter a name: ");
        String noun;
        boolean isInvalidWord;

        // Don't allow certain pejoratives as nouns
        do {
            noun = console.readLine("Enter a noun (hint: a noun is a person, place, thing, or idea): ");
            isInvalidWord = PEJORATIVES.contains(noun.toLowerCase());
            if (isInvalidWord) {
                console.printf("That language is not allowed. Try again.\n\n");
            }
        } while(isInvalidWord);

        String adj = console.readLine("Enter an adjective (hint: an adjective describes a noun): ");
        String adv = console.readLine("Enter an adverb (hint: an adverb describes a verb; often ends in -ly): ");
        String verb = console.readLine("Enter a verb ending in -ing (hint: this is also called a gerund; a verb is an action word): ");
        Character firstAdjChar = adj.charAt(0);
        String adjStart = firstAdjChar.toString();
        String article = (VOWELS.contains(adjStart)) ? "an" : "a";
        
        // MadLib result
        console.printf("%s is %s %s %s. ", name, article, adj, noun);
        console.printf("They are always %s %s.", adv, verb);
    }
}