import java.io.InputStream;
import java.net.URL;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/*
 * TODO: You will have to implement memoization somewhere in this class.
 */
public class WikiScraper {
	
	private static Map<String, String> memo = new HashMap<String, String>();
			
	/**
	 * This method accepts the name of a Wikipedia page and returns the names of all the Wikipedia
	 * pages whose links are present on it.
	 * 
	 * @param link: The name of the Wikipedia page that is to be searched for links
	 * 
	 * @return A Set of strings containing the names of all the Wikipedia pages whose links 
	 * were present on the page
	 */
	public static Set<String> findWikiLinks(String link) {
		
		// Implementation of memoization in order to obtain the HTML code
		if(memo.containsKey(link))
			return scrapeHTML(memo.get(link));
		
		String html = fetchHTML(link);
		memo.put(link, html);
		Set<String> links = scrapeHTML(html);
		
		return links;
	}
	
	/**
	 * This method accepts the name of a Wikipedia page and returns the HTML code for the same
	 * by first converting the given name into a URL using the getURL() method.
	 * 
	 * @param link: A String representing the name of the Wikipedia page whose code is to be returned
	 * 
	 * @return A String containing the HTML code of the given Wikipedia page.
	 */
	private static String fetchHTML(String link) {
		StringBuffer buffer = null;
		
		try {
			URL url = new URL(getURL(link));
			InputStream is = url.openStream();
			int ptr = 0;
			buffer = new StringBuffer();
			while ((ptr = is.read()) != -1) {
			    buffer.append((char)ptr);
			}
		} catch (Exception ex) {
			System.out.println(ex.getMessage());
			ex.printStackTrace();
		}
		
		return buffer.toString();
	}
	
	
	/**
	 * This function takes in the name of a Wikipedia page and returns a url to the website.
	 * 
	 * @param link: A String that represents the name of the Wikipedia page
	 * 
	 * @return The URL of the page whose name was provided
	 */
	private static String getURL(String link) {
		return "https://en.wikipedia.org/wiki/" + link;
	}
	
	
	/**
	 * This function accepts a String that represents the HTML code of an entire Wikipedia page
	 * and returns a set of Strings that contains the name of all the websites whose links are 
	 * present on its page.
	 * 
	 * @param html: The String containing the HTML code of the Wikipedia page
	 * 
	 * @return A Set of Strings containing the name of all the websites whose links are present on the page.
	 */
	private static Set<String> scrapeHTML(String html) {
		String all[] = html.split("\n");
		Pattern p = Pattern.compile("<a href=\\\\?\"/wiki/([^\\s:#]+)\".*?>");
		Set<String> retval = new HashSet<String>();
		Matcher m;
		for(String each : all) {
			m = p.matcher(each);
			while(m.find()) {
				retval.add(m.group(1));
			}
		}
		return retval;
	}
	
}
