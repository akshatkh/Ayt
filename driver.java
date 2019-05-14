import java.util.*;
import java.io.*;
public class driver{
	
	
	public static void main(String[] args) {
		while(true) {
		String b=RhymeGame.getRandomWord();
		RhymeGame a=new RhymeGame(b);
		
		System.out.println(b);
		a.getArray();
		ArrayList rhymes=a.rhymes;
		Scanner in= new Scanner(System.in);
		if(rhymes.contains(in.nextLine().toLowerCase().replaceAll(" ","" ).replaceAll("'","").replaceAll("-", ""))) {
			System.out.println("Thats a rhyme!");
			
		}
		else {
			System.out.println("Lmao Nope!");
		}
	}
	}
}
