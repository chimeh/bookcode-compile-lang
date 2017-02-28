package at.rovo.rdf;

import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;

/**
 * <p>
 * This rule simply assumes that the enemy of a person A is also the enemy of 
 * the person A has a relationship with. It therefore creates new RDF facts
 * that the relationship partner is an enemy with the partner's enemy.
 * </p>
 * 
 * @author Roman Vottner
 */
public class EnemyRule implements InferenceRule
{

	@Override
	public Set<Set<String>> getQueries()
	{
		Set<Set<String>> query = new LinkedHashSet<Set<String>>();
		Set<String> query1 = new LinkedHashSet<String>();
		query1.add("?person, enemy, ?enemy");
		query1.add("?rel, with, ?person");
		query1.add("?rel, with, ?partner");
		
		query.add(query1);
		return query;
	}

	@Override
	public Set<Triple> makeTriples(Map<String, String> binding)
	{
		String partner = binding.get("?partner");
		String enemy = binding.get("?enemy");
		Triple t = new Triple(partner,"enemy", enemy);
		Set<Triple> ret = new LinkedHashSet<Triple>();
		ret.add(t);
		return ret;
	}
}
