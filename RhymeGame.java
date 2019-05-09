import org.jsoup.*;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import java.util.*;
public class RhymeGame{
	String word;
	ArrayList<String> rhymes = new ArrayList<String>();
	/**
	 * Paramter constructor to initialize the word variable
	 * @param w - parameter to initialize word
	 */
	public RhymeGame(String w) {
		word=w;
	}
	/**
	 * Method create the array list of rhyming words;
	 */
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
		System.out.println(rhymes);
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
		}
	}
	
	/**
	 * 
	 * @return random word
	 */
	public static String getRandomWord() {
		try {
			Document doc = Jsoup.connect("https://randomword.com/").userAgent("Chrome/74.0.3729.131").get();
			Elements temp=doc.select("div");
			for(Element a:temp) {
				if(a.attr("id").equals("random_word")) {
					return a.text();
				}
			}
			return "a";
		}
		catch(Exception e) {
			System.out.println(e.getMessage());
			return "a";
		}	
	}	
}
