import java.util.Scanner;

public class Main {
    static Scanner Input = new Scanner(System.in);

    public static boolean startsWithCapital(char[] charactersInSentence) {
        /**
         * Testing the sentence to see if it begins with a Capital letter or not, returning
         * true if it does and false if it does not
         */
        if (Character.isUpperCase(charactersInSentence[0])) {
            return true;
        } else return false;
    }

    public static boolean evenQuotationMarks(char[] charactersInSentence) {
        /**
         * Using a for loop to check for every character in the string to see if there is a
         * quotation mark and if there is then it adds to the counter which is then divided
         * by 2 to see if it was odd or even amount and returns false if it is odd or true if
         * even
         */
        int quotationAmount = 0;
        for (char characterElement : charactersInSentence) {
            if (characterElement == '\'' || characterElement == '\"') {
                quotationAmount++;
            }
        }
        if (quotationAmount % 2 == 0) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean sentenceTerminationCharacter(char[] charactersInSentence) {
        /**
         * Setting up a char to hold the final character in the sentence and then checks it
         * against the valid termination characters and returns true if it does and false
         * if it ends with something else
         */
        char finalCharacter = charactersInSentence[charactersInSentence.length - 1];
        if (finalCharacter == '.' || finalCharacter == '?' || finalCharacter == '!') {
            return true;
        }
        return false;
    }

    public static boolean periodChecker(char[] charactersInSentence) {
        /**
         * Using a for loop to determine if any character except the last one is a period
         * or not and if one does show then it returns false and if there is none
         * mid-sentence then it returns true
         */
        for (int place = 0; place < charactersInSentence.length - 1; place++) {
            if (charactersInSentence[place] == '.') {
                return false;
            }
        }
        return true;
    }

    public static boolean numberCheck(String[] wordsInSentence) {
        /**
         * Using a for loop to check every word in the sentence to determine if any number
         * less than 13 is not spelled out such as 12 being written as "twelve" will return
         * a true and being written as "12" will return false with a catch clause in order
         * to prevent words breaking the code
         */
        for (String word : wordsInSentence) {
            try {
                int number = Integer.parseInt(word);
                if (number < 13)
                    return false;
            } catch (NumberFormatException e) {
            }
        }
        return true;
    }

    public static int sentenceCheck(String sentence) {
        /**
         * Creating a method to check overall if a sentence is valid and output any issues with
         * it and returns a 1 if valid and a 0 if invalid
         */
        char[] charactersInSentence = sentence.toCharArray();
        int valid = 1;
        System.out.println("-------------------------------------------------------------");
        System.out.println(sentence);
        if (!startsWithCapital(charactersInSentence)) {
            System.out.println("Sentences must begin with a capital letter.");
            valid = 0;
        }
        if (!evenQuotationMarks(charactersInSentence)) {
            System.out.println("There are uneven number of quotation marks present.");
            valid = 0;
        }
        if (!sentenceTerminationCharacter(charactersInSentence)) {
            System.out.println("The sentence must end with \".\", \"?\", \"!\"");
            valid = 0;
        }
        if (!periodChecker(charactersInSentence)) {
            System.out.println("There is a period somewhere in the sentence other than at the end.");
            valid = 0;
        }
        if (!numberCheck(sentence.split(" |,"))) {
            System.out.println("Numbers below 13 should be spelled out.");
            valid = 0;
        }
        System.out.println("-------------------------------------------------------------");

        return valid;
    }

    public static void main(String[] args) {
        /**
         * with the main class, allows a user to input a sentence and then checks to see if that sentence is valid or
         * invalid and then asks if they would like to check more sentences and goes through a while loop to allow
         * them to check all the sentences they would like
         */
        String sentence;
        System.out.println("Welcome to the string Validator, Please enter a string below");
        System.out.print(">> ");
        sentence = Input.nextLine();
        if (sentenceCheck(sentence) == 0) {
            System.out.println("This sentence is invalid");
        } else {
            System.out.println("This sentence is valid");
        }
        System.out.println("Would you like to check another sentence (Y/N)");
        System.out.print(">> ");
        String answer = Input.nextLine();
        while (answer.equals("y") || answer.equals("Y")){
            System.out.println("Please enter a string below");
            System.out.print(">> ");
            sentence = Input.nextLine();
            if (sentenceCheck(sentence) == 0) {
                System.out.println("This sentence is invalid");
            } else {
                System.out.println("This sentence is valid");
            }
            System.out.println("Would you like to check another sentence (Y/N)");
            System.out.print(">> ");
            answer = Input.nextLine();

        }


    }
}