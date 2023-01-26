package Bootcamp;
class WavePrintingApp {
    public static void main(String[] args) {
        int numRows = 64;
        double halfHeight = 12.0;
        double rowsPerCycle = 16.0;
        for (var row = 0; row < numRows; row++) { 
            // latest versions of java allow for var, but it is still useful to know the datatype since not all java online is up to date
            var waveHeight = Math.abs(Math.sin(row * Math.PI / rowsPerCycle) + 1); //the literal that you divide by makes the waves more narrow
            //Math.PI is as close as you can get to pi without typing out the full value of pi. have to preface math funcitons and constants with Math.
            var numberOfStars = (int) Math.round(halfHeight * waveHeight); //change the literal in this line to make the waves taller or shorter
            System.out.println("*".repeat(numberOfStars));
        }
    }
}