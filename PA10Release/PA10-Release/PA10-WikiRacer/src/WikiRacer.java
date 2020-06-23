import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WikiRacer {

	private static Set<String> visited = new HashSet<>();

	/*
	 * Do not edit this main function
	 */
	public static void main(String[] args) {
		List<String> ladder = findWikiLadder(args[0], args[1]);
		System.out.println(ladder);
	}

	/**
	 * This method finds the Wiki link ladder from a given start page to the
	 * given end page using a priority queue to back the implementation
	 * 
	 * @param start The name of the starting Wikipedia page for the link ladder
	 * @param end The name of the final page of the link ladder
	 * 
	 * @return A List containing the link ladder from the given start page to the end page
	 */
	private static List<String> findWikiLadder(String start, String end) {
		MaxPQ ladderQ = new MaxPQ();
		List<String> first = new ArrayList<String>();
		first.add(start);
		ladderQ.enqueue(first, 0);
		Set<String> links;
		
		while(!ladderQ.isEmpty()) {
			first = ladderQ.dequeue();
			links = WikiScraper.findWikiLinks(first.get(first.size() - 1));
			
			if(links.contains(end)) {
				first.add(end);
				return first;
			}

			// Code for parallelization
			links.parallelStream().forEach(link -> {
				WikiScraper.findWikiLinks(link);
			});
			
			for(String each : links) {
				if(!visited.contains(each)) {
					List<String> toAdd = new ArrayList<>(first);
					toAdd.add(each);
					links = WikiScraper.findWikiLinks(end);
					links.retainAll(WikiScraper.findWikiLinks(each));
					ladderQ.enqueue(toAdd, links.size());
					visited.add(each);
				}
			}
		}
		return null;
	}

}
