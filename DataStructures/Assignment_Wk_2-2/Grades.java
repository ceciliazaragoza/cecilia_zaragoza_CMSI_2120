class Grades {
    private int[] values;

    Grades () {
        this.values = new int[0];
    }

    Grades (int[] myArray) {
        this.values = myArray;
    }

    public void setValues(int[] myArray) { // set values declaration 
        this.values = myArray;
    }

    public int[] getValues() { // returns values array
        return values; 
    }
    
    public int highest() {// returns the highest value in array
        int max = values[0];
        for (int idx = 0; idx < values.length; idx++) {
            if (values[idx] > max) {
                max = values[idx];
            }
        }
        return max;
    }

    public int lowest() {// returns the lowest value in array 
        int min = values[0];
        for (int idx = 0; idx < values.length; idx++) {
            if (values[idx] < min) {
                min = values[idx];
            }
        }
        return min; 
    }

    public int numOfGrades() {// returns the number of grades in array 
        return values.length;
    }

    public double average() { // returns the average of array
        double total = 0.0;
        for (int idx = 0; idx < values.length; idx++) {
            total += values[idx];
        }
        return total / values.length;
    }

    public int numOfFailingGrades(int gradeValue) { // returns the number of values in the array that are less than input value, gradeValue 
        int count = 0;
        for (int idx = 0; idx < values.length; idx++) {
            if (values[idx] < gradeValue) {
                count++;
            }
        }
        return count; // TODO
    }

    public void histogram() { // prints the histogram of grades 
        //each variable is a counter for a grade letter range
        int a = 0;
        int b = 0;
        int c = 0;
        int d = 0;
        int f =0;
        for (int idx = 0; idx < values.length; idx++) {
            if (values[idx] >= 90) {
                a++;
            }
            else if (values[idx] >= 80) {
                b++;
            }
            else if (values[idx] >= 70) {
                c++;
            }
            else if (values[idx] >= 60) {
                d++;
            }
            else {
                f++;
            }
        }

        for (int num2 = 99; num2 > 50; num2 -= 10) {
            String repeat = "";
            int num1 = num2 - 9;
            if (num2 == 99) {
                num2 += 1;
                while (a > 0) {
                    repeat += "*";
                    a--;
                }
            }
            else if (num2 == 89) {
                while (b > 0) {
                    repeat += "*";
                    b--;
                }
            }
            else if (num2 == 79) {
                while (c > 0) {
                    repeat += "*";
                    c--;
                }
            }
            else if (num2 == 69) {
                while (d > 0) {
                    repeat += "*";
                    d--;
                }
            }
            else if (num2 == 59) {
                num2 += 1;
                while (f > 0) {
                    repeat += "*";
                    f--;
                }
            }
            
            if (num2 == 100) {
                System.out.println(num1 + " - " + num2 + " | " + repeat);
                num2 -= 1;
            }
            else if (num2 >= 69) {
                System.out.println(num1 + " - " + num2 + " | " + repeat);
            }
            else {
                System.out.println( "< " + num2 + " | " + repeat);
            }
        }
    }
}

class GradesApp {
    // static method is a method that belongs to a class rather than an instance of a class.
    // you can call static method without instantiating object
    public static int[] updateGrades() {
        String response = System.console().readLine("Enter the number of grades to input: ");
        var numberOfGrades = Integer.parseInt(response);
        if (numberOfGrades < 0) {
            throw new IllegalArgumentException("Sorry, you can't input a negative number of grades.");
        }

        var grades = new int[numberOfGrades];
        for (int currentGrade = 0; currentGrade < numberOfGrades; currentGrade++) {
            String gradeResponse = System.console().readLine("Enter grade " + (currentGrade + 1) + ": ");
            var gradeValue = Integer.parseInt(gradeResponse);
            grades[currentGrade] = gradeValue;
        }
        return grades;
    }
    public static void main(String[] args) {
        try {
            // TODO: need to add error handling if user input is not a number, or negative.
            Grades gradebook = new Grades(updateGrades());
            boolean quit = false;
            while (!quit) {
                String answer = System.console().readLine("""
                        What would you like to do?
                        high: get highest grade
                        low: get lowest grade
                        num: get number of grades
                        avg: get average grade
                        fail: get number of failing grades
                        hist: get histogram
                        new: delete grades, create new gradebook
                        q: quit
                        """);
                answer = answer.toLowerCase();
                if (answer.equals("high")) {
                    System.out.println(gradebook.highest());
                }
                else if (answer.equals( "low")) {
                    System.out.println(gradebook.lowest());
                }
                else if (answer.equals( "num")) {
                    System.out.println(gradebook.numOfGrades());
                }
                else if (answer.equals( "avg")) {
                    System.out.println(gradebook.average());
                }
                else if (answer.equals( "fail")) {
                    String val = System.console().readLine("Failing value (non-inclusive): ");
                    Integer failVal = Integer.parseInt(val);
                    if (failVal <= 0) {
                        throw new IllegalArgumentException("Sorry! Failing values are greater than or equal to 1");    
                    }
                    System.out.println(gradebook.numOfFailingGrades(failVal));
                }
                else if (answer.equals( "hist")) {
                    gradebook.histogram();
                }
                else if (answer.equals( "new")) {
                    gradebook.setValues(updateGrades());
                    System.out.println("Old grades deleted and new grades added.");
                }
                else if (answer.equals( "q")){
                    quit = true;
                }
                else {
                    throw new IllegalArgumentException("Sorry! That's an invalid command");
                }
            }
        } catch (NumberFormatException e) {
            System.err.println("Sorry, GradesApp can only handle numbers");
        } catch (IllegalArgumentException e) {
            System.err.println(e.getLocalizedMessage());
        }   
    }   
    
}



