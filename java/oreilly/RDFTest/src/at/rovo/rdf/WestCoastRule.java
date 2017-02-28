package at.rovo.rdf;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This rule simply checks if the headquarter of a company is located in 
 * San Francisco, Seattle, Los Angeles or Portland. If so those companies are
 * assumed to be located at the west coast of the United States. It therefore
 * create new RDF facts that connect the company with the west_coast using the
 * on_coast predicate.
 * </p>
 * 
 * @author Roman Vottner
 */
public class WestCoastRule implements InferenceRule
{
	@Override
	public Set<Set<String>> getQueries()
	{
		// All companies which have a headquarter in San Francisco, 
		// Seattle, Los Angeles or Portland are considered to be
		// 'on the west coast'
		Set<Set<String>> query = new LinkedHashSet<Set<String>>();
		Set<String> query1 = new LinkedHashSet<String>();
		query1.add("?company, headquarters, San_Francisco_California");
		Set<String> query2 = new LinkedHashSet<String>();
		query2.add("?company, headquarters, Seattle_Washington");
		Set<String> query3 = new LinkedHashSet<String>();
		query3.add("?company, headquarters, Los_Angeles_California");
		Set<String> query4 = new LinkedHashSet<String>();
		query4.add("?company, headquarters, Portland_Oregon");
		
		query.add(query1);
		query.add(query2);
		query.add(query3);
		query.add(query4);
		return query;
	}

	@Override
	public Set<Triple> makeTriples(Map<String, String> binding)
	{
		Triple t = new Triple(binding.get("?company") ,"on_coast", "west_coast");
		Set<Triple> ret = new LinkedHashSet<Triple>();
		ret.add(t);
		return ret;
	}

}
