package at.rovo.rdf;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.ArrayList;

/**
 * <p>
 * This is a simple test class which demonstrates how to use {@link Graph} 
 * triplestore to load triples manually or via CSV files and how to query the
 * data store. It furthermore showcases simple inferencing rules and how to
 * apply them to create new facts.
 * </p>
 * 
 * @author Roman Vottner
 */
public class TestTriplestore
{

	/**
	 * Test-Entrypoint
	 * @param args Application parameters passed by the console
	 */
	public static void main(String[] args)
	{
		TestTriplestore test = new TestTriplestore();

		///////////////////////////////////////////////////////////////////////
		/// Simple Test: adds some triples to the store and queries it
		///////////////////////////////////////////////////////////////////////
		
		Graph graph = new Graph();
		test.test1(graph);
		
		///////////////////////////////////////////////////////////////////////
		/// List all movies directed by Steven Spielberg and Harrison Ford 
		/// played in
		///////////////////////////////////////////////////////////////////////
		
		graph = new Graph();
		graph.load("movies.csv");
		test.test2(graph);
		
		///////////////////////////////////////////////////////////////////////
		/// Complex query with variable-binding - single result
		///
		/// Query all investment banks in New York that have given money to Utah 
		/// senator Orrin Hatch
		///////////////////////////////////////////////////////////////////////
		
		graph = new Graph();
		graph.load("business_triples.csv");
		test.test3(graph);
		
		///////////////////////////////////////////////////////////////////////
		/// Complex query with variable-binding - multiple result
		///
		/// Which person started a new relationship in the same year that their
		/// relationship with Britney Spears ended?
		///////////////////////////////////////////////////////////////////////
		
		graph = new Graph();
		graph.load("celeb_triples.csv");
		test.test4(graph);
		
		///////////////////////////////////////////////////////////////////////
		/// Complex query with variable-binding and feed-forward inference
		///
		///////////////////////////////////////////////////////////////////////
		
		graph = new Graph();
		graph.load("business_triples.csv");
		test.test5(graph);
		
		graph = new Graph();
		graph.load("celeb_triples.csv");
		test.test6(graph);
		
		graph = new Graph();		
		graph.add("Peter","nationality","Germany");
		graph.add("Sandra", "nationality", "Austria");
		graph.add("Paul", "nationality", "USA");
		graph.add("Germany", "part_of", "Europe");
		graph.add("Austria", "part_of", "Europe");
		graph.add("USA", "part_of", "North America");
		test.test7(graph);
	}
	
