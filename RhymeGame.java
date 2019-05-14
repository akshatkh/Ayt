import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
import java.io.*;

public class RhymeGame{
	String word;
	
	ArrayList<String> rhymes=new ArrayList<String>();
	public RhymeGame(String w) {
		word=w;
	}
	public void getArray() {
		try {
			
			String url="https://www.rhymezone.com/r/rhyme.cgi?Word="+word+"&typeofrhyme=perfect&org1=syl&org2=l&org3=y";
			
			Document doc = Jsoup.connect(url).userAgent("Chrome/74.0.3729.131").get();

			Elements temp=doc.select("a");
			for(Element a:temp) {
				String b=a.text();
				b=b.replaceAll(" ", "_");
				
				
				if(a.attr("href").equals("d="+b)) {
					rhymes.add(a.text().toLowerCase().replaceAll(" ","").replaceAll("-","").replaceAll("'", ""));
					
				}
				
			}
		//System.out.println(rhymes);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	public static String getRandomWord() {
		String word="";
		try {
			Scanner in=new Scanner(new File("words.txt"));
			Random rand=new Random();
			int a=rand.nextInt(10000);
			for(int i=0; i<a;i++) {
				in.next();
			} 
			word=in.next();
			while((word.length()<5||word.contains("fuck")||word.contains("shit")||word.contains("pussy"))) {
				word=in.next();
			}
			return word;
			
					
			}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "a";
		}
		
	}
	
	
}
