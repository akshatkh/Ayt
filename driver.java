public class driver{
	
	
	public static void main(String[] args) {
		String b=RhymeGame.getRandomWord();
		RhymeGame a=new RhymeGame(b);
		
		System.out.println(b);
		a.getArray();
	}
}
