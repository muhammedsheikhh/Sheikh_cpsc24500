import java.util.ArrayList;
import java.util.Random;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Madlibs {

    // Word lists
    private static ArrayList<String> adjectives = new ArrayList<>();
    private static ArrayList<String> singNouns = new ArrayList<>();
    private static ArrayList<String> adverbs = new ArrayList<>();
    private static ArrayList<String> pastVerbs = new ArrayList<>();
    private static ArrayList<String> pluNouns = new ArrayList<>();
    private static ArrayList<String> pluVerbs = new ArrayList<>();
    private static ArrayList<String> sinVerbs = new ArrayList<>();

    private static Random rand = new Random();

    //Prints the welcome message.
    public static void printWelcome() {
        System.out.println("*".repeat(75));
        System.out.println(" ".repeat(22) + " Welcome to Madlibs V1.0");
        System.out.println("*".repeat(75));
        System.out.println();
    }

    /**
     * Retrieves a random word from the provided list.
     *
     * @param list List of words.
     * @return A randomly selected word.
     */
    public static String getRandomWord(ArrayList<String> list) {

        return list.get(rand.nextInt(list.size()));
    }

    /**
     * Requests the directory path from the user and validates it.
     *
     * @param sc Scanner to read user input.
     * @return The directory path.
     */
    public static String getDirectoryPath(Scanner sc) {
        String directory = sc.nextLine().trim();
        if (directory.isEmpty()) {
            directory = "."; // Default to the current directory
        }
       
        return directory;
    }

    /**
     * Loads word lists from specified directory.
     *
     * @param directory The directory containing word lists.
     * @return true if word lists loaded successfully, false otherwise.
     */
    public static boolean loadWordLists(String directory) {
        try {
            loadWordList(new File(directory, "adj.txt"), adjectives);
            loadWordList(new File(directory, "singnoun.txt"), singNouns);
            loadWordList(new File(directory, "adv.txt"), adverbs);
            loadWordList(new File(directory, "pastverb.txt"), pastVerbs);
            loadWordList(new File(directory, "plunoun.txt"), pluNouns);
            loadWordList(new File(directory, "pluverb.txt"), pluVerbs);
            loadWordList(new File(directory, "singverb.txt"), sinVerbs);
            return true;
        } catch (Exception ex) {
            System.out.println("Could not read the wordlist files.");
            return false;
        }
    }

    /**
     * Processes the available stories by prompting the user to choose a story number.
     * Replaces the placeholders in the chosen story with words from the word lists and displays the final story
     *
     * @param directory The directory where the stories are located.
     * @param sc The scanner object to read user input.
     */
    public static void processStories(String directory, Scanner sc) {
        String choice;
        do {
            System.out.println();
            System.out.print("Enter a story number or q to quit: ");
            choice = sc.nextLine().trim();
            if (!choice.equalsIgnoreCase("q")) {
                String storyContent = readStoryFile(new File(directory, "story" + choice + ".txt"));
                if (storyContent != null) {
                    System.out.println("\nHere's your Madlib:\n");
                    System.out.println(replacePlaceholdersInStory(storyContent));
                } else {
                    System.out.println("That story does not exist. Choose again.");
                }
            }
        } while (!choice.equalsIgnoreCase("q"));
    }

    /**
     * Reads the content of the provided story file.
     *
     * @param file The file object representing the story file to be read.
     * @return The content of the story file as a single string, or null if the file could not be read.
     */
    public static String readStoryFile(File file) {
        StringBuilder story = new StringBuilder();
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                story.append(fileScanner.next()).append(" ");
            }
            fileScanner.close();
        } catch (Exception e) {
            return null;
        }
        return story.toString();
    }

    /**
     * Replaces the placeholders in the provided story with random words from the word lists.
     *
     * @param storyContent The original content of the story with placeholders.
     * @return The story with placeholders replaced by random words.
     */
    public static String replacePlaceholdersInStory(String storyContent) {
        String[] words = storyContent.split(" ");
        StringBuilder story = new StringBuilder();
        for (String word : words) {
            if (word.contains("<adj>")) {
                word = word.replace("<adj>", getRandomWord(adjectives));
            } else if (word.contains("<singnoun>")) {
                word = word.replace("<singnoun>", getRandomWord(singNouns));
            } else if (word.contains("<adv>")) {
                word = word.replace("<adv>", getRandomWord(adverbs));
            } else if (word.contains("<pastverb>")) {
                word = word.replace("<pastverb>", getRandomWord(pastVerbs));
            } else if (word.contains("<plunoun>")) {
                word = word.replace("<plunoun>", getRandomWord(pluNouns));
            } else if (word.contains("<pluverb>")) {
                word = word.replace("<pluverb>", getRandomWord(pluVerbs));
            } else if (word.contains("<singverb>")) {
                word = word.replace("<singverb>", getRandomWord(sinVerbs));
            }
            story.append(word).append(" ");
        }
        return story.toString();
    }

    /**
     * Main function to execute the Madlibs game.
     *
     * @param args Command line arguments (not used).
     */

    public static void main(String[] args) {
        String directory;
        Scanner sc = new Scanner(System.in);

        printWelcome();
        System.out.println("This program generates random stories using wordlists you supply.");
        System.out.println();

        System.out.print("Enter the name of the folder where the stories and wordlists are.\nOr just press Enter to accept the default location: ");
        directory = getDirectoryPath(sc);

        if (!loadWordLists(directory)) {
            System.out.println("Cannot continue.");
            return;
        }

        processStories(directory, sc);

        System.out.println("Thanks for playing Madlibs!");
    }

    /**
     * Loads words from a file into a list.
     *
     * @param file The file object containing the words.
     * @param list The list to populate with words.
     */
    public static void loadWordList(File file, ArrayList<String> list) {
        try {
            Scanner fileScanner = new Scanner(file);
            while (fileScanner.hasNext()) {
                String word = fileScanner.nextLine().trim();
                if (!word.isEmpty()) {
                    list.add(word);
                }
            }
            fileScanner.close();
        } catch (FileNotFoundException e) {
            System.out.println("Error reading wordlist file: " + file.getName());
        }
    }

}