	/**
	 * <p>
	 * Adds 3 RDF facts to the triplestore and executes simple queries on these
	 * data. After querying the triplestore an element is removed from it and
	 * the whole database is returned to see the changes between the calls.
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test1(Graph graph)
	{
		System.out.println("Adding: 'blade_runner name \"Blade Runner\"'");
		graph.add("blade_runner", "name", "Blade Runner");
		System.out.println("Adding: 'blade_runner directed_by ridley_scott'");
		graph.add("blade_runner", "directed_by", "ridley_scott");
		System.out.println("Adding: 'ridley_scott name \"Ridley Scott\"'");
		graph.add("ridley_scott", "name", "Ridley Scott");
		
		System.out.println("Querying: 'blade_runner directed_by ?'");
		list(graph.triples("blade_runner", "directed_by", ""));
		System.out.println("Querying: '? name ?");
		list(graph.triples("", "name", ""));
		System.out.println("Value of 'blade_runner directed_by ?': "+graph.value("blade_runner", "directed_by", ""));
		
		System.out.println("Print the whole triplestore");
		list(graph.triples("", "", ""));
		System.out.println("Removeing: 'blade_runner ? ridley_scott'");
		graph.remove("blade_runner", "", "ridley_scott");
		System.out.println("Print the whole triplestore after removing an element");
		list(graph.triples("", "", ""));
		
		graph.save("test.csv");
		System.out.println();
	}
	
	/**
	 * <p>
	 * After the data has been loaded (externally) from a CSV file into the 
	 * triplestore, it queries the system for the ID of the blade runner movie
	 * which it then uses to fetch all actors that stared in this movie.
	 * </p>
	 * <p>
	 * Then the ID of 'Harrison Ford' is extracted which is then used to list
	 * all films he starred at.
	 * </p>
	 * <p>
	 * The last query lists all films 'Harrison Ford' starred in and where 
	 * directed by 'Steven Spielberg'.
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test2(Graph graph)
	{
		System.out.println("All actors in the movie \"Blade Runner\": ");
		String bladerunnerId = graph.value("", "name", "Blade Runner");
		Set<Triple> actorIds = graph.triples(bladerunnerId, "starring", "");

		for (Triple t : actorIds)
			System.out.println("\t"+graph.value(t.getObject(), "name", ""));
		System.out.println();
		
		System.out.println("Movies Harrison Ford played in: ");
		String harrisonfordId = graph.value("", "name", "Harrison Ford");
		Set<Triple> harrisonfordMovieId = graph.triples("", "starring", harrisonfordId);
		List<String> moviesHarrisonFordPlayedIn = new ArrayList<String>();
		for (Triple t : harrisonfordMovieId)
		{
			moviesHarrisonFordPlayedIn.add(graph.value(t.getSubject(), "name", ""));
			System.out.println("\t"+graph.value(t.getSubject(), "name", ""));
		}
		System.out.println();
		
		String spielbergId = graph.value("", "name", "Steven Spielberg");
		Set<Triple> spielbergMovieIds = graph.triples("", "directed_by", spielbergId);
		List<String> moviesDirectedByStevenSpielberg = new ArrayList<String>();
		for (Triple t : spielbergMovieIds)
			moviesDirectedByStevenSpielberg.add(graph.value(t.getSubject(), "name",""));	
		
		System.out.println("Movies Harrison Ford played in and Steven Spielberg directed: ");
		List<String> intersection = new ArrayList<String>(moviesDirectedByStevenSpielberg);
		intersection.retainAll(moviesHarrisonFordPlayedIn);
		for (String s : intersection)
			System.out.println("\t"+s);
		System.out.println();
	}
	
	/**
	 * <p>
	 * Requires external loading of data into the triplestore. Afterwards a 
	 * query for companies that have a headquarter in 'New York' and belong to
	 * the 'investment banking' branch is executed where the company is used to
	 * learn who has contributed how much in US-$ to senator 'Orrin Hatch'.
	 * </p>
	 * <p>
	 * This example uses parameter-binding with a single result response
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test3(Graph graph)
	{
		Set<String> query = new LinkedHashSet<String>();
		query.add("?company, headquarters, New_York_New_York");
		query.add("?company, industry, Investment banking");
		query.add("?cont, contributor, ?company");
		query.add("?cont, recipient, Orrin Hatch");
		query.add("?cont, amount, ?dollars");
		
		System.out.println("Query: "+query);
		System.out.println("Result: ");
		
		queryResultHelper(graph.query(query));
	}
	
	/**
	 * <p>
	 * This query requires data to be loaded from a CSV file externally into the
	 * triplestore. Then it traverses all triples that contain a 
	 * with-relationship to find who had a relationship with 'Britney Spears'.
	 * The query furthermore extracts the year the relationship with 'Britney
	 * Spears' ended and looks who started a new relationship in that year.
	 * </p>
	 * <p>
	 * This query uses variable-binding and deals with multiple results. Note 
	 * that the results are permutated for the different relation ID's - Justin
	 * Timberlake was 2 times in relationship with Britney Spears and two times
	 * in relationship with Jenna Dewan. He dated Jenna in the year he broke up
	 * with Britney spears - thats why the result contains this relationship
	 * 4 times. Moreover as <code>?rel2, with, ?name</code> returns both names
	 * of the relationship that started in the breakup-year with Britney Spears,
	 * Justin Timberlake is returned as a member of the relationship for every
	 * relation found - which is again 4 times.
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test4(Graph graph)
	{
		Set<String> query = new LinkedHashSet<String>();
		query.add("?rel1, with, ?person");
		query.add("?rel1, with, Britney Spears");
		query.add("?rel1, end, ?year1");
		query.add("?rel2, with, ?person");
		query.add("?rel2, with, ?name");
		query.add("?rel2, start, ?year1");
		
		System.out.println("Query: "+query);
		System.out.println("Result: ");
		
		queryResultHelper(graph.query(query));
	}
	
	/**
	 * <p>
	 * Requires data to be loaded into the triplestore from an external CSV file
	 * beforehand. It then instantiates a new {@link WestCoastRule} inference
	 * rule that queries if a company is located at the west coast and then
	 * infers a new triple which states that the matching company is 
	 * <code>on_coast west_coast</code> which is automatically applied by the
	 * inferencing rule.
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test5(Graph graph)
	{
		InferenceRule wcr = new WestCoastRule();
		System.out.println("Triplestore for predicate on_coast before applying inference rule: ");
		list(graph.triples("", "on_coast", ""));
		System.out.println("Applying inference rule!");
		graph.applyInference(wcr);
		System.out.println("Triplestore after inference rule has been applied: ");
		list(graph.triples("", "on_coast", ""));
		System.out.println();
	}
	
	/**
	 * <p>
	 * Requires data to be loaded into the triplestore from an external CSV file
	 * beforehand. It then instantiates a new {@link EnemyRule} inference rule 
	 * that queries all persons that are enemies and infers that persons which 
	 * they have a relationship with are also enemies of the enemy person.
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test6(Graph graph)
	{
		EnemyRule er = new EnemyRule();
		System.out.println("Triplestore before applying enemy inference rule: ");
		list(graph.triples("", "enemy", ""));
		System.out.println("Applying inference rule!");
		graph.applyInference(er);
		System.out.println("Triplestore after enemy inference rule has been applied: ");
		list(graph.triples("", "enemy", ""));
		System.out.println();
	}
	
	/**
	 * <p>
	 * Requires data to be loaded into the triplestore beforehand. It then 
	 * instantiates a new {@link ContinentRule} inference rule that queries the
	 * nationality of a person and which continent this country is located at It
	 * then infers a new rule that this person lives on the continent the 
	 * country is located at.
	 * </p>
	 * 
	 * @param graph The triplestore to use
	 */
	public void test7(Graph graph)
	{
		ContinentRule cr = new ContinentRule();
		System.out.println("Triplestore before applying continental inference rule: ");
		list(graph.triples("", "", ""));
		System.out.println("Applying inference rule!");
		graph.applyInference(cr);
		System.out.println("Triplesotre after continental inference rule has been applied: ");
		list(graph.triples("", "", ""));
	}
	
	/**
	 * <p>
	 * Helper-method to print variable-names and their bindings
	 * </p>
	 * 
	 * @param results A {@link Set} which contains the mappings of variables and 
	 *                their bindings
	 */
	public static void queryResultHelper(Set<Map<String, String>> results)
	{
		for (Map<String, String> result : results)
		{
			for (Map.Entry<String, String> keys : result.entrySet())
				System.out.println("Key: "+keys.getKey()+ " Value: "+keys.getValue());
		}
		System.out.println();
	}
	
	/**
	 * <p
	 * >Helper-method to print a {@link Set} of {@link Triple}s conveniently
	 * </p>
	 * 
	 * @param list A {@link Set} of {@link Triple}s that should get printed out
	 */
	private void list(Set<Triple> list)
	{
		String output = "[";
		if (!list.isEmpty())
		{
			for (Triple t : list)
				output += "(" + t.getSubject() + ", " + t.getPredicate() + ", "
						+ t.getObject() + "), ";
			output = output.substring(0, output.lastIndexOf(", "));
		}
		output += "]";
		System.out.println(output);
	}
}
