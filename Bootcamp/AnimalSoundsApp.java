package Bootcamp;
abstract class Animal {
    /**
     * put all the properties/fields above the constructor
     * general practice is to make all the fields private
     * java imposes restrictions on what other code can see
     * java was one of the early prominent languages that says "this is code I don't want other people to see"
     * when you say private, it says that you have a variable inside called "name", but only other animals can see the name
     * keep this private so that it is explicit that you don't want people to see the data.
     * however, you can write methods to access the data in the fields
     */
    private String name;

    protected Animal(String name) {
        this.name = name; // Python: self.name = name
    }
    
    /*
     * if name is supposed to be private, you can access the information of name through this method
     */
    public String getName() { // "Accessor" method: a one-line method whose sole job is to give you access to a variable
        return name; // Python: no equivalent
    }

    public String speak() {
        return name + " says " + sound();
    }

    public abstract String sound();
}

class Cat extends Animal {
    public Cat(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "meow";
    }
}

class Dog extends Animal {
    public Dog(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "woof";
    }
}

class Cow extends Animal {
    /**
     * this is a constructor. it gives you instructions on how to build an object from that class
     * to define a constructor in java, you have to say whether it is public or private
     * the name of the constructor has to be the same as the class name
    */
    public Cow(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "muuuuuu";
    }
}

class Horse extends Animal {
    public Horse(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "neigh";
    }
}

class Sheep extends Animal {
    public Sheep(String name) {
        super(name);
    }

    @Override
    public String sound() {
        return "baaaa";
    }
}

class AnimalSoundsApp {
    public static void main(String[] args) {
        Animal h = new Horse("CJ");

        System.out.println(h.getName());
        System.out.println(h.speak());

        Animal c = new Cow("Fernanda");
        System.out.println(c.speak());

        System.out.println(new Sheep("Little Lamb").speak());

        Animal cat = new Cat("Mittens");
        System.out.println(cat.speak());

        System.out.println(new Dog("Yoshi").speak());

        // this is incorrect since Animal is an abstract class!
        // Animal a = new Animal("Animal");
        // System.out.println(a.speak());

    }
}