package Bootcamp;
/**
 * A command line application that reports the odds of tossing a fair coin 1-10
 * times and getting heads each time.
 */
class CoinFlippingOddsApp {
    public static void main(String[] args) {

        // We'll show odds both in "1 in n" format and in percentage format
        final var message = "Odds of throwing %s %d heads in a row is 1 in %d (%.6g%%)";
        /*
         * final variable is a variable whose value you don't plan to change again
         * you can mark a variable as final to indicate your intent of not wanting it to change
         * in python, there are f strings, and this is similar
         * this message is essentially a template.
         * each of the % are placeholders
         * the letter after the percent tell java what kind of value it's going to print. d means integer
         * the letter g is for doubles. before the letter g, there is a .8 and that is how many decimal places to display
         * to display a % sign, you type %%
         * s is for string
         * the placeholders need to match the data type that they are expecting in the String.format method, or else you get error
         * you can make message a final because it never changes. String.format uses message as a template, but it never modifies message
         */
        //
        

        var possibilities = 2;
        for (var tosses = 1; tosses <= 10; tosses++) {
            final var percentage = 100.0 / possibilities;
            final var line = String.format(message, "banana", tosses, possibilities, percentage);
            /*  
                * String.format accepts another string that has placeholders in it
                * after that, it takes one value per placeholder
            */
            System.out.println(line);

            // Ready for the next iteration
            possibilities *= 2;
        }
    }
}