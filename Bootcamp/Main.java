package Bootcamp;
//modify this program so that if the user provided more than 5 arguments, 
//it will print a message "you gave me more than 5 arguments"
//otherwise print you gave me 5 or fewer arguements

class Main {
  public static void main(String[] args) {
    System.out.println("You gave me " + args.length + " arguments.");
    if (args.length > 5) {
      System.out.println("You gave me more than 5 arguments.");
    }
    else{
      System.out.println("You gave me 5 or fewer arguements");
    }
    for (String oneArg: args) {
        System.out.println(oneArg);
    }
  }
}

/*
    let's say args = ["1", "2", "3"]

    for (String oneArg: args) will take each member one at a time and run the code with the member living in oneArg available
*/