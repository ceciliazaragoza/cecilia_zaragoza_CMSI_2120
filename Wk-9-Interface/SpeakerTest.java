public class SpeakerTest{

	public static void main(String[] args){
		System.out.println("\n");
		TrainNav nytrain = new TrainNav();
		nytrain.speak();
		nytrain.announce("Next");
		nytrain.announce("Grand Central");
		nytrain.announce("Times Square");
		System.out.println("\n");

		MoodWeatherMan man = new MoodWeatherMan();
		man.speak();
		System.out.println("\n");
		man.announce("Excited");
		man.announce("Moody");
		man.announce("Calm");
		System.out.println("\n");
		
		Parrot parrot = new Parrot();
		parrot.speak();
		parrot.announce("Name");
		parrot.announce("Age");	

		Jaguar jaguar = new Jaguar();
		jaguar.speak();
		jaguar.announce("Run");
		jaguar.announce("Jump");
		jaguar.announce("Hello");
	}
}