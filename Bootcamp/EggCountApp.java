package Bootcamp;
/**
 * An application that prompts the user for a number of eggs, and reports this
 * number in grosses and dozens.
 */
class EggCountApp {
    public static void main(String[] args) {
        // in the latest version of java, you can have a string that has multiple lines by using triple quotes
        // keyboard shortcut for emojis is ctrl+command+space
        System.out.println(""" 
                Welcome to the Egg Counter! 🥚🥚🥚

                If you have less than a billion eggs, we'll help you count
                them, like the pros do.
                """);
        /**
         * whenever we ask for user input, we have to account for people inputting incorrectly formatted information
         * wrap your code in a try, and then put the exceptions in catch
         * the code that might break goes in the curly brace
         * in Python, try catch looks like: try:
         * if you don't catch, then the exception goes directly to the user's face, and the user can find this frustrating
        */
        try {
            //if you are going to use an input value as a value other than a string, you need to convert it
            String response = System.console().readLine("How many eggs? ");
            var eggs = Integer.parseInt(response); // this is the same thing in Python as: int(response)
            if (eggs < 0) { //throw is when we want to manually throw an exception ourselves
                throw new IllegalArgumentException("So sorry you have negative eggs!");
            } else if (eggs >= 1000000000) {
                throw new IllegalArgumentException("No way can you have that many!");
            }
            // a "gross" is something divided by 144, which is a dozen squared
            var gross = eggs / 144;
            var excessOverGross = eggs % 144;
            var dozens = excessOverGross / 12;
            var leftOver = excessOverGross % 12;
            System.out.printf("You have %d gross, %d dozen, and %d%n",
                    gross, dozens, leftOver);
        /**
         * in java we can classify the types of exceptions that are going to happen
         * you tell java to run the code in between the try
         * if one of those exceptions gets thrown back at us, if the exception is a number format exception, run NumberFormatException
         * if one of the exceptions is an illegal argument exception, run IllegalArgumentException
         */

        // to comment out multiple lines at once, highlight the code you want to comment out and use keyboard shortcut command+/
        } catch (NumberFormatException e) { 
            //the e is the variable that the specific exception gets stored in
            // the argument to creating an illegalargumentexception is a message
            // each exception has some customizaiton to it, and the exception is place in the variable
            System.err.println("App can only handle integers up to a billion");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
            //the message can vary since we define 2 instances of illegalargumentexceptions, so it prints the localized message
        }
    }
}
