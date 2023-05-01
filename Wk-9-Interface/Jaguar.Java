public class Jaguar implements Speaker{

    public void speak() {
        System.out.println("Hello I'm Jacquie! Rawrr");
    }

    public void announce(String str) {
        if (str.equalsIgnoreCase("run")) {
            System.out.println("I'm running! Rawrr");
        } 
        else if (str.equalsIgnoreCase("jump")) {
            System.out.println("I'm jumping into the air! Rawrr");
        }
        else {
            System.out.println("Rawrr Rawrr Rawrr");
        }
    }
}