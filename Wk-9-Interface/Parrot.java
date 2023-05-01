public class Parrot implements Speaker{ 

	public void speak(){
		System.out.println("Hello, I'm John. Kwerrr!");

	}

	public void announce(String str){
	
		if(str.equalsIgnoreCase("name")){
			System.out.println("Your name is Freda. Kwerrr!");
		}
		else if(str.equalsIgnoreCase("age")){
			System.out.println("You are 50 years old. Kwerrr!");
		}
		else{
			System.out.println("Kwerrr! Kwerrr! Kwerrr!");
			
		}

	}	

}